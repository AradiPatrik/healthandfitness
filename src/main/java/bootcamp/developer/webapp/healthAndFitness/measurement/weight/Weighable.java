package bootcamp.developer.webapp.healthAndFitness.measurement.weight;

import bootcamp.developer.webapp.healthAndFitness.measurement.ConversionUtils;

public interface Weighable {
    default double getKilograms() {
        return ConversionUtils.convertPoundsToKilograms(getPounds());
    }
    default double getPounds() {
        return ConversionUtils.convertKilogramsToPounds(getKilograms());
    }
}
