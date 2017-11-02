package bootcamp.developer.webapp.healthAndFitness.measurement.height;

import bootcamp.developer.webapp.healthAndFitness.measurement.ConversionUtils;

/**
 * This Centimetre class represents a height measurement in centimetres
 */
public class Centimetre extends Height {

    public Centimetre(double value) {
        super(value);
        this.centimetres = value;
        this.metres = ConversionUtils.convertCentimetresToMetres(this.centimetres);
        this.feet = ConversionUtils.convertMetresToFeet(this.metres);
        this.inches = ConversionUtils.convertCentimetresToInches(this.centimetres);
    }

    public Centimetre(final Height height) {
        this(height.getCentimetres());
    }

    @Override
    public Height add(Height other) {
        return new Centimetre(this.getCentimetres() + other.getCentimetres());
    }
}
