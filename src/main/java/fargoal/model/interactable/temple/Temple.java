package fargoal.model.interactable.temple;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements the temple of the floor.
 * In the temple the player can not be attacked and he can donate 
 * the gold he has to gain experience (as much experience as the gold he has).
 */
public class Temple implements Interactable {

    final Position position;

    /**
     * This is the constructor of the class. It set the position of the temple.
     * @param position - the position of the temple.
     */
    public Temple(final Position position) {
        this.position = position;
    }

    /** {@inheritDoc} */
    @Override
    public Interactable interact(FloorManager floorManager) {
        if (floorManager.getPlayer().getPosition() == this.position) {
            floorManager.getPlayer().setIsImmune(true);
            floorManager.getPlayer().addExperiencePoints(floorManager.getPlayer().getCurrentGold());
            floorManager.getPlayer().getPlayerGold().resetGold();
        } else {
            floorManager.getPlayer().setIsImmune(false);
        }
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public Position getPosition() {
        return this.position;
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return "TEMPLE";
    }

    /** {@inheritDoc} */
    @Override
    public void update(FloorManager floorManager) {
    }
    
}
