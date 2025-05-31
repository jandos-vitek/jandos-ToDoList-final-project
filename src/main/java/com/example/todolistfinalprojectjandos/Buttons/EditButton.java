package com.example.todolistfinalprojectjandos.Buttons;

import com.example.todolistfinalprojectjandos.Scenes.EditingTaskScene;
import com.example.todolistfinalprojectjandos.Scenes.HomePage;
import com.example.todolistfinalprojectjandos.TaskRelated.ListOfTasks;
import com.example.todolistfinalprojectjandos.TaskRelated.Task;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *Button that opens EditingTaskScene
 */

public class EditButton extends Button {
    private ListOfTasks listOfTasks;
    private Stage stage;
    private Task task;
    private EditingTaskScene editingTaskScene;

    /**
     * This is constructor for the button, the looks and action are defined here
     * @param listOfTasks is the list where all the tasks are added
     * @param stage is the main and only stage, it is there for setting the scene
     * @param task is the Task that will the user be editing in EditingTaskScene
     */
    public EditButton(ListOfTasks listOfTasks, Stage stage,Task task) {
        this.listOfTasks=listOfTasks;
        this.stage=stage;
        this.task=task;

        setText("EDIT");
        setLayoutY(590);
        setLayoutX(260);
        setStyle("""            
                -fx-background-color: rgb(0, 110, 255);
                -fx-text-fill: black;
                -fx-font-size: 25px;
                -fx-font-weight: bold;
                -fx-max-height: 50px;
                -fx-min-height: 50px;
                -fx-max-width: 140px;
                -fx-min-width: 140px;              
                -fx-background-radius: 5px;     
                """);
        setAction();
    }

    /**
     * This sets the action for the button
     * It creates the EditingTaskScene scene and then sets current scene to it
     */
    public void setAction(){
        setOnAction(e -> {
            editingTaskScene=new EditingTaskScene(listOfTasks,task);
            stage.setScene(editingTaskScene.getScene(stage));
        });
    }
}
