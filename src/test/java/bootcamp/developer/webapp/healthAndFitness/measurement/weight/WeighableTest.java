package bootcamp.developer.webapp.healthAndFitness.measurement.weight;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.data.Offset;
import org.junit.Test;

public class WeighableTest {
    
    private static final Offset<Double> ACCURACY = Offset.offset(0.00001);
    private Weight weight;
    
    private void givenWeightInKilograms(double value) {
        this.weight = new Kilogram(value);
    }
    
    private void givenWeightInPounds(double value) {
        this.weight = new Pound(value);
    }
    
    private void whenConvertedToPound() {
        this.weight = new Pound(weight);
    }
    
    private void whenConvertedToKilogram() {
        this.weight = new Kilogram(weight);
    }
    
    private void thenWeightInKilogramsShouldBe(double value) {
        assertThat(weight.getKilograms()).isCloseTo(value, ACCURACY);
    }

    private void thenWeightInPoundsShouldBe(double value) {
        assertThat(weight.getPounds()).isCloseTo(value, ACCURACY);
    }

    @Test
    public void testConversionFromUnitToUnitShouldNotAffectWeight() {
        givenWeightInKilograms(5);
        whenConvertedToPound();
        thenWeightInKilogramsShouldBe(5);
        whenConvertedToKilogram();
        thenWeightInKilogramsShouldBe(5);
    }

    @Test
    public void testWeightGivenInKilogramsShouldGiveCorrectValuesInEveryUnitOfMeasurement() {
        givenWeightInKilograms(1);
        thenWeightInKilogramsShouldBe(1);
        thenWeightInPoundsShouldBe(2.20462);
    }

    @Test
    public void testWeightInitializedFromKilogramsShouldYieldCorrectWeightInKilograms() {
        givenWeightInKilograms(1);
        thenWeightInKilogramsShouldBe(1);
    }

    @Test
    public void testWeightInitializedFromPoundsShouldYieldCorrectWeightInPounds() {
        givenWeightInPounds(1);
        thenWeightInPoundsShouldBe(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeKilogramsShouldNotBePermitted() {
        givenWeightInKilograms(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativePoundsShouldNotBePermitted() {
        givenWeightInPounds(-1);
    }
}
