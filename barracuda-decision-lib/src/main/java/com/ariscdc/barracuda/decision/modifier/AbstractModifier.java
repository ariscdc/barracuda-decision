package com.ariscdc.barracuda.decision.modifier;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20151103
 */
public abstract class AbstractModifier<Candidate, Context> implements Modifier<Candidate, Context> {

    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
