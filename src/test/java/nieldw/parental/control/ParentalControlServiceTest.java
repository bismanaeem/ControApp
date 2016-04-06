package nieldw.parental.control;

import nieldw.parental.control.meta.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Comparator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ParentalControlServiceTest {

    @Mock
    private AdditionalMessageCallback additionalMessageCallback;
    @Mock
    private MovieService movieService;
    @Mock
    private Comparator<String> levelComparator;

    private ParentalControlService service;

    @Test
    public void isAllowedToWatchMovieWithMovieRatingLowerThanUserPreference_shouldAllowWatching() throws Exception {
        // Set up fixture
        service = new ParentalControlService(movieService, levelComparator);

        // Set expectations
        when(movieService.getParentalControlLevel("some movie id")).thenReturn("PG");
        when(levelComparator.compare("PG", "12")).thenReturn(-1);

        // Exercise SUT
        final boolean result = service.isAllowedToWatchMovie("12", "some movie id", additionalMessageCallback);

        // Verify behaviour
        assertThat(result, is(true));
        verifyZeroInteractions(additionalMessageCallback);
    }
}