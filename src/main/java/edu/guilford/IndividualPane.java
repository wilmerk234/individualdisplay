package edu.guilford;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class IndividualPane extends GridPane {
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField emailField;
    private Button submitButton;
    private Label formattedNameLabel;

    // constructor
    public IndividualPane() {
        // instantiate the fields
        firstNameField = new TextField();  
        lastNameField = new TextField();
        emailField = new TextField();
        submitButton = new Button("Submit");
        formattedNameLabel = new Label();

        // add the fields to the gridpane, which requires a row, column, and column span
        this.add(firstNameField, 0, 0);
        this.add(lastNameField, 1, 0);
        this.add(emailField, 0, 1);
        this.add(submitButton, 0, 1, 2, 1);
        this.add(formattedNameLabel, 0, 2, 2, 1);

        // set the action for the button
        submitButton.setOnAction(e -> {
            // get the text from the fields
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String email = emailField.getText();

            // create an individual object
            Individual individual = new Individual(firstName, lastName, email, null);
            // set the text of the label to the formatted name
            formattedNameLabel.setText(individual.toString());
        });
    }

}
