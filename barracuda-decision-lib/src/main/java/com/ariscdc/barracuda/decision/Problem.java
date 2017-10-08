package com.ariscdc.barracuda.decision;

import java.util.Collection;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20151103
 */
public interface Problem<Candidate, Context> {

    Solution<Candidate> solve(Collection<Candidate> candidates);
    Solution<Candidate> solve(Collection<Candidate> candidates, Context context);
}
