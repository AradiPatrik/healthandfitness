package bootcamp.developer.webapp.healthAndFitness.measurement.weight;

public abstract class Weight {
    protected double kilograms;
    protected double pounds;

    public Weight(double value) {
        if (value < 0) throw new IllegalArgumentException("Can't have negative weight");
    }

    public double getKilograms() {
        return kilograms;
    }

    public double getPounds() {
        return pounds;
    }
}
