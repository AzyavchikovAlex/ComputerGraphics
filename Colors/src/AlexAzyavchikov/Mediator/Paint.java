package AlexAzyavchikov.Mediator;

import AlexAzyavchikov.Components.Component;
import AlexAzyavchikov.Components.Draw.DrawComponent;
import AlexAzyavchikov.Components.SetupComponents.CMYKSetupComponent;
import AlexAzyavchikov.Components.SetupComponents.HSVSetupComponent;
import AlexAzyavchikov.Components.SetupComponents.RGBSetupComponent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;

public class Paint implements Mediator {
    private DrawComponent drawComponent;
    private RGBSetupComponent rgbSetupComponent;
    private HSVSetupComponent hsvSetupComponent;
    private CMYKSetupComponent cmykSetupComponent;

    @Override
    public void registerComponent(Component component) {
        component.setMediator(this);
        switch (component.getName()) {
            case "Draw" -> drawComponent = (DrawComponent) component;
            case "RGBSetup" -> rgbSetupComponent = (RGBSetupComponent) component;
            case "HSVSetup" -> hsvSetupComponent = (HSVSetupComponent) component;
            case "CMYKSetup" -> cmykSetupComponent = (CMYKSetupComponent) component;
        }
    }

    @Override
    public void setFillColor(Color color) {
        drawComponent.setFillColor(color);
        rgbSetupComponent.setColor(color);
        hsvSetupComponent.setColor(color);
        cmykSetupComponent.setColor(color);
    }

    @Override
    public void setRGBAndHsvFillColor(Color color) {
        drawComponent.setFillColor(color);
        rgbSetupComponent.setColor(color);
        hsvSetupComponent.setColor(color);
    }

    @Override
    public void setRGBAndCMYKFillColor(Color color) {
        drawComponent.setFillColor(color);
        rgbSetupComponent.setColor(color);
        cmykSetupComponent.setColor(color);
    }

    @Override
    public Color getFillColor() {
        return drawComponent.getFillColor();
    }

    @Override
    public void createGUI(Stage stage) {
        setConnections();
        manageLayout(stage);
        stage.show();
    }

    private void manageLayout(Stage stage) {
        VBox root = new VBox();
        root.getChildren().addAll(manageSettingsLayout(), manageDrawingField());

        stage.setScene(new Scene(root));
        stage.setTitle("Colors");
        stage.setMinHeight(400);
        stage.setMinWidth(600);
    }

    private HBox manageSettingsLayout() {
        HBox settings = new HBox();
        makeHResizable(rgbSetupComponent, hsvSetupComponent, cmykSetupComponent);
        settings.getChildren().addAll(rgbSetupComponent, hsvSetupComponent, cmykSetupComponent);
        HBox.setHgrow(settings, Priority.NEVER);
        return settings;
    }

    private StackPane manageDrawingField() {
        StackPane holder = new StackPane();
        VBox.setVgrow(holder, Priority.ALWAYS);
        holder.setStyle("-fx-background-color: white");
        VBox.setVgrow(drawComponent, Priority.ALWAYS);
        holder.getChildren().add(drawComponent);
        return holder;
    }

    private static void makeHResizable(VBox... objects) {
        Arrays.stream(objects).forEach((object) -> {
            HBox.setHgrow(object, Priority.ALWAYS);
            object.setMaxWidth(Double.MAX_VALUE);
        });
    }

    private void setConnections() {
//        drawComponent.setOnMouseClicked((event) -> drawComponent.drawColor());
    }
}
