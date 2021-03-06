package bootcamp.developer.webapp.healthAndFitness.measurement.height;

import bootcamp.developer.webapp.healthAndFitness.measurement.ConversionUtils;

/**
 * This Foot class represents a measurement in Feet
 */
public class Foot extends Height {

    public Foot(double value) {
        super(value);
        this.feet = value;
        this.inches = ConversionUtils.convertFeetToInches(this.feet);
        this.metres = ConversionUtils.convertFeetToMetres(this.feet);
        this.centimetres = ConversionUtils.convertMetresToCentimetres(this.metres);
    }

    public Foot(final Height height) {
        this(height.getFeet());
    }

    @Override
    public Height add(Height other) {
        return new Foot(this.getFeet() + other.getFeet());
    }
}
