package fargoal.model.interactable.pickUpAble.insideChest.Spell.impl;

import fargoal.model.interactable.pickUpAble.insideChest.Spell.api.AbstractSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.api.SpellType;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements the Shield Spell from the interface spell.
 * When the player casts this spell he does not damage himself in the next fight.
 * If the player is not damaged and when he change floor level the spell is still 
 * casted, the spell ends.
 */
public class ShieldSpell extends AbstractSpell {

    /**
     * The constructor of the class. When The spell is found in a chest 
     * it is stored immediately in the player's inventory.
     * 
     */
    public ShieldSpell(FloorManager floorManager) {
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemName() {
        return SpellType.SHIELD.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void update(FloorManager floorManager) {
        if (floorManager.getPlayer().getInventory().getSpellCasted().get(SpellType.SHIELD.getName())) {
            if (this.getFloorLevelSpellCast() != floorManager.getFloorLevel()) {
                floorManager.getPlayer().getInventory().getSpellCasted().replace(SpellType.SHIELD.getName(), false);
            }
        }
    }

    @Override
    public void effect(FloorManager floorManager) {
        floorManager.getPlayer().getInventory().getSpellCasted().replace(SpellType.SHIELD.getName(), true);
        this.removeSpell();
    }

}
