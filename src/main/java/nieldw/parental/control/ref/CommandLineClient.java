package nieldw.parental.control.ref;

import nieldw.parental.control.ParentalControlService;

import java.io.*;

public class CommandLineClient {

    private PrintStream out;
    private BufferedReader in;
    private ParentalControlService parentalControlService;

    public CommandLineClient(PrintStream out, InputStream in, ParentalControlService parentalControlService) {
        this.out = out;
        this.in = new BufferedReader(new InputStreamReader(in));
        this.parentalControlService = parentalControlService;
    }

    public void start() throws IOException {
        out.print("Welcome to the Parental Control Service!\n" +
                "Please enter your Parental Control Level preference:");
        final String preferredLevel = in.readLine();

        out.print("Please enter the movie id you would like to see:");
        final String movieId = in.readLine();

        final boolean allowed = parentalControlService.isAllowedToWatchMovie(preferredLevel, movieId, out::println);

        out.println(allowed ?
                "You may watch this movie!" :
                "You are not allowed to watch this movie.");
    }
}
