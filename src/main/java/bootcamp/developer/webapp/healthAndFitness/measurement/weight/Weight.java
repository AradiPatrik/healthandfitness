package bootcamp.developer.webapp.healthAndFitness.measurement.weight;

/**
 * This Weight class represents a weight measurement
 * It provides methods for getting the weight in either imperial or metric units
 */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weight weight = (Weight) o;

        return Math.abs(this.kilograms - weight.kilograms) < 0.0001;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(kilograms);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(pounds);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
