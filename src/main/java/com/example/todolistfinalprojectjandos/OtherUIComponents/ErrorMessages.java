package com.example.todolistfinalprojectjandos.OtherUIComponents;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Here are all the error messages created and added to a VBox
 */
public class ErrorMessages {
    private VBox messages;
    private Label dateError;
    private Label timeError;
    private Label pastError;
    private Label emptyName;
    private Label emptyDays;

    /**
     * Here are the messages created and added to a VBox
     */

    public ErrorMessages() {
        messages=new VBox();
        dateError = new Label("Something wrong with the date");
        timeError = new Label("Something wrong with the time");
        pastError = new Label("You cannot make the task be in the past");
        emptyName = new Label("Name is missing");
        emptyDays = new Label("Number of days is missing");
        setLooks(dateError);
        setLooks(timeError);
        setLooks(pastError);
        setLooks(emptyName);
        setLooks(emptyDays);

        messages.getChildren().add(emptyName);
        messages.getChildren().add(emptyDays);
        messages.getChildren().add(dateError);
        messages.getChildren().add(timeError);
        messages.getChildren().add(pastError);
    }

    /**
     * This sets the looks of the label
     * @param label is the label
     */
    public void setLooks(Label label){
        label.setStyle("""
                -fx-text-fill: transparent;
                -fx-font-size: 18
                        """);
}

    public Label getDateError() {
        return dateError;
    }

    public Label getTimeError() {
        return timeError;
    }

    public Label getPastError() {
        return pastError;
    }

    public Label getEmptyName() {
        return emptyName;
    }

    public Label getEmptyDays() {
        return emptyDays;
    }
    public VBox getAllMessages(){return messages;}
}
