package com.example.todolistfinalprojectjandos.OtherUIComponents;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ErrorMessages {
    private VBox messages;
    private Label dateError;
    private Label timeError;
    private Label pastError;
    private Label emptyName;
    private Label emptyDays;
    public Node getMessages() {
        return messages;
    }

    public ErrorMessages() {
        messages=new VBox();
        dateError = new Label("Something wrong with the date");
        timeError = new Label("Something wrong with the time");
        pastError = new Label("You cannot make the task be in the past");
        emptyName = new Label("Name is missing");
        emptyDays = new Label("Number of days is missing");
        pastError.setStyle("""
                -fx-text-fill: transparent;
                -fx-font-size: 18;
                        """);
        dateError.setStyle("""
                -fx-text-fill: transparent;
                -fx-font-size: 18;
                        """);
        timeError.setStyle("""
                -fx-text-fill: transparent;
                -fx-font-size: 18;
                        """);
        emptyName.setStyle("""
                -fx-text-fill: transparent;
                -fx-font-size: 18;
                        """);
       emptyDays.setStyle("""
                -fx-text-fill: transparent;
                -fx-font-size: 18
                        """);

        messages.getChildren().add(emptyName);
        messages.getChildren().add(emptyDays);
        messages.getChildren().add(dateError);
        messages.getChildren().add(timeError);
        messages.getChildren().add(pastError);
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
