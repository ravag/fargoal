package fargoal.model.interactable.pickUpAble.inChest.Spell.impl;

import fargoal.model.interactable.pickUpAble.inChest.Spell.api.Spell;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItemType;

public class TeleportSpell implements Spell {

    public TeleportSpell() {
        this.store();
    }

    @Override
    public String getChestItemType() {
        return ChestItemType.SPELL.getName();
    }

    @Override
    public String getChestItemName() {
        return SpellType.TELEPORT.getName();
    }

    @Override
    public void store() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'store'");
    }

    @Override
    public void cast() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cast'");
    }
    
}
