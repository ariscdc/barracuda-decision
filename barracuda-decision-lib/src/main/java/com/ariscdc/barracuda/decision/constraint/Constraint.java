package com.ariscdc.barracuda.decision.constraint;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20151103
 */
public interface Constraint<Candidate, Context> {

    String getName();
    boolean apply(Candidate candidate, Context context);
}
