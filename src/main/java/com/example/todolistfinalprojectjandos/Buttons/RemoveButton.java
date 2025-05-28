package com.example.todolistfinalprojectjandos.Buttons;

import com.example.todolistfinalprojectjandos.TaskRelated.ListOfTasks;
import com.example.todolistfinalprojectjandos.Scenes.HomePage;
import com.example.todolistfinalprojectjandos.TaskRelated.Task;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RemoveButton extends Button {
    private HomePage homePage;
    private ListOfTasks listOfTasks;
    private Stage stage;
    private Task task;
    public RemoveButton(ListOfTasks listOfTasks, Stage stage,Task task) {
        this.listOfTasks=listOfTasks;
        this.stage=stage;
        this.task=task;
        setText("REMOVE");
        setLayoutY(590);
        setLayoutX(40);
        setStyle("""            
                -fx-background-color: rgb(206,11,11);
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
            listOfTasks.removeTask(task);
            homePage = new HomePage(listOfTasks);
            stage.setScene(homePage.getScene(stage));
        });
    }

}
