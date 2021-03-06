package bootcamp.developer.webapp.healthAndFitness.measurement.weight;

import bootcamp.developer.webapp.healthAndFitness.measurement.ConversionUtils;

/**
 * This Kilogram class represents a weight measurement in kilograms
 */
public class Kilogram extends Weight {

    public Kilogram(double value) {
        super(value);
        this.kilograms = value;
        this.pounds = ConversionUtils.convertKilogramsToPounds(this.kilograms);
    }

    public Kilogram(final Weight weight) {
        this(weight.getKilograms());
    }
}
