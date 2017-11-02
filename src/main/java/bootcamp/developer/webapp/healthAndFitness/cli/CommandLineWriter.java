package bootcamp.developer.webapp.healthAndFitness.cli;

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
            "\nweight>";

    private static String HEIGHT_PROMPT =
            "\nheight>";

    public void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public void printInstructions() {
        System.out.println(INSTRUCTIONS);
    }

    public void displayWeightPrompt() {
        System.out.print(WEIGHT_PROMPT);
    }

    public void displayHeightPrompt() {
        System.out.print(HEIGHT_PROMPT);
    }
}
