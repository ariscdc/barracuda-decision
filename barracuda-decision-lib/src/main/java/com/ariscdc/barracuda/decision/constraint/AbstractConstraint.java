package com.ariscdc.barracuda.decision.constraint;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20151103
 */
public abstract class AbstractConstraint<Candidate, Context> implements Constraint<Candidate, Context> {

    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
