package bootcamp.developer.webapp.healthAndFitness.measurement.height;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.data.Offset;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

public class HeightTest {
    private static final Offset<Double> ACCURACY = Offset.offset(0.0001);
    private static final double POSITIVE_VALUE = 5.0;

    private Height height;

    private void givenAHeightInCentimetres(double value) {
        height = new Centimetre(value);
    }

    private void givenAHeightInMetres(double value) {
        height = new Metre(value);
    }

    private void givenAHeightInInches(double value) {
        height = new Inch(value);
    }

    private void givenAHeightInFeet(double value) {
        height = new Foot(value);
    }

    private void whenConvertedToCentimetres() {
        height = new Centimetre(height);
    }

    private void whenConvertedToMetres() {
        height = new Metre(height);
    }

    private void whenConvertedToInches() {
        height = new Inch(height);
    }

    private void whenConvertedToFeet() {
        height = new Foot(height);
    }

    private void thenTheHeightInMetresShouldBe(double value) {
        assertThat(height.getMetres()).isCloseTo(value, ACCURACY);
    }

    private void thenTheHeightInCentimetresShouldBe(double value) {
        assertThat(height.getCentimetres()).isCloseTo(value, ACCURACY);
    }

    private void thenTheHeightInInchesShouldBe(double value) {
        assertThat(height.getInches()).isCloseTo(value, ACCURACY);
    }

    private void thenTheHeightInFeetShouldBe(double value) {
        assertThat(height.getFeet()).isCloseTo(value, ACCURACY);
    }

    @Test
    public void testConversionFromUnitToUnitShouldNotAffectHeight() {
        final double value = 1.8;
        givenAHeightInMetres(value);
        whenConvertedToMetres();
        thenTheHeightInMetresShouldBe(value);
        whenConvertedToFeet();
        thenTheHeightInMetresShouldBe(value);
        whenConvertedToInches();
        thenTheHeightInMetresShouldBe(value);
        whenConvertedToCentimetres();
        thenTheHeightInMetresShouldBe(value);
    }

    @Test
    public void testHeightInitializedFromMetresShouldGiveCorrectValuesInEveryUnitOfMeasurement() {
        final double value = 1.4;
        givenAHeightInMetres(value);
        thenTheHeightInInchesShouldBe(55.1181);
        thenTheHeightInFeetShouldBe(4.59318);
        thenTheHeightInCentimetresShouldBe(140);
        thenTheHeightInMetresShouldBe(1.4);
    }

    @Test
    public void testHeightInitializedFromInchesShouldYieldCorrectHeightInInches() {
        final double value = 130.0;
        givenAHeightInInches(value);
        thenTheHeightInInchesShouldBe(value);
    }

    @Test
    public void testHeightInitializedFromMetresShouldYieldCorrectHeightInMetres() {
        final double value = 1.5;
        givenAHeightInMetres(value);
        thenTheHeightInMetresShouldBe(value);
    }

    @Test
    public void testHeightInitializedFromCentimetresShouldYieldCorrectHeightInCentimetres() {
        final double value = 158;
        givenAHeightInCentimetres(value);
        thenTheHeightInCentimetresShouldBe(value);
    }

    @Test
    public void testHeightInitializedFromFeetShouldYieldCorrectHeightInFeet() {
        final double value = 6;
        givenAHeightInFeet(value);
        thenTheHeightInFeetShouldBe(value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMetresInitializedFromNegativeValueShouldNotBePermitted() throws IllegalArgumentException {
        givenAHeightInMetres(-3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCentimetresInitializedFromNegativeValueShouldNotBePermitted() throws IllegalArgumentException {
        givenAHeightInCentimetres(-4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInchesInitializedFromNegativeValueShouldNotBePermitted() throws IllegalArgumentException {
        givenAHeightInInches(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootInitializedFromNegativeValueShouldNotBePermitted() throws IllegalArgumentException {
        givenAHeightInFeet(-1);
    }
}
