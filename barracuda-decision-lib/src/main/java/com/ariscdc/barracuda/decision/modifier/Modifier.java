package com.ariscdc.barracuda.decision.modifier;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20151103
 */
public interface Modifier<Candidate, Context> {

    String getName();
    Candidate apply(Candidate candidate, Context context);
}
