package nieldw.parental.control.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nieldw.parental.control.row.MovieRow;

import java.util.List;

public class StepDefinitions {

    @Given("^parental control levels (.*)$")
    public void parental_control_levels_U_PG_(List<String> levels) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @And("^the following movies are offered by the service:$")
    public void the_following_movies_are_offered_by_the_service(List<MovieRow> movies) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @And("^the customer's parental control level preference is ([^\"]*)$")
    public void the_customer_s_parental_control_level_preference_is(String level) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @When("^the customer requests to watch \"([^\"]*)\"$")
    public void the_customer_requests_to_watch(String movie) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^she is allowed to watch it$")
    public void she_is_allowed_to_watch_it() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }
}
