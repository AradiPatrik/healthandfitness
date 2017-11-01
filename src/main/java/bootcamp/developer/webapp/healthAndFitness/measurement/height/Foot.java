package bootcamp.developer.webapp.healthAndFitness.measurement.height;

public class Foot implements Measurable {

    private double value;

    public Foot(double value) {
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
