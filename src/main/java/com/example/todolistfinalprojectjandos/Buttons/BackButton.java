package com.example.todolistfinalprojectjandos.Buttons;

import com.example.todolistfinalprojectjandos.TaskRelated.ListOfTasks;
import com.example.todolistfinalprojectjandos.Scenes.HomePage;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Button that is used for opening homePage
 */
public class BackButton extends Button{
    private ImageView icon;
    private HomePage homePage;
    private ListOfTasks listOfTasks;
    private Stage stage;
/**
 * This is constructor for the button, the looks and action are defined here
 * @param listOfTasks is the list where all the tasks are added
 * @param stage is the main and only stage, it is there for setting the scene
 **/
    public BackButton(ListOfTasks listOfTasks, Stage stage) {
        this.listOfTasks=listOfTasks;
        this.stage=stage;

        setLayoutX(0);
        setLayoutY(0);

        icon = new ImageView(getClass().getResource("/back.png").toExternalForm());
        icon.setFitWidth(50);
        icon.setFitHeight(50);
        setGraphic(icon);
        setStyle("""
                -fx-background-color: transparent;
                -fx-border-color: transparent;
                        """);
        setAction();

    }
    /**
     * This sets the action for the button
     * It just creates the scene and then it sets current scene to it
     */
    public void setAction(){
        setOnAction(e -> {
            homePage = new HomePage(listOfTasks);
            stage.setScene(homePage.getScene(stage));
        });
    }


}
