package br.com.meowlenium.testcases;

import br.com.meowlenium.datafactory.ReqResDataFactory;
import br.com.meowlenium.framework.utils.bases.BaseRest;
import br.com.meowlenium.framework.utils.Rest;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReqResTest extends BaseRest
{
    private Rest rest;

    @BeforeTest
    public void setUpTest() {
        this.rest = new Rest("https://reqres.in");
    }

    @Test(
            description = "Valida o retorno de status code 200",
            priority = 1
    )
    public void singleUserStatusCode200()
    {
        this.rest.get("/api/users/2", HttpStatus.SC_OK);
    }

    @Test(
            description = "Valida o retorno de status code 200 e Json Schema",
            priority = 2
    )
    public void singleUserStatusCode200AndJsonSchema()
    {
        this.rest.get("/api/users/2", HttpStatus.SC_OK).
                body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/SingleUser.json"));
    }

    @Test(
            description = "Valida o retorno de status code 404",
            priority = 3
    )
    public void singleUserNotFoundStatusCode404()
    {
        this.rest.get("/api/users/23", HttpStatus.SC_NOT_FOUND);
    }

    @Test(
            description = "Valida o retorno de status code 201",
            priority = 4
    )
    public void createStatusCode201()
    {
        this.rest.post("/api/users", HttpStatus.SC_CREATED, ReqResDataFactory.create().getClass());
    }

    @Test(
            description = "Valida o retorno de status code 201 e Json Schema",
            priority = 5
    )
    public void createStatusCode201AndJsonSchema()
    {
        this.rest.post("/api/users", HttpStatus.SC_CREATED, ReqResDataFactory.create().getClass()).
                body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/CreateAndUpdate.json"));
    }

    @Test(
            description = "Valida o retorno de status code 200",
            priority = 6
    )
    public void putStatusCode200()
    {
        this.rest.put("/api/users/2", HttpStatus.SC_OK, ReqResDataFactory.create().getClass());
    }

    @Test(
            description = "Valida o retorno de status code 200 e Json Schema",
            priority = 7
    )
    public void putStatusCode200AndJsonSchema()
    {
        this.rest.put("/api/users/2", HttpStatus.SC_OK, ReqResDataFactory.create().getClass()).
                body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/CreateAndUpdate.json"));
    }

    @Test(
            description = "Valida o retorno de status code 200",
            priority = 8
    )
    public void patchStatusCode200()
    {
        this.rest.patch("/api/users/2", HttpStatus.SC_OK, ReqResDataFactory.create().getClass());
    }

    @Test(
            description = "Valida o retorno de status code 200 e Json Schema",
            priority = 9
    )
    public void patchStatusCode200AndJsonSchema()
    {
        this.rest.patch("/api/users/2", HttpStatus.SC_OK, ReqResDataFactory.create().getClass()).
                body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/CreateAndUpdate.json"));
    }

    @Test(
            description = "Valida o retorno de status code 204",
            priority = 10
    )
    public void deleteStatusCode204()
    {
        this.rest.delete("/api/users/2", HttpStatus.SC_NO_CONTENT);
    }
}