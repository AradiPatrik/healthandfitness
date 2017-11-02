package bootcamp.developer.webapp.healthAndFitness.measurement.height;

public abstract class Height {

    protected double metres;
    protected double centimetres;
    protected double inches;
    protected double feet;

    public Height(double value) {
        if (value < 0) throw new IllegalArgumentException("Can't have negative height");
    }

    public double getMetres() {
        return this.metres;
    }

    public double getCentimetres() {
        return centimetres;
    }

    public double getInches() {
        return inches;
    }

    public double getFeet() {
        return feet;
    }
}
