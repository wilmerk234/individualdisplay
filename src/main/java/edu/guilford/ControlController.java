package edu.guilford;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;

public class ControlController {

    private ShapeList shapeList;
    private ShapePane shapePane;

    @FXML
private Slider slider;

    @FXML
    public void readSlider() {
        System.out.println("Slider value: " + slider.getValue());
    }

    @FXML
    public void processButton() {
        System.out.println("Button pressed");
        shapeList.clear();
        shapePane.getChildren().clear();
    }

    // getters setters

    public ShapeList getShapeList() {
        return shapeList;
    }

    public void setShapeList(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    public ShapePane getShapePane() {
        return shapePane;
    }

    public void setShapePane(ShapePane shapePane) {
        this.shapePane = shapePane;
    }

    // tell shapelist to clear and

}