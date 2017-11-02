package bootcamp.developer.webapp.healthAndFitness.bmi;

import bootcamp.developer.webapp.healthAndFitness.measurement.height.Height;
import bootcamp.developer.webapp.healthAndFitness.measurement.weight.Weight;

/**
 * This BMICalculatorComponent class contains methods
 * for calculating the Bmi value for a given Weight and
 * given Weight value
 */
public class BMICalculatorComponent {

    /**
     *
     * @param height
     *              height in any unit of measurement
     * @param mass
     *              mass in any unit of measurement
     * @return
     *          the bmi calculated from the height and weight values
     */
    public double calculateBmi(Height height, Weight mass) {
        return mass.getKilograms() / (height.getMetres() * height.getMetres());
    }

}
