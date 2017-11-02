package bootcamp.developer.webapp.healthAndFitness.cli;

import bootcamp.developer.webapp.healthAndFitness.measurement.height.*;
import ru.lanwen.verbalregex.VerbalExpression;
import static ru.lanwen.verbalregex.VerbalExpression.regex;

public class InputParser {

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

    private static final VerbalExpression metricHeight = regex()
            .add(metresBuilder).maybe(" ").add(regex().maybe(centimetresBuilder)).build();

    private static final VerbalExpression imperialHeight = regex().add(feetBuilder).maybe(" ").add(regex().maybe(inchesBuilder)).build();

    private static final VerbalExpression floatingPoint = floatingPointBuilder.build();

    public boolean isValidHeight(String input) {
        return metricHeight.testExact(input) || imperialHeight.testExact(input);
    }

    public boolean isValidWeight(String input) {
        return kilogramsBuilder.build().testExact(input) || poundsBuilder.build().testExact(input);
    }

    public String getInchesAsString(String input) {
        return inchesBuilder.build().getText(input);
    }

    public String getMetresAsString(String input) {
        return metresBuilder.build().getText(input);
    }

    public String getCentimetresAsString(String input) {
        return centimetresBuilder.build().getText(input);
    }

    public String getFeetAsString(String input) {
        return feetBuilder.build().getText(input);
    }

    public Height getHeightValue(String input) {
        return addHeightValues(input);
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
