package fargoal.model.interactable.temple;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.manager.api.FloorManager;
import fargoal.view.api.RenderFactory;
import fargoal.view.api.Renderer;
import fargoal.view.impl.SwingRenderer;

/**
 * This class implements the temple of the floor.
 * In the temple the player can not be attacked and he can donate 
 * the gold he has to gain experience (as much experience as the gold he has).
 */
public class Temple implements Interactable {

    final private Position position;
    private Renderer renderer;

    /**
     * This is the constructor of the class. It set the position of the temple.
     * @param position - the position of the temple.
     */
    public Temple(final Position position, final RenderFactory renderFactory) {
        this.position = position;
        this.setRender(renderFactory.templeRenderer(this));
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

    /**
     * Getter for field renderer.
     * @return the renderer.
     */
    public Renderer getRenderer() {
        return this.renderer;
    }

    /**
     * Setter for field renderer.
     * @param renderer - the new renderer.
     */
    public void setRender(final Renderer renderer) {
        this.renderer = renderer;
    }

    /** {@inheritDoc} */
    @Override
    public void update(FloorManager floorManager) {
    }
    
}
