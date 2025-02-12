package fargoal.view.impl;

import java.util.function.Consumer;
import java.awt.Graphics2D;

import fargoal.view.api.Renderer;
import fargoal.view.api.View;

public class SwingRendererMiddle implements Renderer {

    private final Consumer<Graphics2D> drawingAction;
    private final SwingView view;

    public SwingRendererMiddle(Consumer<Graphics2D> drawing, View view) {
        this.drawingAction = drawing;
        this.view = (SwingView)view;
    }

    @Override
    public void render() {
        this.view.registerDrawingActionMiddle(drawingAction);
    }
    
}
