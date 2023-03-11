package com.github.jonataslaet.integrationtests.cors;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.jonataslaet.configs.TestConfigs;
import com.github.jonataslaet.integrationtests.testcontainers.AbstractIntegrationTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CorsIntegrationTest extends AbstractIntegrationTest {

  @Test
  public void shouldForbidRequisitionForCreatePerson() {

    RequestSpecification spefication = new RequestSpecBuilder()
        .addHeader(TestConfigs.HEADER_PARAM_ORIGIN, TestConfigs.FORBIDDEN_ORIGIN)
        .setBasePath("/api/people")
        .setPort(TestConfigs.SERVER_PORT)
        .addFilters(Arrays.asList(new RequestLoggingFilter(LogDetail.ALL),
            new ResponseLoggingFilter(LogDetail.ALL))).build();

    var content =
        given()
            .spec(spefication)
            .contentType(TestConfigs.CONTENT_TYPE_JSON)
            .body(Mockito.anyString())
            .when().post().then().statusCode(HttpStatus.FORBIDDEN.value()).extract().body().asString();

    assertNotNull(content);
  }
}
