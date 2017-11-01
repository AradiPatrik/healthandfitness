package bootcamp.developer.webapp.healthAndFitness.cli;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class InputParserTest {
    private InputParser parser;

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
    public void testParserShouldDenieInputWithExtraCharactersAfterWeight() {
        assertThat(parser.isValidWeight("32kg 20cm")).isFalse();
    }

    @Test
    public void testGetInchesShouldReturnInchPartOfInput() {
        assertThat(parser.getInches("6'2\"")).isEqualToIgnoringCase("2\"");
    }

    @Test
    public void testGetInchesShouldReturnEmptyStringWheThereIsNoInchPart() {
        assertThat(parser.getInches("32m44cm")).isEmpty();
    }

    @Test
    public void testGetMetersShouldReturnMetrePartOfInput() {
        assertThat(parser.getMetres("32m44cm")).isEqualToIgnoringCase("32m");
    }

    @Test
    public void testGetMetersShouldReturnEmptyStringWhenMeterPartOfInputMissing() {
        assertThat(parser.getMetres("43cm")).isEmpty();
    }

    @Test
    public void testGetCentimetresShouldReturnCentimetrePartOfInput() {
        assertThat(parser.getCentimetres("32m43.83cm")).isEqualToIgnoringCase("43.83cm");
    }

    @Test
    public void testGetFeetShouldReturnFeetPartOfInput() {
        assertThat(parser.getFeet("32.23'11\"")).isEqualToIgnoringCase("32.23'");
    }
}
