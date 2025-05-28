package com.example.todolistfinalprojectjandos.TaskRelated;

import com.example.todolistfinalprojectjandos.Scenes.TaskDetail;
import com.example.todolistfinalprojectjandos.TaskRelated.ListOfTasks;
import com.example.todolistfinalprojectjandos.TaskRelated.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class TaskCell extends ListCell<Task> {
    private HBox content;
    private StackPane contentWithButton;
    private Text name;
    private Button done;
    private TaskDetail taskDetail;
    private Task task;

    private ListOfTasks listOfTasks;
    private Stage stage;
    Region invisibleButton;


    public TaskCell(ListOfTasks listOfTasks, Stage stage) {
        this.listOfTasks = listOfTasks;
        this.stage = stage;

        name = new Text();
        name.setTranslateY(-10);

        done = new Button();
        done.setStyle("""
                -fx-background-color: white;
                -fx-max-width: 26px;
                -fx-min-width: 26px;
                -fx-max-height: 26px;
                -fx-min-height: 26px;
                -fx-border-color: black;
                """);
        done.setOnAction(e -> {
            if (task != null) {
                if(task.isRepeating()) {
                    LocalDateTime newTime=task.getDateTime().plusDays(task.getNumberOfDays());
                    listOfTasks.addTask(new Task(task.getName(),task.getDescription(),newTime,task.isRepeating(),task.getNumberOfDays()));
                }
                listOfTasks.removeTask(task);
            }
        });
        invisibleButton = new Region();
        invisibleButton.setStyle("""
                -fx-background-color: transparent;
                -fx-max-width: 375px;
                                -fx-min-width: 375px;
                                -fx-max-height: 50px;
                                -fx-min-height: 50px;
                                """);
        invisibleButton.setMouseTransparent(false);

        contentWithButton = new StackPane(name, invisibleButton);
        contentWithButton.setAlignment(Pos.CENTER_LEFT);
        contentWithButton.setMargin(name, new Insets(0, 0, 5, 10));
        content = new HBox(done, contentWithButton);
        content.setStyle("""
                -fx-max-height: 50px;
                -fx-min-height: 50px;
                -fx-min-width: 375px;
                -fx-max-width: 375px;
                -fx-border-color: black;
                -fx-padding: 10 30 10 10;
                -fx-border-width: 0 0 3 0;
                """);
    }

    @Override
    protected void updateItem(Task task, boolean empty) {
        super.updateItem(task, empty);
        this.task = task;

        if (empty || task == null) {
            setGraphic(null);
            setText(null);
            setStyle("");
        } else {
            name.setText(task.toString());

            if (task.isOverdue()) {
                name.setFill(Color.rgb(230,10,10));
            } else {
                name.setFill(Color.BLACK);
            }

            invisibleButton.setOnMouseClicked(e -> {
                taskDetail = new TaskDetail(listOfTasks, task);
                stage.setScene(taskDetail.getScene(stage));
            });
            setGraphic(content);
            setStyle("""
                    -fx-background-color: white;
                    -fx-text-fill: black;
                    -fx-padding: 10px;
                                    """);
        }
    }
}

