package nieldw.parental.control.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nieldw.parental.control.ParentalControlLevelComparator;
import nieldw.parental.control.ParentalControlService;
import nieldw.parental.control.meta.MovieService;
import nieldw.parental.control.row.MovieRow;
import nieldw.parental.control.stubs.StubMoviePresenter;
import nieldw.parental.control.stubs.StubMovieService;

import java.util.*;

import static java.util.stream.Collectors.toMap;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;

public class StepDefinitions {

    private List<String> validLevels;
    private Map<String, String> movieNameToIdMap;
    private MovieService stubMovieService;
    private String preferredLevel;
    private StubMoviePresenter stubMoviePresenter;
    private ParentalControlLevelComparator levelComparator;

    @Before
    public void init() {
        validLevels = new ArrayList<>();
        movieNameToIdMap = new HashMap<>();
        stubMovieService = null;
        preferredLevel = null;
        stubMoviePresenter = null;
        levelComparator = null;
    }

    @Given("^parental control levels (.*)$")
    public void parental_control_levels(List<String> levels) throws Throwable {
        validLevels = levels;
        levelComparator = new ParentalControlLevelComparator(validLevels);
    }

    @And("^the following movies are offered by the service:$")
    public void the_following_movies_are_offered_by_the_service(List<MovieRow> movies) throws Throwable {
        assertThat("One or movie has a rating that is not in the list of valid rating.",
                movies.stream().allMatch(movie -> validLevels.contains(movie.getRating())), is(true));

        movieNameToIdMap.putAll(movies.stream()
                .collect(toMap(MovieRow::getName, MovieRow::getId)));

        stubMovieService = new StubMovieService(movies);
    }

    @Given("^the customer's parental control level preference is ([^\"]*)$")
    public void the_customer_s_parental_control_level_preference_is(String level) throws Throwable {
        preferredLevel = level;
    }

    @When("^the customer requests to watch \"([^\"]*)\"$")
    public void the_customer_requests_to_watch(String movie) throws Throwable {
        assertThat("At least one movie must be offered", stubMovieService, is(notNullValue()));
        assertThat("At least one movie must be offered", movieNameToIdMap, is(notNullValue()));
        assertThat("Preferred parental control level must be set", preferredLevel, is(not(nullValue())));

        stubMoviePresenter = new StubMoviePresenter(movieNameToIdMap, preferredLevel);
        final ParentalControlService parentalControlService =
                new ParentalControlService(stubMovieService, levelComparator);
        stubMoviePresenter.setParentalControlService(parentalControlService);

        stubMoviePresenter.requestToWatchMovie(movie);
    }

    @Then("^she is allowed to watch it$")
    public void she_is_allowed_to_watch_it() throws Throwable {
        assertThat("User is allowed to watch movie", stubMoviePresenter.isAllowedWatchingMovie(), is(true));
    }

    @Then("^she is not allowed to watch it$")
    public void she_is_not_allowed_to_watch_it() throws Throwable {
        assertThat("User is not allowed to watch movie", stubMoviePresenter.isAllowedWatchingMovie(), is(false));
    }
}
