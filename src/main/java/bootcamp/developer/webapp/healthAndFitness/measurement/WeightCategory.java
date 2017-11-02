package bootcamp.developer.webapp.healthAndFitness.measurement;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * This WeightCategory enum represents the weight categories specified
 * by the BMI.
 * It contains methods for getting and printing the category of a given bmi
 */
public enum WeightCategory {
    VERY_SEVERELY_UNDERWEIGHT(0.0, 15.0),
    SEVERELY_UNDERWEIGHT(15.0, 16.0),
    UNDERWEIGHT(16.0, 18.5),
    NORMAL(18.5, 25.0),
    OVERWEIGHT(25.0, 30.0),
    MODERATELY_OBESE(30.0, 35.0),
    SEVERELY_OBESE(35.0, 40.0),
    VERY_SEVERELY_OBESE(40.0, Double.MAX_VALUE);

    private final double inclusiveLowerLimit;
    private final double exclusiveUpperLimit;

    private boolean isWeightCategoryOfBMI(double bmi) {
        return (bmi >= inclusiveLowerLimit && bmi < exclusiveUpperLimit);
    }

    WeightCategory(double inclusiveLowerLimit, double exclusiveUpperLimit) {
        this.inclusiveLowerLimit = inclusiveLowerLimit;
        this.exclusiveUpperLimit = exclusiveUpperLimit;
    }

    /**
     * Categorizes a person with a given bmi
     * @param bmi
     *          the persons bmi
     * @return
     *          the category in which the person belongs
     */
    public static WeightCategory getWeightCategoryFromBMI(double bmi) {
        Optional<WeightCategory> result = Arrays.stream(WeightCategory.values())
                    .filter(currentCategory -> currentCategory.isWeightCategoryOfBMI(bmi))
                    .findFirst();
        if(result.isPresent()) {
            return result.get();
        } else {
            throw new IllegalArgumentException(bmi + " is not a valid bmi");
        }
    }

    @Override
    public String toString() {
        String[] words = this.name().split("_");
        return Arrays.stream(words).map(String::toLowerCase).collect(Collectors.joining(" "));
    }
}
