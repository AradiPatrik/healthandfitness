package bootcamp.developer.webapp.healthAndFitness.application;

import bootcamp.developer.webapp.healthAndFitness.bmi.BMICalculatorComponent;
import bootcamp.developer.webapp.healthAndFitness.cli.InputReader;
import bootcamp.developer.webapp.healthAndFitness.cli.CommandLineWriter;
import bootcamp.developer.webapp.healthAndFitness.measurement.WeightCategory;
import bootcamp.developer.webapp.healthAndFitness.measurement.height.Height;
import bootcamp.developer.webapp.healthAndFitness.measurement.weight.Weight;

import java.io.IOException;

/**
 * This Application class represents a test run for the components
 * It uses every class in the application.
 */
public class Application {

    private InputReader reader;
    private CommandLineWriter writer;
    private BMICalculatorComponent calculator;

    public Application() {
        this.reader = new InputReader(System.in);
        this.writer = new CommandLineWriter();
        this.calculator = new BMICalculatorComponent();
    }

    /**
     * The entry point of the application
     */
    public void start() {
        writer.printWelcomeMessage();
        writer.printInstructions();
        writer.printDivider();
        gameLoop();
    }

    private void gameLoop() {
        do {
            Height height = getHeight();
            Weight weight = getWeight();
            double bmi = calculator.calculateBmi(height, weight);
            WeightCategory weightCategory = WeightCategory.getWeightCategoryFromBMI(bmi);
            writer.printWeightCategory(weightCategory);
            writer.askToContinue();
        } while (getContinueResponse());
    }

    private Height getHeight() {
        try {
            writer.displayHeightPrompt();
            return tryToGetHeight();
        } catch (IOException ex) {
            writer.printExceptionMessage(ex);
            return getHeight();
        }
    }

    private Height tryToGetHeight() throws IOException {
        return reader.getHeightFromCommandLine();
    }

    private Weight getWeight() {
        try {
            writer.displayWeightPrompt();
            return tryToGetWeight();
        } catch (IOException ex) {
            writer.printExceptionMessage(ex);
            return getWeight();
        }
    }

    private Weight tryToGetWeight() throws IOException {
        return reader.getWeightFromCommandLine();
    }

    private boolean getContinueResponse() {
        try {
            return tryToGetContinueResponse();
        } catch (IOException ex) {
            writer.printExceptionMessage(ex);
            return getContinueResponse();
        }
    }

    private boolean tryToGetContinueResponse() throws IOException {
        return reader.getContinueResponse();
    }

}
