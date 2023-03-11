package com.github.jonataslaet.controllers;

import com.github.jonataslaet.data.vo.v1.PersonVO;
import com.github.jonataslaet.entities.Person;
import com.github.jonataslaet.services.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/people")
@Tag(name = "People", description = "Endpoints for managing people")
public class PersonController {

  @Autowired
  private PersonService personService;

  @CrossOrigin(origins = "http://localhost:8080")
  @GetMapping(value = "/{personId}",
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
  )
  @Operation(summary = "Finds a person by id", responses = {
      @ApiResponse(
          description = "Success",
          responseCode = "200",
          content = @Content(mediaType = "application/json", schema = @Schema(implementation = PersonVO.class))
      ),
      @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
      @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
      @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
      @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
  })
  public PersonVO getPerson(@PathVariable(value = "personId") @Parameter(description = "The Id of the person to find.") String personId) {
    return personService.findById(Long.valueOf(personId));
  }

  @GetMapping(
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
  )
  @Operation(summary = "Find all people", responses = {
      @ApiResponse(
          description = "Success",
          responseCode = "200",
          content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PersonVO.class)))
      ),
      @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
      @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
      @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
      @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
  })
  public List<PersonVO> getPeople() {
    return personService.findAll();
  }

  @CrossOrigin(origins = {"http://localhost:8080","https://erudio.com.br"})
  @PostMapping(
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
  )
  @Operation(summary = "Adds a new person", responses = {
      @ApiResponse(
          description = "Created",
          responseCode = "201",
          content = @Content(mediaType = "application/json", schema = @Schema(implementation = PersonVO.class))
      ),
      @ApiResponse(description = "Success", responseCode = "200", content = @Content),
      @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
      @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
      @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
      @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
  })
  public PersonVO createPerson(@RequestBody PersonVO personVO) {
    return personService.createPerson(personVO);
  }

  @PutMapping(value = "/{personId}",
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @Operation(summary = "Updates a person", responses = {
      @ApiResponse(
          description = "No content",
          responseCode = "204",
          content = @Content
      ),
      @ApiResponse(description = "Success", responseCode = "200", content = @Content),
      @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
      @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
      @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
      @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
  })
  public PersonVO updatePerson(@PathVariable(value = "personId") @Parameter(description = "The Id of the person to update.") String personId, @RequestBody  @Parameter(description = "The body of the updated person.") PersonVO person) {
    return personService.updatePerson(Long.valueOf(personId), person);
  }

  @DeleteMapping(value = "/{personId}",
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
  )
  @Operation(summary = "Deletes a person", responses = {
      @ApiResponse(
          description = "No content",
          responseCode = "204",
          content = @Content
      ),
      @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
      @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
      @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
      @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
  })
  public ResponseEntity<?> deletePerson(@PathVariable(value = "personId") @Parameter(description = "The Id of the person to delete.") String personId) {
    personService.deletePerson(Long.valueOf(personId));
    return ResponseEntity.noContent().build();
  }
}
