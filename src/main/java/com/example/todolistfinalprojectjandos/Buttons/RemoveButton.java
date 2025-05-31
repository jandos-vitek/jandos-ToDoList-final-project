package com.example.todolistfinalprojectjandos.Buttons;

import com.example.todolistfinalprojectjandos.TaskRelated.ListOfTasks;
import com.example.todolistfinalprojectjandos.Scenes.HomePage;
import com.example.todolistfinalprojectjandos.TaskRelated.Task;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *  Button that removes task from listOfTasks and opens homepage
 */
public class RemoveButton extends Button {
    private HomePage homePage;
    private ListOfTasks listOfTasks;
    private Stage stage;
    private Task task;
    /**
     * This is constructor for the button, the looks and action are defined here
     * @param listOfTasks is the list where all the tasks are added
     * @param stage is the main and only stage, it is there for setting the scene
     * @param task is the task that will be removed
     */
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
    /**
     * This sets the action for the button
     * It removes the task from listOfTasks
     * It creates the Homepage scene and then sets current scene to it
     */
    public void setAction(){
        setOnAction(e -> {
            listOfTasks.removeTask(task);
            homePage = new HomePage(listOfTasks);
            stage.setScene(homePage.getScene(stage));
        });
    }

}
