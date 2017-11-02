package bootcamp.developer.webapp.healthAndFitness.bmi;

import bootcamp.developer.webapp.healthAndFitness.measurement.height.Height;
import bootcamp.developer.webapp.healthAndFitness.measurement.height.Metre;
import bootcamp.developer.webapp.healthAndFitness.measurement.weight.Kilogram;
import bootcamp.developer.webapp.healthAndFitness.measurement.weight.Weight;
import org.assertj.core.data.Offset;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class BMICalculatorComponentTest {
    private BMICalculatorComponent calculator;
    private Weight weight;
    private Height height;
    private double bmi;
    private static final Offset<Double> ACCURACY = Offset.offset(0.0001);

    @Before
    public void startUp() {
        this.calculator = new BMICalculatorComponent();
    }

    private void givenAWeightInKilogramms(double value) {
        weight = new Kilogram(value);
    }

    private void givenAHeightInMetres(double value) {
        height = new Metre(value);
    }

    private void whenBmiIsCalculated() {
        this.bmi = calculator.calculateBmi(height, weight);
    }

    private void bmiShouldBe(double value) {
        assertThat(bmi).isCloseTo(value, ACCURACY);
    }

    @Test
    public void testTwoMeterTallAndHundredKilogramHeavyPersonShouldBe() {
        givenAHeightInMetres(2);
        givenAWeightInKilogramms(100);
        whenBmiIsCalculated();
        bmiShouldBe(25);
    }
}
