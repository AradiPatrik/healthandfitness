package bootcamp.developer.webapp.healthAndFitness.application;

import bootcamp.developer.webapp.healthAndFitness.cli.CommandLineReader;
import bootcamp.developer.webapp.healthAndFitness.cli.CommandLineWriter;
import bootcamp.developer.webapp.healthAndFitness.cli.InputParser;

public class Application {

    private CommandLineReader reader;
    private CommandLineWriter writer;
    private InputParser parser;

    public Application() {
        this.reader = new CommandLineReader();
        this.writer = new CommandLineWriter();
        this.parser = new InputParser();
    }

    public void start() {
        writer.printWelcomeMessage();
        writer.printInstructions();
        writer.displayHeightPrompt();
    }

}
