package fargoal.model.entity.commons.impl;

import fargoal.model.entity.commons.api.Health;

/**
 * Health class, it contains some essential features.
 */
public class HealthImpl implements Health {

    private Integer maxHealth;
    private Integer currentHealth;

    /**
     * Creates a new instance of Health, the initial health value
     * equals maxHealth.
     * 
     * @param maxHealth - the maximum health value
     */
    public HealthImpl(Integer maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getCurrentHealth() {
        return currentHealth;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getMaxHealth() {
        return maxHealth;
    }

    /** {@inheritDoc} */
    @Override
    public void decreaseHealth(Integer amount) {
        this.currentHealth = this.currentHealth - amount;
    }

    /** {@inheritDoc} */
    @Override
    public void increaseHealth(Integer amount) {
        this.currentHealth = this.currentHealth + amount;
    }

    /** {@inheritDoc} */
    @Override
    public void setToMaxHealth() {
        this.currentHealth = maxHealth;
    }
}
