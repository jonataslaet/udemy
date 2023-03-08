package com.github.jonataslaet.controllers;

import com.github.jonataslaet.data.vo.v1.BookVO;
import com.github.jonataslaet.data.vo.v1.PersonVO;
import com.github.jonataslaet.services.BookService;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/books")
@Tag(name = "Books", description = "Endpoints for managing books")
public class BookController {

  @Autowired
  private BookService bookService;

  @GetMapping(value = "/{bookId}",
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
  )
  @Operation(summary = "Finds a book by id", responses = {
      @ApiResponse(
          description = "Success",
          responseCode = "200",
          content = @Content(mediaType = "application/json", schema = @Schema(implementation = BookVO.class))
      ),
      @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
      @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
      @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
      @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
  })
  public BookVO getBookById(@PathVariable(value = "bookId") @Parameter(description = "The Id of the book to find.") String bookId) {
    return bookService.findById(Long.valueOf(bookId));
  }

  @GetMapping(
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
  )
  @Operation(summary = "Find all books", responses = {
      @ApiResponse(
          description = "Success",
          responseCode = "200",
          content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BookVO.class)))
      ),
      @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
      @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
      @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
      @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
  })
  public List<BookVO> getPeople() {
    return bookService.findAll();
  }

  @PostMapping(
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
  )
  @Operation(summary = "Adds a new book", responses = {
      @ApiResponse(
          description = "Created",
          responseCode = "201",
          content = @Content(mediaType = "application/json", schema = @Schema(implementation = BookVO.class))
      ),
      @ApiResponse(description = "Success", responseCode = "200", content = @Content),
      @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
      @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
      @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
      @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
  })
  public BookVO createBook(@RequestBody BookVO bookVO) {
    return bookService.createBook(bookVO);
  }

  @PutMapping(value = "/{bookId}",
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @Operation(summary = "Updates a book", responses = {
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
  public BookVO updateBook(@PathVariable(value = "bookId") @Parameter(description = "The Id of the book to update.") String bookId, @RequestBody  @Parameter(description = "The body of the updated book.") BookVO bookVO) {
    return bookService.updateBook(Long.valueOf(bookId), bookVO);
  }

  @DeleteMapping(value = "/{bookId}",
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
  )
  @Operation(summary = "Deletes a book", responses = {
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
  public ResponseEntity<?> deleteBook(@PathVariable(value = "bookId") @Parameter(description = "The Id of the book to delete.") String bookId) {
    bookService.deleteBook(Long.valueOf(bookId));
    return ResponseEntity.noContent().build();
  }
}
