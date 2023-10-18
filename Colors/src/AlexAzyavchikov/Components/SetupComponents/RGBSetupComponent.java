package AlexAzyavchikov.Components.SetupComponents;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;

public class RGBSetupComponent extends SetupComponentImpl implements SetupComponent {
    private Slider redSlider = new Slider();
    private Slider greenSlider = new Slider();
    private Slider blueSlider = new Slider();
    private Label redLabel = new Label();
    private Label greenLabel = new Label();
    private Label blueLabel = new Label();

    public RGBSetupComponent() {
        Label label = new Label("RGB");
        setupSlider(redSlider, 0, 256);
        setupSlider(greenSlider, 0, 256);
        setupSlider(blueSlider, 0, 256);
        modifyLabels();
        this.getChildren().addAll(label,
                manageSliderLayout(redSlider, redLabel),
                manageSliderLayout(greenSlider, greenLabel),
                manageSliderLayout(blueSlider, blueLabel));
    }

    @Override
    public String getName() {
        return "RGBSetup";
    }

    @Override
    public void colorChangedEventListener() {
        usingColor = Color.color(redSlider.getValue() / 256,
                greenSlider.getValue() / 256,
                blueSlider.getValue() / 256);
        mediator.setFillColor(usingColor);
    }

    @Override
    public void modifyLabels() {
        redLabel.setText("Red: " + redSlider.getValue());
        greenLabel.setText("Green: " + greenSlider.getValue());
        blueLabel.setText("Blue: " + blueSlider.getValue());

    }

    @Override
    public void modifySliders() {
        redSlider.setValue(usingColor.getRed() * 256);
        greenSlider.setValue(usingColor.getGreen() * 256);
        blueSlider.setValue(usingColor.getBlue() * 256);
    }
}
