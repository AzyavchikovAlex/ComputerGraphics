package AlexAzyavchikov.Components.Draw;

import AlexAzyavchikov.Components.Component;
import AlexAzyavchikov.Mediator.Mediator;
import javafx.scene.paint.Color;

public class DrawComponent extends ResizableCanvas implements Component {
    private Mediator mediator;
    private Color fillColor = Color.BLACK;

    public DrawComponent() {
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void setFillColor(Color color) {
        this.fillColor = color;
        drawColor();
    }

    public Color getFillColor() {
        return this.fillColor;
    }

    public String getName() {
        return "Draw";
    }

    public void drawColor() {
        clear();
        this.getGraphicsContext2D().setFill(fillColor);
        this.getGraphicsContext2D().setStroke(Color.BLACK);
        this.getGraphicsContext2D().fillOval(0, 0, getWidth(), getHeight());
        this.getGraphicsContext2D().strokeOval(0, 0, getWidth(), getHeight());
    }

    public void clear() {
        this.getGraphicsContext2D().setFill(Color.WHITE);
        this.getGraphicsContext2D().fillRect(0.0, 0.0, this.getWidth() - 1.0, this.getHeight() - 1.0);
    }

    @Override
    public void resize(double width, double height) {
        super.resize(width, height);
        drawColor();
    }
}