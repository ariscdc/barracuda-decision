package com.ariscdc.barracuda.decision;

import com.ariscdc.barracuda.decision.constraint.Constraint;
import com.ariscdc.barracuda.decision.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20151103
 */
public abstract class AbstractProblem<Candidate, Context> implements Problem<Candidate, Context> {

    private List<? extends Objective<Candidate, Context>> objectives;
    private List<? extends Constraint<Candidate, Context>> constraints;
    private Map<String, Double> relativeWeightMap;
    private MathContext mathContext;

    protected AbstractProblem(List<? extends Objective<Candidate, Context>> objectives,
                              MathContext mathContext) {
        this(objectives, null, mathContext);
    }

    protected AbstractProblem(List<? extends Objective<Candidate, Context>> objectives,
                              List<? extends Constraint<Candidate, Context>> constraints,
                              MathContext mathContext) {
        checkArgument(!CollectionUtils.isEmpty(objectives), "There should be at least one Objective.");
        checkArgument(mathContext != null, "MathContext for scoring precision is required.");
        this.objectives = objectives;
        this.constraints = constraints;
        this.mathContext = mathContext;
        buildRelativeWeights(objectives);
    }

    @Override
    public final Solution<Candidate> solve(Collection<Candidate> candidates) {
        return solve(candidates, null);
    }

    @Override
    public Solution<Candidate> solve(Collection<Candidate> candidates, Context context) {

        Solution<Candidate> solution = new Solution<>();
        if (CollectionUtils.isEmpty(candidates))
            return solution;

        List<Alternative<Candidate>> alternatives = new ArrayList<>();
        for (Candidate candidate: candidates) {
            if (isIncluded(candidate, context)) {
                double totalScore = 0.0;
                for (Objective<Candidate, Context> objective: objectives) {
                    ObjectiveScore objectiveScore = objective.provideScore(candidate, context);
                    totalScore += (objectiveScore.getValue() * relativeWeightMap.get(objective.getName()))
                            + objectiveScore.getBoost();
                }
                if (totalScore > 0) {
                    alternatives.add(new Alternative<>(candidate, new BigDecimal(totalScore, mathContext)));
                }
            }
        }
        solution.setAlternatives(alternatives);
        return solution;
    }

    private void buildRelativeWeights(List<? extends Objective<Candidate, Context>> objectives) {

        double totalWeight = 0.0;
        for (Objective<Candidate, Context> objective: objectives) {
            totalWeight += objective.getWeight();
        }

        relativeWeightMap = new HashMap<>(objectives.size());
        for (Objective<Candidate, Context> objective: objectives) {
            relativeWeightMap.put(objective.getName(), objective.getWeight() / totalWeight);
        }
    }

    private boolean isIncluded(Candidate candidate, Context context) {
        if (constraints != null) {
            for (Constraint<Candidate, Context> constraint: constraints) {
                if (!constraint.apply(candidate, context)) return false;
            }
        }
        return true;
    }
}
