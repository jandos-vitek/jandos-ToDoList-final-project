package com.example.todolistfinalprojectjandos.OtherUIComponents;

import javafx.geometry.Side;
import javafx.scene.control.*;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class RepeatingMenu {
    private Button repeatingButton;
    private Label repeatingLabel;
    private TextField repeatingTextField;
    ContextMenu repeatMenu;
    MenuItem daily;
    MenuItem weekly;
    MenuItem monthly;
    MenuItem custom;
    MenuItem none;

    AtomicBoolean isRepeating ;
    AtomicInteger numberOfDays;
    AtomicBoolean isCustom;
    public RepeatingMenu() {
        repeatingLabel = new Label("Repeat");
        repeatingLabel.setStyle("""
                -fx-background-color: white;
                -fx-border-color: rgb(83,83,83);
                -fx-text-fill: rgb(83,83,83);
                -fx-font-size: 25;
                -fx-max-height: 50px;
                -fx-min-height: 50px;
                -fx-max-width: 300px;
                -fx-min-width: 300px;
                -fx-border-radius: 5px;
                -fx-padding: 0 0 0 18;
                    """);
        repeatingLabel.setLayoutX(75);
        repeatingLabel.setLayoutY(440);


        repeatingButton = new Button();
        repeatingButton.setLayoutX(325);
        repeatingButton.setLayoutY(440);
        repeatingButton.setStyle("""
                -fx-background-color: rgb(83,83,83);
                -fx-border-color: rgb(83,83,83);
                -fx-border-width: 1;
                -fx-max-height: 50px;
                -fx-min-height: 50px;
                -fx-max-width: 50px;
                -fx-min-width: 50px;
                -fx-border-radius: 5px;
                    """);

         isRepeating = new AtomicBoolean(false);
         numberOfDays= new AtomicInteger();
         isCustom= new AtomicBoolean(false);

        daily = new MenuItem("Daily");
        weekly = new MenuItem("Weekly");
        monthly = new MenuItem("Monthly");
        custom = new MenuItem("Different");
        none = new MenuItem("None");


        repeatingTextField=new TextField();
        repeatingTextField.setStyle("""
        -fx-background-color: white;
        -fx-border-color: rgb(83,83,83);
        -fx-border-width: 1;
        -fx-prompt-text-fill: rgb(83,83,83);
        -fx-font-size: 25;
        -fx-max-height: 50px;
        -fx-min-height: 50px;
        -fx-max-width: 300px;
        -fx-min-width: 300px;
        -fx-border-radius: 5px;""");
        repeatingTextField.setLayoutX(75);
        repeatingTextField.setLayoutY(500);
        repeatingTextField.setPromptText("Number of days");
        repeatingTextField.setVisible(false);
        repeatingTextField.setDisable(true);


        repeatingTextField.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getText();
            if (!newText.matches("[0-9]*")) {
                return null;
            }
            return change;
        }));


        daily.setOnAction(e -> {
            repeatingLabel.setText("Repeat daily");
            isRepeating.set(true);
            isCustom.set(false);
            numberOfDays.set(1);
            hideRepeatingTextField();
        });

        weekly.setOnAction(e -> {
            repeatingLabel.setText("Repeat weekly");
            isRepeating.set(true);
            isCustom.set(false);
            numberOfDays.set(7);
            hideRepeatingTextField();
        });

        monthly.setOnAction(e -> {
            repeatingLabel.setText("Repeat monthly");
            isRepeating.set(true);
            isCustom.set(false);
            numberOfDays.set(30);
            hideRepeatingTextField();
        });

        none.setOnAction(e -> {
            repeatingLabel.setText("No repeat");
            isRepeating.set(false);
            isCustom.set(false);
            hideRepeatingTextField();

        });
        custom.setOnAction(e->{
            showRepeatingTextField();
            isRepeating.set(true);
            isCustom.set(true);
        });

        repeatingButton.setOnAction(e -> {
            repeatMenu.show(repeatingButton, Side.TOP, 0, 0);
        });

        repeatMenu = new ContextMenu(daily, weekly, monthly, custom, none);

        repeatMenu.setStyle("""
                -fx-max-height: 210px;
                 -fx-min-height: 210px;
                 -fx-max-width: 100px;
                 -fx-min-width: 100px;
                 -fx-font-size: 18;
                """);
    }
    public void showRepeatingTextField(){
        repeatingTextField.setDisable(false);
        repeatingTextField.setVisible(true);
    }
    public void hideRepeatingTextField(){
        repeatingTextField.setDisable(true);
        repeatingTextField.setVisible(false);
    }

    public Button getRepeatingButton() {
        return repeatingButton;
    }

    public Label getRepeatingLabel() {
        return repeatingLabel;
    }

    public TextField getRepeatingTextField() {
        return repeatingTextField;
    }



    public AtomicBoolean getIsRepeating() {
        return isRepeating;
    }

    public AtomicInteger getNumberOfDays() {
        return numberOfDays;
    }

    public AtomicBoolean getIsCustom() {
        return isCustom;
    }
}
