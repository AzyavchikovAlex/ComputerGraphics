package AlexAzyavchikov.Mediator;


import AlexAzyavchikov.Components.Component;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public interface Mediator {
    void registerComponent(Component component);

    void setFillColor(Color color);
    void setRGBAndHsvFillColor(Color color);
    void setRGBAndCMYKFillColor(Color color);

    void createGUI(Stage stage);
}
