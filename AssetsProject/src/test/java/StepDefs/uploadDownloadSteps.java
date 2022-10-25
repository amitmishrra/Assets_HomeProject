package StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.*;

import static io.restassured.RestAssured.given;

public class uploadDownloadSteps {
    @When("upload file")
    public static void uploadFile(){
        given().
                multiPart("file", new File("test.txt")).
        when().
                post("https://02aa69f4-a2a8-4efe-8db0-b258a93f6d36.mock.pstmn.io/addFile").
        then().
                log().body().
                assertThat().
                statusCode(200);

    }
    @Then("download file")
    public static void downloadFile() throws IOException {
            byte[] bytes= given().
                    when().
                    get("https://github.com/amitmishrra/JS-Questions/archive/refs/heads/main.zip").
                    then().
                    extract().
                    asByteArray();

        OutputStream os = new FileOutputStream(new File("main.zip"));
        os.write(bytes);
        os.close();
    }

}
