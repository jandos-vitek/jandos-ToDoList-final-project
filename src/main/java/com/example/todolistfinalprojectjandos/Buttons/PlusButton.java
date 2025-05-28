package com.example.todolistfinalprojectjandos.Buttons;

import com.example.todolistfinalprojectjandos.TaskRelated.ListOfTasks;
import com.example.todolistfinalprojectjandos.Scenes.CreatingTaskScene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PlusButton extends Button {
    ImageView plusIcon;
    private ListOfTasks listOfTasks;
    private Stage stage;
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
    public void setAction(){
        setOnAction(e -> {
            CreatingTaskScene creatingTaskScene = new CreatingTaskScene(listOfTasks);
            stage.setScene(creatingTaskScene.getScene(stage));
        });
    }
}
