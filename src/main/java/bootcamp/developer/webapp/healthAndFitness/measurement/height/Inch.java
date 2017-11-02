package bootcamp.developer.webapp.healthAndFitness.measurement.height;

import bootcamp.developer.webapp.healthAndFitness.measurement.ConversionUtils;

/**
 * This Inch class represents a height measurement in Inches
 */
public class Inch extends Height{

    public Inch(double value) {
        super(value);
        this.inches = value;
        this.feet = ConversionUtils.convertInchesToFeet(this.inches);
        this.metres = ConversionUtils.convertFeetToMetres(this.feet);
        this.centimetres = ConversionUtils.convertMetresToCentimetres(this.metres);
    }

    public Inch(final Height height) {
        this(height.getInches());
    }

    @Override
    public Height add(Height other) {
        return new Inch(this.getInches() + other.getInches());
    }
}
