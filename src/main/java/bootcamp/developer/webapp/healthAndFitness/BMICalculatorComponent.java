package bootcamp.developer.webapp.healthAndFitness;

import bootcamp.developer.webapp.healthAndFitness.measurement.height.Measurable;
import bootcamp.developer.webapp.healthAndFitness.measurement.weight.Weighable;

public class BMICalculatorComponent {

    public double calculateBmi(Measurable height, Weighable mass) {
        return mass.getKilograms() / height.getMetres() * height.getMetres();
    }

}
