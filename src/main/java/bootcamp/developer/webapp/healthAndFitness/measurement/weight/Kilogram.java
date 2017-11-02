package bootcamp.developer.webapp.healthAndFitness.measurement.weight;

import bootcamp.developer.webapp.healthAndFitness.measurement.ConversionUtils;

public class Kilogram extends Weight {

    public Kilogram(double value) {
        super(value);
        this.kilograms = value;
        this.pounds = ConversionUtils.convertKilogramsToPounds(this.kilograms);
    }

    public Kilogram(Weight weight) {
        this(weight.getKilograms());
    }
}
