package AlexAzyavchikov.Components.SetupComponents;

import AlexAzyavchikov.Components.Component;
import javafx.scene.paint.Color;

public interface SetupComponent extends Component {

    void colorChangedEventListener();
    void setColor(Color color);

    void modifySliders();

    void modifyLabels();
}
