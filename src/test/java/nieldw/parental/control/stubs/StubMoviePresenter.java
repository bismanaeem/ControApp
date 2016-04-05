package nieldw.parental.control.stubs;

import nieldw.parental.control.MoviePresenter;
import nieldw.parental.control.ParentalControlService;

import java.util.Map;

public class StubMoviePresenter implements MoviePresenter {

    private ParentalControlService parentalControlService;
    private Map<String, String> movieNameToIdMap;
    private String preferredLevel;
    private boolean allowWatching;
    private boolean allowWatchingResponseReceived;

    public StubMoviePresenter(
            Map<String, String> movieNameToIdMap,
            String preferredLevel) {

        this.movieNameToIdMap = movieNameToIdMap;
        this.preferredLevel = preferredLevel;
    }

    public void setParentalControlService(ParentalControlService parentalControlService) {
        this.parentalControlService = parentalControlService;
    }

    @Override
    public void requestToWatchMovie(String name) {
        parentalControlService.isAllowedToWatchMovie(preferredLevel, movieNameToIdMap.get(name));
    }

    @Override
    public void allowWatchingMovie() {
        allowWatchingResponseReceived = true;
        allowWatching = true;
    }

    @Override
    public void showErrorMessage(String message) {

    }

    public boolean isAllowedWatchingMovie() {
        return allowWatching;
    }

    public boolean isAllowWatchingResponseReceived() {
        return allowWatchingResponseReceived;
    }
}
