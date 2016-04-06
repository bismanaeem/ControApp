package nieldw.parental.control;

import nieldw.parental.control.meta.MovieService;
import nieldw.parental.control.meta.TechnicalFailureException;
import nieldw.parental.control.meta.TitleNotFoundException;

import java.util.Comparator;

public class ParentalControlService {

    private final MovieService movieService;
    private final Comparator<String> levelComparator;

    public ParentalControlService(MovieService movieService, Comparator<String> levelComparator) {
        this.movieService = movieService;
        this.levelComparator = levelComparator;
    }

    public boolean isAllowedToWatchMovie(String preferredLevel, String movieId, AdditionalMessageCallback callback) {
        try {
            final String movieParentalControlLevel = movieService.getParentalControlLevel(movieId);
            if (levelComparator.compare(movieParentalControlLevel, preferredLevel) < 0) {
                return true;
            }
        } catch (TitleNotFoundException | TechnicalFailureException e) {
            e.printStackTrace();
        }
        return false;
    }
}
