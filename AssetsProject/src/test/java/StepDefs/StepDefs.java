package StepDefs;

import POM.Fetch_Store_Validate;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs{
    @Given("Fetch API")
    public static void fetch_api(){
        Fetch_Store_Validate.fetch();
    }

    @When("Store response")
    public static void store_response(){
        Fetch_Store_Validate.storeResponse();
    }

    @Then("Validate response")
    public static void validate_response(){
        Fetch_Store_Validate.validateResponse();
    }
}
