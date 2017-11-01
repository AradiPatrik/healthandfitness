package bootcamp.developer.webapp.healthAndFitness.measurement.weight;

public class Pound implements Weighable{
    private double value;
    
    public Pound(double value) {
        if (value < 0) throw new IllegalArgumentException("can't have negative weight");
        this.value = value;
    }
    
    public Pound(Weighable weighable) {
        this.value = weighable.getPounds();
    }

    @Override
    public double getPounds() {
        return this.value;
    }
}
