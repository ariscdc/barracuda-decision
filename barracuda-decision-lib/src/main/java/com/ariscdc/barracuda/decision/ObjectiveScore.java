package com.ariscdc.barracuda.decision;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20151103
 */
public class ObjectiveScore {

    /**
     * Score Value: 0 to 1.
     */
    private double value;

    /**
     * Boost Value
     */
    private double boost;

    public ObjectiveScore(double value) {
        this(value, 0);
    }

    public ObjectiveScore(double value, double boost) {
        this.value = value;
        this.boost = boost;
    }

    public double getValue() {
        return value;
    }

    public double getBoost() {
        return boost;
    }
}
