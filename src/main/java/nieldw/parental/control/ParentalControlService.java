package nieldw.parental.control;

import nieldw.parental.control.meta.MovieService;

public class ParentalControlService {

    public ParentalControlService(MovieService movieService) {
    }

    public boolean isAllowedToWatchMovie(String preferredLevel, String movieId, AdditionalMessageCallback callback) {
        return false;
    }
}
