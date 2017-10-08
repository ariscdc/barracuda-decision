package com.ariscdc.barracuda.decision;

import com.ariscdc.barracuda.decision.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20151104
 */
public class Solution<Candidate> {

    private List<Alternative<Candidate>> alternatives = new ArrayList<>();

    public Alternative<Candidate> getAlternative(int index) {
        return index < alternatives.size() ? alternatives.get(index) : null;
    }

    public List<Alternative<Candidate>> getAlternatives() {
        return alternatives;
    }

    public int getAlternativesCount() {
        return !CollectionUtils.isEmpty(alternatives) ? alternatives.size() : 0;
    }

    public List<Candidate> getCandidates() {

        List<Candidate> candidates = new ArrayList<>(alternatives.size());
        for (Alternative<Candidate> alternative: alternatives) {
            candidates.add(alternative.getCandidate());
        }
        return candidates;
    }

    public Alternative<Candidate> popTopAlternative() {
        if (!CollectionUtils.isEmpty(alternatives)) {
            return alternatives.remove(0);
        }
        return null;
    }

    public void setAlternatives(List<Alternative<Candidate>> alternatives) {
        if (!CollectionUtils.isEmpty(alternatives)) {
            this.alternatives = alternatives;
            Collections.sort(alternatives);
        }
    }
}
