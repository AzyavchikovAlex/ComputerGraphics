package AlexAzyavchikov.Components.SetupComponents;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;

public class HSVSetupComponent extends SetupComponentImpl {
    private Slider hueSlider = new Slider();
    private Slider saturationSlider = new Slider();
    private Slider valueSlider = new Slider();
    private Label hueLabel = new Label();
    private Label saturationLabel = new Label();
    private Label valueLabel = new Label();

    public HSVSetupComponent() {
        Label label = new Label("HSV");
        setupSlider(hueSlider, 0, 359);
        setupSlider(saturationSlider, 0, 100);
        setupSlider(valueSlider, 0, 100);
        modifyLabels();
        this.getChildren().addAll(label,
                manageSliderLayout(hueSlider, hueLabel),
                manageSliderLayout(saturationSlider, saturationLabel),
                manageSliderLayout(valueSlider, valueLabel));
    }

    @Override
    public String getName() {
        return "HSVSetup";
    }

    @Override
    public void colorChangedEventListener() {
        usingColor = Color.hsb(hueSlider.getValue(),
                saturationSlider.getValue() / 100.,
                valueSlider.getValue() / 100.);
        modifyLabels();
        mediator.setRGBAndCMYKFillColor(usingColor);
    }
//        double r = color.getRed();
//        double g = color.getGreen();
//        double b = color.getBlue();
//        // h, s, v = hue, saturation, value
//        double cmax = Math.max(r, Math.max(g, b)); // maximum of r, g, b
//        double cmin = Math.min(r, Math.min(g, b)); // minimum of r, g, b
//        double diff = cmax - cmin; // diff of cmax and cmin.
//        double h = -1, s = -1;
//
//        // if cmax and cmax are equal then h = 0
//        if (cmax == cmin)
//            h = 0;
//
//            // if cmax equal r then compute h
//        else if (cmax == r)
//            h = (60 * ((g - b) / diff) + 360) % 360;
//
//            // if cmax equal g then compute h
//        else if (cmax == g)
//            h = (60 * ((b - r) / diff) + 120) % 360;
//
//            // if cmax equal b then compute h
//        else if (cmax == b)
//            h = (60 * ((r - g) / diff) + 240) % 360;
//
//        // if cmax equal zero
//        if (cmax == 0)
//            s = 0;
//        else
//            s = (diff / cmax) * 100;
//
//        // compute v

//        double v = cmax * 100;

    @Override
    public void modifySliders() {
        hueSlider.setValue(usingColor.getHue());
        saturationSlider.setValue(usingColor.getSaturation() * 100);
        valueSlider.setValue(usingColor.getBrightness() * 100);

    }

    @Override
    public void modifyLabels() {
        hueLabel.setText("Hue: " + hueSlider.getValue());
        saturationLabel.setText("Saturation: " + saturationSlider.getValue());
        valueLabel.setText("Value: " + valueSlider.getValue());

    }
}
