package com.ariscdc.barracuda.decision;

import com.ariscdc.barracuda.decision.constraint.Constraint;
import com.ariscdc.barracuda.decision.modifier.Modifier;
import com.ariscdc.barracuda.decision.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20151103
 */
public abstract class AbstractCandidatesFilter<Candidate, Context> {

    private List<Candidate> candidates;

    protected AbstractCandidatesFilter(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    @SuppressWarnings("all")
    public AbstractCandidatesFilter<Candidate, Context> applyConstraint(Constraint<Candidate, Context> constraint) {
        return applyConstraints(Arrays.asList(constraint), null);
    }

    @SuppressWarnings("all")
    public AbstractCandidatesFilter<Candidate, Context> applyConstraint(Constraint<Candidate, Context> constraint,
                                                                        Context context) {
        return applyConstraints(Arrays.asList(constraint), context);
    }

    public AbstractCandidatesFilter<Candidate, Context> applyConstraints(
            List<? extends Constraint<Candidate, Context>> constraints) {
        return applyConstraints(constraints, null);
    }

    public AbstractCandidatesFilter<Candidate, Context> applyConstraints(
            List<? extends Constraint<Candidate, Context>> constraints, Context context) {

        if (CollectionUtils.isEmpty(candidates))
            return this;

        List<Candidate> filteredCandidates = new ArrayList<>(candidates.size());
        for (Candidate candidate: candidates) {
            boolean passed = true;
            for (Constraint<Candidate, Context> constraint: constraints) {
                if (!constraint.apply(candidate, context)) {
                    passed = false;
                    break;
                }
            }
            if (passed) {
                filteredCandidates.add(candidate);
            }
        }
        candidates = filteredCandidates;

        return this;
    }

    @SuppressWarnings("all")
    public AbstractCandidatesFilter<Candidate, Context> applyModifier(Modifier<Candidate, Context> modifier) {
        return applyModifiers(Arrays.asList(modifier), null);
    }

    public AbstractCandidatesFilter<Candidate, Context> applyModifiers(
            List<? extends Modifier<Candidate, Context>> modifiers, Context context) {

        if (CollectionUtils.isEmpty(candidates))
            return this;

        for (Candidate candidate: candidates) {
            for (Modifier<Candidate, Context> modifier: modifiers) {
                candidate = modifier.apply(candidate, context);
            }
        }
        return this;
    }

    public List<Candidate> get() {
        return candidates;
    }
}
