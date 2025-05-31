package com.example.todolistfinalprojectjandos.TaskRelated;

import com.example.todolistfinalprojectjandos.RepeatType;
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

/**
 * A custom cell for displaying a Task in ListView.
 * It shows the task name, a done button and a clickable area,working like a button that opens the taskDetail,
 */
public class TaskCell extends ListCell<Task> {
    private HBox content;
    private StackPane contentWithButton;
    private Text name;
    private Button done;
    private TaskDetail taskDetail;
    private Task task;

    private ListOfTasks listOfTasks;
    private Stage stage;
    private Region invisibleButton;

    /**
     * The visual elements are created here
     *
     * @param listOfTasks is the list where all the tasks are added
     * @param stage       is the main and only stage, it is there for setting the scene
     */

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
        setActionDone();

        invisibleButton = new Region();
        invisibleButton.setStyle("""
                -fx-background-color: transparent;
                -fx-max-width: 375px;
                                -fx-min-width: 375px;
                                -fx-max-height: 50px;
                                -fx-min-height: 50px;
                                """);

        setActionInvisible();

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

    /**
     * Updates the contents of the cell based on the Task object
     * THIS WAS MADE BY AI (partially)
     * @param task  is the task for this cell.
     * @param empty Whether this cell is empty or not.
     */
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
                name.setFill(Color.rgb(230, 10, 10));
            } else {
                name.setFill(Color.BLACK);
            }

            setGraphic(content);
            setStyle("""
                    -fx-background-color: white;
                    -fx-text-fill: black;
                    -fx-padding: 10px;
                                    """);
        }
    }

    /**
     * This sets the action for the done button
     * If the task is repeating, it will change its DateTime, according to the number of days
     * Else it will remove the task
     */
    public void setActionDone() {
        done.setOnAction(e -> {
            if (task.getNumberOfDays()!=0) {
                LocalDateTime newTime = task.getDateTime().plusDays(task.getNumberOfDays());
                task.setDateTime(newTime);
                listOfTasks.saveTasks();

            }
            else {
                listOfTasks.removeTask(task);
            }
        });
    }

    /**
     * This sets the action for the invisible button
     * it opens TaskDetail
     */
    public void setActionInvisible() {
        invisibleButton.setOnMouseClicked(e -> {
            taskDetail = new TaskDetail(listOfTasks, task);
            stage.setScene(taskDetail.getScene(stage));
        });
    }

}

