package nieldw.parental.control;

import nieldw.parental.control.meta.MovieService;

public class ParentalControlService {

    public ParentalControlService(MoviePresenter stubMoviePresenter, MovieService movieService) {
    }

    public boolean isAllowedToWatchMovie(String preferredLevel, String movieId) {
        return false;
    }
}
