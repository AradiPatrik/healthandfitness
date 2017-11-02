package bootcamp.developer.webapp.healthAndFitness.measurement.height;

import bootcamp.developer.webapp.healthAndFitness.measurement.ConversionUtils;

public class Centimetre extends Height {


    public Centimetre(double value) {
        super(value);
        this.centimetres = value;
        this.metres = ConversionUtils.convertCentimetresToMetres(this.centimetres);
        this.feet = ConversionUtils.convertMetresToFeet(this.metres);
        this.inches = ConversionUtils.convertCentimetresToInches(this.centimetres);
    }

    public Centimetre(Height height) {
        this(height.getCentimetres());
    }
}
