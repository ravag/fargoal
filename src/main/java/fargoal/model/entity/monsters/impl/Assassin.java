package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.ai.Ai;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.map.api.FloorMap;

/**
 * A class that develops the monster Assassin:
 * an enemy who's generally invisible.
 */
public class Assassin extends AbstractMonster {

    /**
     * A constructor for the Assassin, it uses the
     * super of the AbstractMonster constructor but with 
     * his visibility off.
     * 
     * @param position - the starting position
     * @param level - the level of the monster
     * @param floorMap - the floorMap where the monster is located
     * @param floorManager - to get infos about the other entities/items
     */
    public Assassin(final Position position, final Integer level, final FloorMap floorMap, final FloorManager floorManager) {
        super(position, level, floorMap, floorManager);
        this.setMonsterType(MonsterType.ASSASSIN);
        this.setVisibilityOff();
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return "ASSASSIN";
    }

    /** {@inheritDoc} */
    @Override
    public void steal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'steal'");
    }

    /** {@inheritDoc} */
    @Override
    public void update(final FloorManager floorManager) {
        final long temp = System.currentTimeMillis();
        if(Math.abs(this.getTimer() - temp) >= 2000) {
            this.setTimer();
            if (this.areNeighbours(floorManager, 1)) {
                this.setVisibilityOn();
                this.attack();
            } else {
                this.setVisibilityOff();
                Ai.move(this, floorManager.getPlayer());
            }
        }
    }
}
