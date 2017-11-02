package bootcamp.developer.webapp.healthAndFitness.measurement.height;

import bootcamp.developer.webapp.healthAndFitness.measurement.ConversionUtils;

public class Inch extends Height{

    public Inch(double value) {
        super(value);
        this.inches = value;
        this.feet = ConversionUtils.convertInchesToFeet(this.inches);
        this.metres = ConversionUtils.convertFeetToMetres(this.feet);
        this.centimetres = ConversionUtils.convertMetresToCentimetres(this.metres);
    }

    public Inch(Height height) {
        this(height.getInches());
    }
}
