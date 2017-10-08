package com.ariscdc.barracuda.decision;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20151103
 */
public interface Objective<Candidate, Context> {

    String getName();
    double getWeight();
    void setWeight(double weight);
    ObjectiveScore provideScore(Candidate candidate);
    ObjectiveScore provideScore(Candidate candidate, Context context);
}
