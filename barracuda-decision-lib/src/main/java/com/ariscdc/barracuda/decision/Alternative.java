package com.ariscdc.barracuda.decision;

import com.google.common.base.MoreObjects;

import java.math.BigDecimal;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20151103
 */
public class Alternative<Candidate> implements Comparable<Alternative<Candidate>> {

    private Candidate candidate;
    private BigDecimal score;

    public Alternative(Candidate candidate, BigDecimal score) {
        this.candidate = candidate;
        this.score = score;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public BigDecimal getScore() {
        return score;
    }

    @Override
    @SuppressWarnings("all")
    public int compareTo(Alternative<Candidate> other) {
        return other.getScore().compareTo(score);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("candidate", candidate)
                .add("score", score)
                .omitNullValues()
                .toString();
    }
}
