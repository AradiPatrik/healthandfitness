package bootcamp.developer.webapp.healthAndFitness.measurement.height;

public class Foot implements Measurable {

    private double value;

    public Foot(double value) {
        if (value <= 0) throw new IllegalArgumentException("Can't have negative height");
        this.value = value;
    }

    public Foot(Measurable measurable) {
        this.value = measurable.getFeet();
    }

    @Override
    public double getFeet() {
        return this.value;
    }
}
