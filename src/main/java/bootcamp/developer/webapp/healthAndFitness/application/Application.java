package bootcamp.developer.webapp.healthAndFitness.application;

import bootcamp.developer.webapp.healthAndFitness.cli.InputReader;
import bootcamp.developer.webapp.healthAndFitness.cli.CommandLineWriter;
import bootcamp.developer.webapp.healthAndFitness.measurement.height.Height;

import java.io.IOException;

public class Application {

    private InputReader reader;
    private CommandLineWriter writer;

    public Application() {
        this.reader = new InputReader(System.in);
        this.writer = new CommandLineWriter();
    }

    public void start() {
        writer.printWelcomeMessage();
        writer.printInstructions();
    }

    public void gameLoop() {
        boolean appShouldClose = false;
        do {
            writer.displayHeightPrompt();

        } while (!appShouldClose);
    }

    public Height tryToGetHeight() {
        try {
            return getHeight();
        } catch (IOException ex) {
            tryToGetHeight();
        }
        return null; // never reached
    }

    public Height getHeight() throws IOException{
        return reader.getHeightFromCommandLine();
    }

}
