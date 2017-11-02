package bootcamp.developer.webapp.healthAndFitness.measurement;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static bootcamp.developer.webapp.healthAndFitness.measurement.ConversionUtils.*;

public class ConversionUtilsTest {

    private static final Offset<Double> ACCURACY = Offset.offset(0.0001);

    @Test
    public void testOneMeterShouldBeHundredCentimeters() {
        assertThat(convertMetresToCentimetres(1)).isCloseTo(100, ACCURACY);
    }

    @Test
    public void testOneHundredCentimetersShouldBeOneMeters() {
        assertThat(convertCentimetresToMetres(100)).isCloseTo(1, ACCURACY);
    }

    @Test
    public void testTwelveInchesShouldBeOneFeet() {
        assertThat(convertInchesToFeet(12)).isCloseTo(1, ACCURACY);
    }

    @Test
    public void testOneFootShouldBeOneInch() {
        assertThat(convertFeetToInches(1)).isCloseTo(12, ACCURACY);
    }

    @Test
    public void testOneMeterShouldBe3_28084Feet() {
        assertThat(convertMetresToFeet(1)).isCloseTo(3.28084, ACCURACY);
    }

    @Test
    public void oneFootShouldBe0_3048Meters() {
        assertThat(convertFeetToMetres(1)).isCloseTo(0.3048, ACCURACY);
    }

    @Test
    public void oneKilogramShouldBe2_20462Pounds() {
        assertThat(convertKilogramsToPounds(1)).isCloseTo(2.20462, ACCURACY);
    }

    @Test
    public void onePoundShouldBe0_453592() {
        assertThat(convertPoundsToKilograms(1)).isCloseTo(0.453592, ACCURACY);
    }

    @Test
    public void oneInchShouldBe2_54Centimetre() {
        assertThat(convertInchesToCentimetres(1)).isCloseTo(2.54, ACCURACY);
    }
}
