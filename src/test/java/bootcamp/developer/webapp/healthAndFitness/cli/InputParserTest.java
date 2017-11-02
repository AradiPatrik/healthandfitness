package bootcamp.developer.webapp.healthAndFitness.cli;

import org.assertj.core.data.Offset;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class InputParserTest {
    private InputParser parser;

    private static Offset<Double> ACCURACY = Offset.offset(0.0001);

    @Before()
    public void setUp() {
        parser = new InputParser();
    }

    @Test()
    public void testEmptyStringIsInvalidInput() {
        assertThat(parser.isValidHeight("")).isFalse();
    }

    @Test()
    public void testParserShouldRecognizeLonelyNumbers() {
        assertThat(parser.isValidHeight("10.0"));
    }

    @Test
    public void testParserShouldRecognizeLonelyMetres() {
        assertThat(parser.isValidHeight("1M")).isTrue();
    }

    @Test
    public void testParserShouldRecognizeLonelyFeet() {
        assertThat(parser.isValidHeight("1'")).isTrue();
    }

    @Test
    public void testParserShouldRecognizeMajorAndMinor() {
        assertThat(parser.isValidHeight("1m 20cm")).isTrue();
    }

    @Test
    public void testParserShouldNotRecognizeLonelyMinorUnits() {
        assertThat(parser.isValidHeight("20cm")).isFalse();
    }

    @Test
    public void testParserShouldNotUseSpaceBetweenUnits() {
        assertThat(parser.isValidHeight("1m20cm")).isTrue();
    }

    @Test
    public void testParserShouldAcceptImperialUnitsWithoutSpaces() {
        assertThat(parser.isValidHeight("6'2\"")).isTrue();
    }

    @Test
    public void testParserShouldAcceptImperialUnitsWithSpaceBetweenThem() {
        assertThat(parser.isValidHeight("6' 2\"")).isTrue();
    }

    @Test
    public void testParserShouldAcceptFloatingPointNumbersForAllOfTheParameters() {
        assertThat(parser.isValidHeight("3.2m32.12cm")).isTrue();
    }

    @Test
    public void testParserShouldAcceptKilograms() {
        assertThat(parser.isValidWeight("32Kg")).isTrue();
    }

    @Test
    public void testParserShouldAcceptPounds() {
        assertThat(parser.isValidWeight("32lB")).isTrue();
    }

    @Test
    public void testParserShouldDeniInputWithExtraCharactersAfterWeight() {
        assertThat(parser.isValidWeight("32kg 20cm")).isFalse();
    }

    @Test
    public void testParserShouldDeniInputWhenKilogramsFollowMetres() {
        assertThat(parser.isValidWeight("32m 28kg")).isFalse();
    }

    @Test
    public void testGetInchesShouldReturnInchPartOfInput() {
        assertThat(parser.getInchesAsString("6'2\"")).isEqualToIgnoringCase("2\"");
    }

    @Test
    public void testGetInchesShouldReturnEmptyStringWheThereIsNoInchPart() {
        assertThat(parser.getInchesAsString("32m44cm")).isEmpty();
    }

    @Test
    public void testGetMetersShouldReturnMetrePartOfInput() {
        assertThat(parser.getMetresAsString("32m44cm")).isEqualToIgnoringCase("32m");
    }

    @Test
    public void testGetMetersShouldReturnEmptyStringWhenMeterPartOfInputMissing() {
        assertThat(parser.getMetresAsString("43cm")).isEmpty();
    }

    @Test
    public void testGetCentimetresShouldReturnCentimetrePartOfInput() {
        assertThat(parser.getCentimetresAsString("32m43.83cm")).isEqualToIgnoringCase("43.83cm");
    }

    @Test
    public void testGetFeetShouldReturnFeetPartOfInput() {
        assertThat(parser.getFeetAsString("32.23'11\"")).isEqualToIgnoringCase("32.23'");
    }

    @Test
    public void testParserShouldReturnAHeightOfOneMetresWhenGivenOneMetresAsInput() {
        assertThat(parser.getHeightValue("1m").getMetres()).isCloseTo(1.0, ACCURACY);
    }

    @Test
    public void testParserShouldWorkWhenUsedWithMultipleMetricHeightUnits() {
        assertThat(parser.getHeightValue("1m 20cm").getMetres()).isCloseTo(1.2, ACCURACY);
    }

    @Test
    public void testParserShouldReturnAHeightOfOneFootWhenGivenOneFootAsInput() {
        assertThat(parser.getHeightValue("6'").getFeet()).isCloseTo(6, ACCURACY);
    }

    @Test
    public void testParserShouldWorkWhenUsedWithMultipleImperialHeightUnits() {
        assertThat(parser.getHeightValue("6'6\"").getFeet()).isCloseTo(6.5, ACCURACY);
    }

    @Test
    public void testParserShouldReturnAWeightOfOneKilogramGivenOneKilogramAsInput() {
        assertThat(parser.getWeightValue("1kg").getKilograms()).isCloseTo(1, ACCURACY);
    }

    @Test
    public void testParserShouldReturnAWeightOfTwoPoundsWehnGivenTwoPoundsAsInput() {
        assertThat(parser.getWeightValue("2'").getPounds()).isCloseTo(2, ACCURACY);
    }
}
