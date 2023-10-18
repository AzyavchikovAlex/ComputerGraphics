package AlexAzyavchikov.Components.SetupComponents;

import AlexAzyavchikov.Components.Component;
import AlexAzyavchikov.Mediator.Mediator;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;

import java.util.logging.Level;

public class ColorPickerComponent extends SetupComponentImpl {
    private final ColorPicker colorPicker = new ColorPicker();

    public ColorPickerComponent() {
        this.getChildren().addAll(new Label("Select color"), colorPicker);
        colorPicker.setOnAction((event) -> colorChangedEventListener());
    }

    @Override
    public String getName() {
        return "ColorPicker";
    }

    @Override
    public void colorChangedEventListener() {
        usingColor = colorPicker.getValue();
        mediator.setFillColor(usingColor);
    }

    @Override
    public void modifySliders() {
        colorPicker.setValue(usingColor);
    }

    @Override
    public void modifyLabels() {
    }
}
