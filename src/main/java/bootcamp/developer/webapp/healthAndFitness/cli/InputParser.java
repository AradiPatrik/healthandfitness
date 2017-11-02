package bootcamp.developer.webapp.healthAndFitness.cli;

import bootcamp.developer.webapp.healthAndFitness.measurement.height.*;
import bootcamp.developer.webapp.healthAndFitness.measurement.weight.Kilogram;
import bootcamp.developer.webapp.healthAndFitness.measurement.weight.Pound;
import bootcamp.developer.webapp.healthAndFitness.measurement.weight.Weight;
import ru.lanwen.verbalregex.VerbalExpression;
import static ru.lanwen.verbalregex.VerbalExpression.regex;

/**
 * The class InputParser includes methods for validating
 * and parsing input. It is able to convert valid input to Weight or
 * to Height values
 */
public class InputParser {

    /**Below are the regular exception builders*/

    private static final VerbalExpression.Builder floatingPointBuilder = regex()
            .capt().digit().oneOrMore().endCapt()
            .maybe(".")
            .maybe(regex().capt().digit().oneOrMore().endCapt());

    private static final VerbalExpression.Builder metresBuilder = regex()
            .add(floatingPointBuilder).add(regex().then("m").or("M"));

    private static final VerbalExpression.Builder centimetresBuilder = regex()
            .add(floatingPointBuilder).add(regex().then("cm").or("CM").or("cM").or("Cm"));

    private static final VerbalExpression.Builder feetBuilder = regex()
            .add(floatingPointBuilder).add(regex().then("'"));

    private static final VerbalExpression.Builder inchesBuilder = regex()
            .add(floatingPointBuilder).add(regex().then("\""));

    private static final VerbalExpression.Builder kilogramsBuilder = regex()
            .add(floatingPointBuilder).add(regex().then("kg").or("Kg").or("kG").or("KG"));

    private static final VerbalExpression.Builder poundsBuilder = regex()
            .add(floatingPointBuilder).add(regex().then("lb").or("Lb").or("lB").or("LB"));

    /**Below are the regular expressions built by the above regex builders*/

    private static final VerbalExpression metricHeight = regex()
            .add(metresBuilder).maybe(" ").add(regex().maybe(centimetresBuilder)).build();

    private static final VerbalExpression imperialHeight =
            regex().add(feetBuilder).maybe(" ").add(regex().maybe(inchesBuilder)).build();

    private static final VerbalExpression metricWeight = kilogramsBuilder.build();

    private static final VerbalExpression imperialWeight = poundsBuilder.build();

    private static final VerbalExpression floatingPoint = floatingPointBuilder.build();

    /**
     * validates input
     * @param input
     *          the input
     * @return
     *          if the input represents either a metric or an imperial height
     */
    public boolean isValidHeight(String input) {
        return metricHeight.testExact(input) || imperialHeight.testExact(input);
    }

    /**
     *
     * @param input
     *          the input
     * @return
     *          true if the input represents either a metric or an imperial weight
     */
    public boolean isValidWeight(String input) {
        return metricWeight.testExact(input) || imperialWeight.testExact(input);
    }

    /**
     *
     * @param input
     *              the input in any valid format
     * @return
     *         the weight read from the input
     */
    Weight getWeightValue(String input) {
        String weight = floatingPoint.getText(input);
        if (!metricWeight.getText(input).isEmpty()) {
            return new Kilogram(Double.parseDouble(weight));
        } else {
            return new Pound(Double.parseDouble(weight));
        }
    }

    /**
     *
     * @param input
     *              the input in any valid format
     * @return
     *        the height read from the input
     */
    public Height getHeightValue(String input) {
        return addHeightValues(input);
    }


    String getInchesAsString(String input) {
        return inchesBuilder.build().getText(input);
    }

    String getMetresAsString(String input) {
        return metresBuilder.build().getText(input);
    }

    String getCentimetresAsString(String input) {
        return centimetresBuilder.build().getText(input);
    }

    String getFeetAsString(String input) {
        return feetBuilder.build().getText(input);
    }

    private Height addHeightValues(String input) {
        return getInches(input).add(getFeet(input)).add(getMetres(input)).add(getCentimetres(input));
    }

    private Height getInches(String input) {
        String inchPart = floatingPoint.getText(getInchesAsString(input));
        if (!inchPart.isEmpty()) {
            return new Inch(Double.parseDouble(inchPart));
        } else {
            return new Inch(0);
        }
    }

    private Height getFeet(String input) {
        String feetPart = floatingPoint.getText(getFeetAsString(input));
        if (!feetPart.isEmpty()) {
            return new Foot(Double.parseDouble(feetPart));
        } else {
            return new Foot(0);
        }
    }

    private Height getMetres(String input) {
        String metrePart = floatingPoint.getText(getMetresAsString(input));
        if (!metrePart.isEmpty()) {
            return new Metre(Double.parseDouble(metrePart));
        } else {
            return new Metre(0);
        }
    }

    private Height getCentimetres(String input) {
        String centimetrePart = floatingPoint.getText(getCentimetresAsString(input));
        if (!centimetrePart.isEmpty()) {
            return new Centimetre(Double.parseDouble(centimetrePart));
        } else {
            return new Centimetre(0);
        }
    }
}
