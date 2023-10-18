package AlexAzyavchikov.Components.SetupComponents;

import AlexAzyavchikov.Components.Component;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;

public class CMYKSetupComponent extends SetupComponentImpl implements Component {
    private Slider cyanSlider = new Slider();
    private Slider magentaSlider = new Slider();
    private Slider yellowSlider = new Slider();
    private Slider blackSlider = new Slider();
    private Label cyanLabel = new Label();
    private Label magentaLabel = new Label();
    private Label yellowLabel = new Label();
    private Label blackLabel = new Label();

    public CMYKSetupComponent() {
        Label label = new Label("CMYK");
        setupSlider(cyanSlider, 0, 100);
        setupSlider(magentaSlider, 0, 100);
        setupSlider(yellowSlider, 0, 100);
        setupSlider(blackSlider, 0, 100);
        modifyLabels();
        this.getChildren().addAll(label,
                manageSliderLayout(cyanSlider, cyanLabel),
                manageSliderLayout(magentaSlider, magentaLabel),
                manageSliderLayout(yellowSlider, yellowLabel),
                manageSliderLayout(blackSlider, blackLabel));
    }

    @Override
    public String getName() {
        return "CMYKSetup";
    }

    @Override
    public void colorChangedEventListener() {
        usingColor = Color.rgb((int) (255 * (1 - cyanSlider.getValue() / 100.) * (1. - blackSlider.getValue() / 100.)),
                (int) (255 * (1. - magentaSlider.getValue() / 100.) * (1. - blackSlider.getValue() / 100.)),
                (int) (255 * (1. - yellowSlider.getValue() / 100.) * (1. - blackSlider.getValue() / 100.)));
        modifyLabels();
        mediator.setRGBAndHsvFillColor(usingColor);
    }

    @Override
    public void modifyLabels() {
        blackLabel.setText("Black: " + blackSlider.getValue());
        cyanLabel.setText("Cyan: " + cyanSlider.getValue());
        magentaLabel.setText("Magenta: " + magentaSlider.getValue());
        yellowLabel.setText("Yellow: " + yellowSlider.getValue());

    }

    @Override
    public void modifySliders() {
        double black = 1 - Math.max(usingColor.getRed(), Math.max(usingColor.getGreen(), usingColor.getBlue()));
        blackSlider.setValue(100 * black);
        double cyan, magenta, yellow;
        if (black == 1) {
            cyan = magenta = yellow = 0;
        } else {
            cyan = (1 - usingColor.getRed() - black) / (1 - black);
            magenta = (1 - usingColor.getGreen() - black) / (1 - black);
            yellow = (1 - usingColor.getBlue() - black) / (1 - black);
        }
        cyanSlider.setValue(100 * cyan);
        magentaSlider.setValue(100 * magenta);
        yellowSlider.setValue(100 * yellow);

    }
}

