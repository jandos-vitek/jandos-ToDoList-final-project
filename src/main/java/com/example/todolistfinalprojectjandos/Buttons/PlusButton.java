package com.example.todolistfinalprojectjandos.Buttons;

import com.example.todolistfinalprojectjandos.TaskRelated.ListOfTasks;
import com.example.todolistfinalprojectjandos.Scenes.CreatingTaskScene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
/**
 * Button that is used for opening homePage
 */
public class PlusButton extends Button {
    private ImageView plusIcon;
    private ListOfTasks listOfTasks;
    private Stage stage;
    /**
     * This is constructor for the button, the looks and action are defined here
     * @param listOfTasks is the list where all the tasks are added
     * @param stage is the main and only stage, it is there for setting the scene
     **/
    public PlusButton(ListOfTasks listOfTasks,Stage stage) {
        this.listOfTasks=listOfTasks;
        this.stage=stage;
        plusIcon = new ImageView(getClass().getResource("/plus.png").toExternalForm());
        plusIcon.setFitWidth(35);
        plusIcon.setFitHeight(35);

        setGraphic(plusIcon);
        setStyle("""
                -fx-background-color: rgba(0, 110, 255, 1);
                -fx-text-fill: black;
                -fx-font-size: 35px;
                -fx-font-weight: bold;
                -fx-max-height: 75px;
                -fx-max-width: 75px;
                -fx-min-width: 75px;
                -fx-min-height: 75px;
                -fx-background-radius: 75px;
        """);
        setLayoutX(320);
        setLayoutY(570);
        setAction();
    }
    /**
     * This sets the action for the button
     * It just creates the scene and then it sets current scene to it
     */
    public void setAction(){
        setOnAction(e -> {
            CreatingTaskScene creatingTaskScene = new CreatingTaskScene(listOfTasks);
            stage.setScene(creatingTaskScene.getScene(stage));
        });
    }
}
