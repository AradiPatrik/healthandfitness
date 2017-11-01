package bootcamp.developer.webapp.healthAndFitness.cli;

import ru.lanwen.verbalregex.VerbalExpression;
import static ru.lanwen.verbalregex.VerbalExpression.regex;

public class InputParser {

    private static final VerbalExpression.Builder floatingPoint = regex()
            .capt().digit().oneOrMore().endCapt()
            .maybe(".")
            .maybe(regex().capt().digit().oneOrMore().endCapt());

    private static final VerbalExpression.Builder metres = regex()
            .add(floatingPoint).add(regex().then("m").or("M"));

    private static final VerbalExpression.Builder centimetres = regex()
            .add(floatingPoint).add(regex().then("cm").or("CM").or("cM").or("Cm"));

    private static final VerbalExpression.Builder feet = regex()
            .add(floatingPoint).add(regex().then("'"));

    private static final VerbalExpression.Builder inches = regex()
            .add(floatingPoint).add(regex().then("\""));

    private static final VerbalExpression.Builder kilograms = regex()
            .add(floatingPoint).add(regex().then("kg").or("Kg").or("kG").or("KG"));

    private static final VerbalExpression.Builder pounds = regex()
            .add(floatingPoint).add(regex().then("lb").or("Lb").or("lB").or("LB"));

    private static final VerbalExpression metricHeight = regex()
            .add(metres).maybe(" ").add(regex().maybe(centimetres)).build();

    private static final VerbalExpression imperialHeight = regex().add(feet).maybe(" ").add(regex().maybe(inches)).build();

    public boolean isValidHeight(String input) {
        return metricHeight.testExact(input) || imperialHeight.testExact(input);
    }

    public boolean isValidWeight(String input) {
        return kilograms.build().testExact(input) || pounds.build().testExact(input);
    }

    public String getInches(String input) {
        return inches.build().getText(input);
    }

    public String getMetres(String input) {
        return metres.build().getText(input);
    }

    public String getCentimetres(String input) {
        return centimetres.build().getText(input);
    }

    public String getFeet(String input) {
        return feet.build().getText(input);
    }
}
