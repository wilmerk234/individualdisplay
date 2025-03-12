package edu.guilford;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PrimaryController {

    @FXML
    private Label primaryLabel;

    @FXML
    private void switchToSecondary() throws IOException {
       // IndividualDisplay.setRoot("secondary");
       primaryLabel.setText("Pressed the button");
    }
}
