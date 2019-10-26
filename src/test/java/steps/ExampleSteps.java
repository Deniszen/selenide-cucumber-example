package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GooglePage;

public class ExampleSteps {

    private GooglePage googlePage = new GooglePage();

    @Given("user open google service")
    public void user_open_google_service() {
        googlePage.checkLogo();
        googlePage.checkSearchField();
        googlePage.checkSearchButton();
        googlePage.checkDoodleButton();
    }

    @When("user typed {string} into search string")
    public void user_typed_into_search_string(String text) {
        googlePage.enterSearchText(text);
    }

    @Then("user has seen {int} results on page")
    public void user_has_seen_results_on_page(int count) {
        googlePage.checkResults(count);
    }

    @And("user saw a {int} link to {string}")
    public void user_saw_a_link_to_Wikipedia(int number, String domainName) {
        googlePage.checkDomain(number, domainName);
    }
}
