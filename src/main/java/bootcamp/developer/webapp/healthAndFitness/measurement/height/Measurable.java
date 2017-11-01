package bootcamp.developer.webapp.healthAndFitness.measurement.height;

import bootcamp.developer.webapp.healthAndFitness.measurement.ConversionUtils;

public interface Measurable {
    default double getCentimetres() { return ConversionUtils.convertMetersToCentimeters(getMetres()); }
    default double getMetres() {
        return ConversionUtils.convertFeetToMeters(getFeet());
    }
    default double getFeet() {
        return ConversionUtils.convertInchesToFeet(getInches());
    }
    default double getInches() {
        return ConversionUtils.convertCentimetersToInches(getCentimetres());
    }
}
