package bootcamp.developer.webapp.healthAndFitness.cli;

import bootcamp.developer.webapp.healthAndFitness.measurement.height.Height;
import bootcamp.developer.webapp.healthAndFitness.measurement.weight.Weight;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *  The InputReader class contains methods for reading the input
 *  from any input stream
 */
public class InputReader {
    Scanner scanner;
    InputParser parser;

    private static final String WRONG_HEIGHT_FORMAT = "Invalid height, height must contain meters or feet, " +
            "and after that should optionally contain inches or centimetres, see examples above";

    private static final String WRONG_WEIGHT_FORMAT = "Invalid weight, weight must contain either kilograms" +
            "or pounds (indicated by lb or kg), see examples above";

    /**
     *
     * @param inputStream
     *                  The stream from we get the inputs
     */
    public InputReader(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
        this.parser = new InputParser();
    }

    /**
     *
     * @return
     *        the weight from the input
     * @throws IOException
     */
    public Weight getWeightFromCommandLine() throws IOException {
        String weight = scanner.nextLine();
        if (parser.isValidWeight(weight)) {
            return parser.getWeightValue(weight);
        } else {
            throw new IOException(WRONG_WEIGHT_FORMAT);
        }
    }

    /**
     *
     * @return
     *        the height from the input
     * @throws IOException
     */
    public Height getHeightFromCommandLine() throws IOException {
        String height = scanner.nextLine();
        if (parser.isValidHeight(height)) {
            return parser.getHeightValue(height);
        } else {
            throw new IOException(WRONG_HEIGHT_FORMAT);
        }
    }

    /**
     *
     * @return
     *        true if the application should continue
     * @throws IOException
     */
    public boolean getContinueResponse() throws IOException {
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("Y")) {
            return true;
        } else if(response.equalsIgnoreCase("N")) {
            return false;
        } else {
            throw new IOException("Response should be Y or N");
        }
    }
}
