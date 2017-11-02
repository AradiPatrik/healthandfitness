package bootcamp.developer.webapp.healthAndFitness.cli;

import bootcamp.developer.webapp.healthAndFitness.measurement.WeightCategory;

/**
 * This CommandLineWriter class includes methods for writing output to the console
 */
public class CommandLineWriter {

    private static String WELCOME_MESSAGE =
            "\t##########################################################" + "\n" +
            "\t#### Welcome to The Mighty BMI calculator application ####" + "\n" +
            "\t##########################################################" + "\n";

    private static String INSTRUCTIONS =
            "To get your Bmi first enter your height in either " + "\n" +
            "meters and centimeters [[meters]m [centimeters (optional)]cm]" + "\n" +
            "or feet and inches [[feet]'[inches (optional)]\"]" + "\n" +
            "Then enter your mass in either kilograms [[kilograms]kg]" + "\n" +
            "or in pounds [[pounds]lb]" + "\n" +
            "e.g.: " + "\n" +
            "height>1m 76cm" + "\n" +
            "height>6'2\"" + "\n" +
            "height>1.3m" + "\n" +
            "weight> 200lb" + "\n";

    private static String WEIGHT_PROMPT =
            "weight>";

    private static String HEIGHT_PROMPT =
            "height>";

    private static String DIVIDER =
            "############################################################" + "\n";

    public void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public void printInstructions() {
        System.out.println(INSTRUCTIONS);
    }

    public void printDivider() {
        System.out.print(DIVIDER);
    }

    public void displayWeightPrompt() {
        System.out.print(WEIGHT_PROMPT);
    }

    public void displayHeightPrompt() {
        System.out.print(HEIGHT_PROMPT);
    }

    public void printExceptionMessage(Exception ex) {
        System.out.println(ex.getMessage());
    }

    public void printWeightCategory(WeightCategory category) {
        System.out.println("Your weight category is: " + category);
    }

    public void askToContinue() {
        System.out.println("Would You Like To Continue?(Y/N)");
    }
}
