package AlexAzyavchikov.Components.SetupComponents;

import AlexAzyavchikov.Mediator.Mediator;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public abstract class SetupComponentImpl extends VBox implements SetupComponent {
    protected Mediator mediator;
    protected Color usingColor = Color.BLACK;

    @Override
    public void setColor(Color color) {
        usingColor = color;
        modifySliders();
        modifyLabels();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }


    public void setupSlider(Slider slider, int min, int max) {
        slider.setMin(min);
        slider.setMax(max);
        slider.setOnMouseReleased((event) -> colorChangedEventListener());
        slider.setOnKeyPressed((event) -> colorChangedEventListener());
    }

    public VBox manageSliderLayout(Slider slider, Label label) {
        VBox box = new VBox();
        box.getChildren().addAll(label, slider);
        return box;
    }
}
