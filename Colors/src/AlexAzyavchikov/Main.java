package AlexAzyavchikov;


import AlexAzyavchikov.Components.Draw.DrawComponent;
import AlexAzyavchikov.Components.SetupComponents.CMYKSetupComponent;
import AlexAzyavchikov.Components.SetupComponents.ColorPickerComponent;
import AlexAzyavchikov.Components.SetupComponents.HSVSetupComponent;
import AlexAzyavchikov.Components.SetupComponents.RGBSetupComponent;
import AlexAzyavchikov.Mediator.Mediator;
import AlexAzyavchikov.Mediator.Paint;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Mediator mediator = new Paint();

        mediator.registerComponent(new DrawComponent());
        mediator.registerComponent(new RGBSetupComponent());
        mediator.registerComponent(new HSVSetupComponent());
        mediator.registerComponent(new CMYKSetupComponent());
        mediator.registerComponent(new ColorPickerComponent());

        mediator.createGUI(stage);
    }
}