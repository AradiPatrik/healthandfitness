package bootcamp.developer.webapp.healthAndFitness.measurement.height;

import bootcamp.developer.webapp.healthAndFitness.measurement.ConversionUtils;

/**
 * This Metre class represents a height in metres
 */
public class Metre extends Height {

    public Metre(double value) {
        super(value);
        this.metres = value;
        this.centimetres = ConversionUtils.convertMetresToCentimetres(this.metres);
        this.feet = ConversionUtils.convertMetresToFeet(this.metres);
        this.inches = ConversionUtils.convertCentimetresToInches(this.centimetres);
    }

    public Metre(final Height height) {
        this(height.getMetres());
    }

    @Override
    public Height add(final Height other) {
        return new Metre(this.getMetres() + other.getMetres());
    }
}
