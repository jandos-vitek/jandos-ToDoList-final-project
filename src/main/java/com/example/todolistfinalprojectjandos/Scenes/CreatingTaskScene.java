package com.example.todolistfinalprojectjandos.Scenes;

import com.example.todolistfinalprojectjandos.Buttons.SaveButton;
import com.example.todolistfinalprojectjandos.OtherUIComponents.TaskMaking;
import com.example.todolistfinalprojectjandos.TaskRelated.ListOfTasks;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Class, that has a scene that is used for creating task
 */
public class CreatingTaskScene{

    private ListOfTasks listOfTasks;
    private TaskMaking taskMaking;
    private Group root;
    private SaveButton saveButton;
    private Scene creatingTask;

    /**
     * The visual elements are added to the root here
     * @param stage is the main and only stage, it is there for setting the scene
     * @return creatingTaskScene, it is used for setting the scene
     */
    public Scene getScene(Stage stage) {
        root = new Group();
        creatingTask = new Scene(root, 720, 450, Color.WHITE);
        taskMaking = new TaskMaking(stage, listOfTasks);

        taskMaking.getTitle().getTitle().setText("NEW TASK");

        double x = (450 - taskMaking.getTitle().getTitle().getBoundsInLocal().getWidth()) / 2;
        taskMaking.getTitle().getTitle().setX(x);
        taskMaking.getTitle().getTitle().setY(110);

        root.getChildren().add(taskMaking.getTitle().getTitle());
        root.getChildren().add(taskMaking.getTitle().getBlackLine());
        root.getChildren().add(taskMaking.getTitle().getBlueBox());

        taskMaking.getName().setPromptText("Name");
        root.getChildren().add(taskMaking.getName());

        taskMaking.getDescription().setPromptText("Description");
        root.getChildren().add(taskMaking.getDescription());

        taskMaking.getDate().setPromptText("Due date");
        root.getChildren().add(taskMaking.getDate());

        taskMaking.getTime().setPromptText("Time");
        root.getChildren().add(taskMaking.getTime());

        root.getChildren().add(taskMaking.getRepeatingMenu().getRepeatingLabel());
        root.getChildren().add(taskMaking.getRepeatingMenu().getRepeatingTextField());
        root.getChildren().add(taskMaking.getRepeatingMenu().getRepeatingButton());

        root.getChildren().add(taskMaking.getErrorMessages().getAllMessages());

        saveButton = new SaveButton(listOfTasks, stage, taskMaking);

        root.getChildren().add(saveButton);
        root.getChildren().add(taskMaking.getBackButton());

        return creatingTask;
    }


    public CreatingTaskScene(ListOfTasks listOfTasks) {
        this.listOfTasks = listOfTasks;
    }
}
