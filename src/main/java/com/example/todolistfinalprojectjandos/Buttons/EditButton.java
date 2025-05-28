package com.example.todolistfinalprojectjandos.Buttons;

import com.example.todolistfinalprojectjandos.Scenes.EditingTaskScene;
import com.example.todolistfinalprojectjandos.Scenes.HomePage;
import com.example.todolistfinalprojectjandos.TaskRelated.ListOfTasks;
import com.example.todolistfinalprojectjandos.TaskRelated.Task;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EditButton extends Button {
    private ListOfTasks listOfTasks;
    private Stage stage;
    private Task task;
    EditingTaskScene editingTaskScene;

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
    public void setAction(){
        setOnAction(e -> {
            editingTaskScene=new EditingTaskScene(listOfTasks,task);
            stage.setScene(editingTaskScene.getScene(stage));
        });
    }
}
