package bootcamp.developer.webapp.healthAndFitness.measurement.height;

public class Inch implements Measurable {
    private double value;

    public Inch(double value) {
        if (value <= 0) throw new IllegalArgumentException("Can't have negative height");
        this.value = value;
    }

    public Inch(Measurable measurable) {
        this.value = measurable.getInches();
    }

    @Override
    public double getInches() {
        return this.value;
    }
}
