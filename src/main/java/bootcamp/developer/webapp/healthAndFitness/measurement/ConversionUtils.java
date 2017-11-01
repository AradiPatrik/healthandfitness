package bootcamp.developer.webapp.healthAndFitness.measurement;

public class ConversionUtils {

    private static final double CENTIMETERS_IN_METER = 100.0;
    private static final double FEET_IN_METER = 3.28084;
    private static final double INCHES_IN_FOOT = 12.0;
    private static final double CENTIMETERS_IN_INCH = 2.54;
    private static final double POUNDS_IN_KILOGRAM = 2.20462;

    public static double convertMetersToCentimeters(double meters) {
        return meters * CENTIMETERS_IN_METER;
    }

    public static double convertCentimetersToMeters(double centimeters) {
        return centimeters / CENTIMETERS_IN_METER;
    }

    public static double convertMetersToFeet(double meters) {
        return meters * FEET_IN_METER;
    }

    public static double convertFeetToMeters(double feet) {
        return feet / FEET_IN_METER;
    }

    public static double convertFeetToInches(double feet) {
        return feet * INCHES_IN_FOOT;
    }

    public static double convertInchesToFeet(double inches) {
        return inches / INCHES_IN_FOOT;
    }

    public static double convertInchesToCentimeters(double inches) {
        return inches * CENTIMETERS_IN_INCH;
    }

    public static double convertCentimetersToInches(double centimeters) {
        return centimeters / CENTIMETERS_IN_INCH;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * POUNDS_IN_KILOGRAM;
    }

    public static double convertPoundsToKilograms(double pounds) {
        return pounds / POUNDS_IN_KILOGRAM;
    }
}
