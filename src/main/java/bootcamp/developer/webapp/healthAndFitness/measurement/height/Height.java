package bootcamp.developer.webapp.healthAndFitness.measurement.height;

/**
 * This Height class represents a height measurement
 * it provides getters and for some metric and imperial measurement
 * Every sub class should set all of its data members
 */
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

    public abstract Height add(final Height other);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Height height = (Height) o;

        return Math.abs(this.metres - height.metres) < 0.0001;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(metres);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(centimetres);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(inches);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(feet);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
