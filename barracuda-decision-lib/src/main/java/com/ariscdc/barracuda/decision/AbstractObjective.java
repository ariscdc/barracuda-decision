package com.ariscdc.barracuda.decision;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20151103
 */
public abstract class AbstractObjective<Candidate, Context> implements Objective<Candidate, Context> {

    private static final double DEFAULT_WEIGHT = 1.0;

    private double weight = DEFAULT_WEIGHT;

    @Override
    public final double getWeight() {
        return weight;
    }

    @Override
    public final void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public final ObjectiveScore provideScore(Candidate candidate) {
        return provideScore(candidate, null);
    }
}
