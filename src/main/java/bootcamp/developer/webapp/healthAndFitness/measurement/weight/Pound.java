package bootcamp.developer.webapp.healthAndFitness.measurement.weight;

import bootcamp.developer.webapp.healthAndFitness.measurement.ConversionUtils;

public class Pound extends Weight {
    public Pound(double value) {
        super(value);
        this.pounds = value;
        this.kilograms = ConversionUtils.convertPoundsToKilograms(this.pounds);
    }

    public Pound(Weight weight) {
        this(weight.getPounds());
    }
}
