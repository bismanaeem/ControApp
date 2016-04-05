package nieldw.parental.control;

public interface MoviePresenter {
    void requestToWatchMovie(String name);

    void allowWatchingMovie();

    void showErrorMessage(String message);
}
