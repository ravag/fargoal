package fargoal.model.interactable.pickUpAble.onGround;

import fargoal.commons.api.Position;
import fargoal.model.events.impl.WalkOverEvent;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.manager.api.FloorManager;
import fargoal.view.api.Renderer;

/**
 * A class that implements the item Beacon, when it is on the ground.
 * When the player is near it he can not be attacked by monster. 
 * When the player cast a teleport spell he is teleported near it.
 */
public class BeaconOnGround implements Interactable {

    private final Position position; 
    private Renderer renderer;
    private Position lastPlayerPosition;

    /**
     * The constructor of the class. When the player put on the ground a beacon that he has in the inventory 
     * it assign the position in which he had been put.
     * @param position - the position where the player put the beacon.
     * @param floorManager - it contains all the elements of the floor.
     */
    public BeaconOnGround(final Position position, final FloorManager floorManager) {
        this.position = position;
        this.renderer = floorManager.getRenderFactory().beaconRenderer(this);
    }

    /** {@inheritDoc} */
    @Override
    public final Position getPosition() {
        return this.position;
    }

    /** {@inheritDoc} */
    @Override
    public final String getTag() {
        return "BEACON";
    }

    /** {@inheritDoc} */
    @Override
    public final Interactable interact(final FloorManager floorManager) {
        floorManager.getPlayer().setIsImmune(true);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final void render() {
        this.renderer.render();
    }

    /**
     * Setter for field renderer.
     * @param renderer - the new renderer.
     */
    public final void setRender(final Renderer renderer) {
        this.renderer = renderer;
    }

    /** {@inheritDoc} */
    @Override
    public final void update(final FloorManager floorManager) {
        if (floorManager.getPlayer().getPosition().equals(this.position)) {
            if (!floorManager.getPlayer().getPosition().equals(this.lastPlayerPosition)) {
                floorManager.notifyFloorEvent(new WalkOverEvent(this));
            }
            this.interact(floorManager);
        } else {
            floorManager.getPlayer().setIsImmune(false);
        }
        this.lastPlayerPosition = floorManager.getPlayer().getPosition();
    }

}
