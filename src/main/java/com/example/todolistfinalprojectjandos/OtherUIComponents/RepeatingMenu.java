package com.example.todolistfinalprojectjandos.OtherUIComponents;

import com.example.todolistfinalprojectjandos.RepeatType;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class RepeatingMenu {

    private Button repeatingButton;
    private Label repeatingLabel;
    private TextField repeatingTextField;
    private ContextMenu repeatMenu;
    private MenuItem daily;
    private MenuItem weekly;
    private MenuItem monthly;
    private MenuItem custom;
    private MenuItem none;

    private AtomicInteger numberOfDays;
    private RepeatType repeatType;

    public RepeatingMenu() {
        repeatingLabel = new Label("Repeat");
        setLooks(repeatingLabel);
        repeatingLabel.setPadding(new Insets(0, 0, 0, 18));
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
        repeatingButton.setOnAction(e -> {
            repeatMenu.show(repeatingButton, Side.TOP, 0, 0);
        });

        numberOfDays = new AtomicInteger(0);
        repeatType = RepeatType.NONE;

        daily = new MenuItem("Daily");
        weekly = new MenuItem("Weekly");
        monthly = new MenuItem("Monthly");
        custom = new MenuItem("Different");
        none = new MenuItem("None");

        repeatingTextField = new TextField("0");
        repeatingTextField.setLayoutX(75);
        repeatingTextField.setLayoutY(500);
        repeatingTextField.setVisible(false);
        repeatingTextField.setDisable(true);
        setLooks(repeatingTextField);
        setRepeatingTextFieldFormatter();

        custom.setOnAction(e -> {
            setAction("Different", Integer.parseInt(repeatingTextField.getText()), false, RepeatType.CUSTOM);
        });
        none.setOnAction(e -> {
            setAction("No repeat", 0, true, RepeatType.NONE);
        });
        monthly.setOnAction(e -> {
            setAction("Repeat monthly", 30, true, RepeatType.MONTHLY);
        });

        weekly.setOnAction(e -> {
            setAction("Repeat weekly", 7, true, RepeatType.WEEKLY);
        });

        daily.setOnAction(e -> {
            setAction("Repeat daily", 1, true, RepeatType.DAILY);
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

    public void setAction(String text, int numberOfDays, boolean disable, RepeatType repeatType) {
        repeatingLabel.setText(text);
        repeatingTextField.setDisable(disable);
        repeatingTextField.setVisible(!disable);
        this.repeatType = repeatType;
        repeatingTextField.setText(String.valueOf(numberOfDays));
        this.numberOfDays.set(numberOfDays);
    }

    public RepeatType getRepeatType() {
        return repeatType;
    }

    public void setLooks(Node node) {
        node.setStyle("""
                -fx-background-color: white;
                -fx-border-color: rgb(83,83,83);
                -fx-text-fill: rgb(83,83,83);
                -fx-font-size: 25;
                -fx-max-height: 50px;
                -fx-min-height: 50px;
                -fx-max-width: 300px;
                -fx-min-width: 300px;
                -fx-border-radius: 5px;
                -fx-border-width: 1;
                    """);
    }

    public void setRepeatingTextFieldFormatter() {
        repeatingTextField.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getText();
            if (!newText.matches("[0-9]*")) {
                return null;
            }
            return change;
        }));
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

    public AtomicInteger getNumberOfDays() {
        return numberOfDays;
    }
}
