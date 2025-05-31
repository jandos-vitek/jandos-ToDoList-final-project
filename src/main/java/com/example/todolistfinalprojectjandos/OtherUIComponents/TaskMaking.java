package com.example.todolistfinalprojectjandos.OtherUIComponents;

import com.example.todolistfinalprojectjandos.Buttons.BackButton;
import com.example.todolistfinalprojectjandos.Buttons.SaveButton;
import com.example.todolistfinalprojectjandos.TaskRelated.ListOfTasks;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;

/**
 * This class contains everything that is needed for creating or updating a task, except the buttons
 */
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

    /**
     * Constructs the UI components needed for task creation
     * @param listOfTasks is the list where all the tasks are added
     * @param stage is the main and only stage, it is there for setting the scene
     */
    public TaskMaking(Stage stage,ListOfTasks listOfTasks) {
        title=new Title();
        this.stage=stage;
        this.listOfTasks=listOfTasks;


        backButton = new BackButton(listOfTasks, stage);


        name = new TextField("");
        name.setLayoutX(75);
        name.setLayoutY(150);
        name.setMaxHeight(50);
        name.setMinHeight(50);
        setLooks(name);



        description = new TextArea();
        description.setLayoutX(75);
        description.setLayoutY(210);
        setLooks(description);
        description.setMaxHeight(100);
        description.setMinHeight(100);




        date = new DatePicker();
        date.setLayoutX(75);
        date.setLayoutY(320);
        date.setMaxHeight(50);
        date.setMinHeight(50);
        setLooks(date);
        dateTextField = date.getEditor();
        dateTextField.setStyle("""
                -fx-prompt-text-fill: rgb(83,83,83);
                -fx-text-fill: rgb(83,83,83);
                                """);



        time = new TextField("");
        time.setLayoutX(75);
        time.setLayoutY(380);
        time.setMaxHeight(50);
        time.setMinHeight(50);
        setLooks(time);
        setTextFormatter();




        errorMessages = new ErrorMessages();

        errorMessages.getAllMessages().setLayoutX(20);
        errorMessages.getAllMessages().setLayoutY(550);

        repeatingMenu = new RepeatingMenu();

    }
    /**
     * Applies a consistent style to a node
     *
     * @param node is the node to style
     */
    public void setLooks(Node node){
        node.setStyle("""
                        -fx-background-color: white;
                        -fx-border-color: rgb(83,83,83);
                        -fx-border-width: 1;
                        -fx-prompt-text-fill: rgb(83,83,83);
                        -fx-font-size: 25;
                        -fx-max-width: 300px;
                        -fx-min-width: 300px;
                        -fx-border-radius: 5px;
                        -fx-focus-color: transparent;
                                -fx-faint-focus-color: transparent; 
                                """
                    );

    }
    /**
     * Sets a text formatter for the time, so the user can write only numbers and :
     */
public void setTextFormatter(){
    time.setTextFormatter(new TextFormatter<>(change -> {
        String newText = change.getText();
        if (!newText.matches("[0-9:]*")) {
            return null;
        }
        return change;
    }));
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
