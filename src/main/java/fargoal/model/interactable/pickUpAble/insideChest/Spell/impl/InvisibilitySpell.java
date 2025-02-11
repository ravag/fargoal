package fargoal.model.interactable.pickUpAble.insideChest.Spell.impl;

import fargoal.model.interactable.pickUpAble.insideChest.Spell.api.AbstractSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.api.SpellType;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements the Invisibility Spell from the interface spell.
 * When the player cast this spell the monsters can not see him.
 * If the light spell is active the player can be seen.
 * The spell ends when the player change floor level.
 */
public class InvisibilitySpell extends AbstractSpell {

    /**
     * The constructor of the class. When The spell is found in a chest 
     * it is stored immediately in the player's inventory.
     */
    public InvisibilitySpell(FloorManager floorManager) {
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemName() {
        return SpellType.INVISIBILITY.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void update(FloorManager floorManager) {
        if (floorManager.getPlayer().getInventory().getSpellCasted().get(SpellType.INVISIBILITY.getName())) {
            if (this.getFloorLevelSpellCast() != floorManager.getFloorLevel()) {
                floorManager.getPlayer().getInventory().getSpellCasted().replace(SpellType.INVISIBILITY.getName(), false);
                floorManager.getPlayer().setIsVisible(true);
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public void effect(FloorManager floorManager) {
        floorManager.getPlayer().setIsVisible(false);
        floorManager.getPlayer().getInventory().getSpellCasted().replace(SpellType.INVISIBILITY.getName(), true);
        this.removeSpell();
    }

}
