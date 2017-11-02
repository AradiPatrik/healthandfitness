package bootcamp.developer.webapp.healthAndFitness.cli;

import bootcamp.developer.webapp.healthAndFitness.measurement.height.Height;
import bootcamp.developer.webapp.healthAndFitness.measurement.weight.Weight;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class InputReader {
    Scanner scanner;
    InputParser parser;

    public InputReader(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
        this.parser = new InputParser();
    }

    public Weight getWeightFromCommandLine() throws IOException {
        return null;
    }

    public Height getHeightFromCommandLine() throws IOException {
        String height = scanner.nextLine();
        if (parser.isValidHeight(height)) {
            return parser.getHeightValue(height);
        } else {
            throw new IOException("Wrong height format: " + height);
        }
    }
}
