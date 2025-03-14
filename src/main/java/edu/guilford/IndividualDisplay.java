package edu.guilford;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class IndividualDisplay extends Application {

    private static Scene scene;

    // Each JavaFX application provides a Stage, a window for the application
    @Override
    public void start(Stage stage) throws IOException {

        // create an instance of the IndividualPane class
        // IndividualPane is a container for the UI elements
        IndividualPane iPane = new IndividualPane();
        // The scene hold a container (a Pane or a Group, usually)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("control.fxml"));
        Parent root = loader.load(); // load the FXML file
        scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        stage.setX(0);
        stage.setY(100);

        // Let's build a new Stage/Scene with ShapePane
        // and set it as the root of the scene
        Stage shapeStage = new Stage();
        shapeStage.setTitle("Shape Display");
        ShapePane shapePane = new ShapePane(640, 480);
        // Instantiate a ShapeList and generate shapes
        ShapeList shapeList = new ShapeList(640, 480);
        shapeList.generateShapes(60); // generate 10 random shapes  
        shapePane.setShapeList(shapeList); // set the ShapeList to the ShapePane
        shapePane.updateShapes(); // update the ShapePane with the shapes
        Scene shapeScene = new Scene(shapePane, 640, 480);
        shapeStage.setScene(shapeScene);
        shapeStage.show();

        // Get the ControlController object and tell it about the ShapeList and ShapePane
        ControlController controlController = (ControlController) loader.getController();
        controlController.setShapeList(shapeList);
        controlController.setShapePane(shapePane);
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(IndividualDisplay.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}