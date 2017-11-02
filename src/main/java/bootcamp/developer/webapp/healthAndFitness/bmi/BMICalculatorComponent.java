package bootcamp.developer.webapp.healthAndFitness.bmi;

import bootcamp.developer.webapp.healthAndFitness.measurement.height.Height;
import bootcamp.developer.webapp.healthAndFitness.measurement.weight.Weight;

public class BMICalculatorComponent {

    public double calculateBmi(Height height, Weight mass) {
        return mass.getKilograms() / height.getMetres() * height.getMetres();
    }

}
