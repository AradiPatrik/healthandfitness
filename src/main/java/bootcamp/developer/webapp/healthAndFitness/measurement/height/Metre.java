package bootcamp.developer.webapp.healthAndFitness.measurement.height;

public class Metre implements Measurable {
    private final double value;

    public Metre(double value) {
        if (value <= 0) throw new IllegalArgumentException("Can't have negative height");
        this.value = value;
    }

    public Metre(Measurable measurable) {
        this.value = measurable.getMetres();
    }

    @Override
    public double getMetres() {
        return this.value;
    }
}
