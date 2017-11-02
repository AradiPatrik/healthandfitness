package bootcamp.developer.webapp.healthAndFitness.measurement.weight;

import bootcamp.developer.webapp.healthAndFitness.measurement.ConversionUtils;

/**
 * This Pound class represents a weight measurement in pounds
 */
public class Pound extends Weight {
    public Pound(double value) {
        super(value);
        this.pounds = value;
        this.kilograms = ConversionUtils.convertPoundsToKilograms(this.pounds);
    }

    public Pound(final Weight weight) {
        this(weight.getPounds());
    }
}
