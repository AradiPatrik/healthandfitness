package bootcamp.developer.webapp.healthAndFitness.measurement.height;

import bootcamp.developer.webapp.healthAndFitness.measurement.ConversionUtils;

public class Metre extends Height {

    public Metre(double value) {
        super(value);
        this.metres = value;
        this.centimetres = ConversionUtils.convertMetresToCentimetres(this.metres);
        this.feet = ConversionUtils.convertMetresToFeet(this.metres);
        this.inches = ConversionUtils.convertCentimetresToInches(this.centimetres);
    }

    public Metre(Height height) {
        this(height.getMetres());
    }
}
