package com.example.todolistfinalprojectjandos.Scenes;

import com.example.todolistfinalprojectjandos.Buttons.BackButton;
import com.example.todolistfinalprojectjandos.Buttons.EditButton;
import com.example.todolistfinalprojectjandos.Buttons.RemoveButton;
import com.example.todolistfinalprojectjandos.OtherUIComponents.Title;
import com.example.todolistfinalprojectjandos.TaskRelated.ListOfTasks;
import com.example.todolistfinalprojectjandos.TaskRelated.Task;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TaskDetail {
    private ListOfTasks listOfTasks;
    private Group root;
    private Scene taskDetail;
    private BackButton backButton;
    private Task task;
    private Title title;
    private Text description;
    private RemoveButton removeButton;
    private EditButton editButton;

    public Scene getScene(Stage stage) {
        root = new Group();
        taskDetail = new Scene(root, 720, 450, Color.WHITE);

        title = new Title();
        title.getTitle().setText(task.getName());
        double x = (450 - title.getTitle().getBoundsInLocal().getWidth()) / 2;
        title.getTitle().setX(x);
        title.getTitle().setY(110);
        root.getChildren().add(title.getTitle());
        root.getChildren().add(title.getBlackLine());
        root.getChildren().add(title.getBlueBox());

        backButton = new BackButton(listOfTasks, stage);
        root.getChildren().add(backButton);

        description = new Text(task.getDescription());
        description.setFill(Color.BLACK);
        description.setFont(Font.font("System", FontWeight.BOLD, 20));
        description.setLayoutX(25);
        description.setLayoutY(170);
        root.getChildren().add(description);

        removeButton=new RemoveButton(listOfTasks,stage,task);
        root.getChildren().add(removeButton);

        editButton=new EditButton(listOfTasks,stage,task);
        root.getChildren().add(editButton);



        return taskDetail;
    }

    public TaskDetail(ListOfTasks listOfTasks, Task task) {
        this.task = task;
        this.listOfTasks = listOfTasks;
    }
}
