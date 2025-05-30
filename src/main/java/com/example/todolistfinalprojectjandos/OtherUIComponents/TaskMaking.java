package com.example.todolistfinalprojectjandos.OtherUIComponents;

import com.example.todolistfinalprojectjandos.Buttons.BackButton;
import com.example.todolistfinalprojectjandos.Buttons.SaveButton;
import com.example.todolistfinalprojectjandos.TaskRelated.ListOfTasks;
import javafx.scene.Group;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;

public class TaskMaking {
    private ListOfTasks listOfTasks;
    private Stage stage;
    private TextField name;
    private TextArea description;
    private DatePicker date;
    private TextField dateTextField;
    private TextField time;
    private BackButton backButton;
    private Title title;
    private ErrorMessages errorMessages;
    private  RepeatingMenu repeatingMenu;


    public TaskMaking(Stage stage,ListOfTasks listOfTasks) {
        title=new Title();
        this.stage=stage;
        this.listOfTasks=listOfTasks;


        backButton = new BackButton(listOfTasks, stage);


        name = new TextField("");
        name.setLayoutX(75);
        name.setLayoutY(150);
        name.setStyle("""
                -fx-background-color: white;
                -fx-border-color: rgb(83,83,83);
                -fx-border-width: 1;
                -fx-prompt-text-fill: rgb(83,83,83);
                -fx-font-size: 25;
                -fx-max-height: 50px;
                -fx-min-height: 50px;
                -fx-max-width: 300px;
                -fx-min-width: 300px;
                -fx-border-radius: 5px;
                    
                    """);



        description = new TextArea();
        description.setLayoutX(75);
        description.setLayoutY(210);
        description.setStyle("""
                -fx-background-color: white;
                -fx-border-color: rgb(83,83,83);
                -fx-border-width: 1;
                -fx-prompt-text-fill: rgb(83,83,83);
                -fx-font-size: 25px;
                -fx-max-height: 100px;
                -fx-min-height: 100px;
                -fx-max-width: 300px;
                -fx-min-width: 300px;
                -fx-border-radius: 5px;
                -fx-focus-color: transparent;
                -fx-faint-focus-color: transparent;    
                    """);




        date = new DatePicker();
        date.setLayoutX(75);
        date.setLayoutY(320);
        date.setStyle("""
                    -fx-background-color: white;
                    -fx-border-color: rgb(83,83,83);
                    -fx-prompt-text-fill: rgb(83,83,83);
                    -fx-border-width: 1;
                    -fx-border-radius: 5px;
                    -fx-max-height: 50px;
                -fx-min-height: 50px;
                -fx-max-width: 300px;
                -fx-min-width: 300px;
                -fx-font-size: 25px;
                
                """);
        dateTextField = date.getEditor();
        dateTextField.setStyle("""
                -fx-prompt-text-fill: rgb(83,83,83);
                -fx-text-fill: rgb(83,83,83);
                                """);



        time = new TextField("");
        time.setLayoutX(75);
        time.setLayoutY(380);
        time.setStyle("""
                -fx-background-color: white;
                -fx-border-color: rgb(83,83,83);
                -fx-border-width: 1;
                -fx-prompt-text-fill: rgb(83,83,83);
                -fx-font-size: 25;
                -fx-max-height: 50px;
                -fx-min-height: 50px;
                -fx-max-width: 300px;
                -fx-min-width: 300px;
                -fx-border-radius: 5px;
                
                    
                    """);
        time.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getText();
            if (!newText.matches("[0-9:]*")) {
                return null;
            }
            return change;
        }));



        errorMessages = new ErrorMessages();

        errorMessages.getAllMessages().setLayoutX(20);
        errorMessages.getAllMessages().setLayoutY(550);

        repeatingMenu = new RepeatingMenu();

    }


    public TextField getName() {
        return name;
    }

    public TextArea getDescription() {
        return description;
    }

    public DatePicker getDate() {
        return date;
    }

    public TextField getTime() {
        return time;
    }

    public BackButton getBackButton() {
        return backButton;
    }

    public Title getTitle() {
        return title;
    }

    public ErrorMessages getErrorMessages() {
        return errorMessages;
    }

    public RepeatingMenu getRepeatingMenu() {
        return repeatingMenu;
    }
}
