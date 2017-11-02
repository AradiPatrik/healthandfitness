package bootcamp.developer.webapp.healthAndFitness.measurement;

public class ConversionUtils {

    private static final double CENTIMETRES_IN_METRE = 100.0;
    private static final double FEET_IN_METRE = 3.28084;
    private static final double INCHES_IN_FOOT = 12.0;
    private static final double CENTIMETRES_IN_INCH = 2.54;
    private static final double POUNDS_IN_KILOGRAM = 2.20462;

    public static double convertMetresToCentimetres(double metres) {
        return metres * CENTIMETRES_IN_METRE;
    }

    public static double convertCentimetresToMetres(double centimetres) {
        return centimetres / CENTIMETRES_IN_METRE;
    }

    public static double convertMetresToFeet(double metres) {
        return metres * FEET_IN_METRE;
    }

    public static double convertFeetToMetres(double feet) {
        return feet / FEET_IN_METRE;
    }

    public static double convertFeetToInches(double feet) {
        return feet * INCHES_IN_FOOT;
    }

    public static double convertInchesToFeet(double inches) {
        return inches / INCHES_IN_FOOT;
    }

    public static double convertInchesToCentimetres(double inches) {
        return inches * CENTIMETRES_IN_INCH;
    }

    public static double convertCentimetresToInches(double centimetres) {
        return centimetres / CENTIMETRES_IN_INCH;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * POUNDS_IN_KILOGRAM;
    }

    public static double convertPoundsToKilograms(double pounds) {
        return pounds / POUNDS_IN_KILOGRAM;
    }
}
