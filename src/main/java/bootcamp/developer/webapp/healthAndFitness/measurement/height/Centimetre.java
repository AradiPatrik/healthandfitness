package bootcamp.developer.webapp.healthAndFitness.measurement.height;

public class Centimetre implements Measurable {

    private double value;

    public Centimetre(double value) {
        this.value = value;
    }

    public Centimetre(Measurable measurable) {
        this.value = measurable.getCentimetres();
    }

    @Override
    public double getCentimetres() {
        return this.value;
    }
}
