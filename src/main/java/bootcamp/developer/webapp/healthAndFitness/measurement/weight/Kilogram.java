package bootcamp.developer.webapp.healthAndFitness.measurement.weight;

public class Kilogram implements Weighable {
    private double value;

    public Kilogram(double value) {
        if (value < 0) throw new IllegalArgumentException("Can't have negative weight");
        this.value = value;
    }

    public Kilogram(Weighable weighable) {
        this.value = weighable.getKilograms();
    }

    @Override
    public double getKilograms() {
        return this.value;
    }
}
