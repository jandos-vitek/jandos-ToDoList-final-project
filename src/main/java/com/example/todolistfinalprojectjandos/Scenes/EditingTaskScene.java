package com.example.todolistfinalprojectjandos.Scenes;
import com.example.todolistfinalprojectjandos.Buttons.UpdateButton;
import com.example.todolistfinalprojectjandos.OtherUIComponents.TaskMaking;
import com.example.todolistfinalprojectjandos.TaskRelated.ListOfTasks;
import com.example.todolistfinalprojectjandos.TaskRelated.Task;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EditingTaskScene {
    private ListOfTasks listOfTasks;
    private Task task;
    private TaskMaking taskMaking;
    private Group root;
    private Scene editingTaskScene;
    private UpdateButton updateButton;


    public Scene getScene(Stage stage) {
        root = new Group();
        editingTaskScene = new Scene(root, 720, 450, Color.WHITE);
        taskMaking = new TaskMaking(stage, listOfTasks);

        taskMaking.getTitle().getTitle().setText("NEW TASK");

        double x = (450 - taskMaking.getTitle().getTitle().getBoundsInLocal().getWidth()) / 2;
        taskMaking.getTitle().getTitle().setX(x);
        taskMaking.getTitle().getTitle().setY(110);

        root.getChildren().add(taskMaking.getTitle().getTitle());
        root.getChildren().add(taskMaking.getTitle().getBlackLine());
        root.getChildren().add(taskMaking.getTitle().getBlueBox());

        taskMaking.getName().setText(task.getName());
        root.getChildren().add(taskMaking.getName());

        taskMaking.getDescription().setText(task.getDescription());
        root.getChildren().add(taskMaking.getDescription());


        LocalDateTime taskDateTime=task.getDateTime();

        String minute;
        if(taskDateTime.getMinute()==0){
            minute="00";
        }else {
            minute=String.valueOf(taskDateTime.getMinute()) ;
        }


        String time=taskDateTime.getHour()+":"+minute;

        LocalDate localDate = taskDateTime.toLocalDate();

        taskMaking.getDate().setValue(localDate);
        root.getChildren().add(taskMaking.getDate());

        taskMaking.getTime().setText(time);
        root.getChildren().add(taskMaking.getTime());



        switch (task.getNumberOfDays()) {
            case 0 -> taskMaking.getRepeatingMenu().getRepeatingLabel().setText("No repeat");
            case 1 -> taskMaking.getRepeatingMenu().getRepeatingLabel().setText("Daily");
            case 7 -> taskMaking.getRepeatingMenu().getRepeatingLabel().setText("Weekly");
            case 30 -> taskMaking.getRepeatingMenu().getRepeatingLabel().setText("Monthly");
            default -> taskMaking.getRepeatingMenu().getRepeatingLabel().setText("Repeat");
        }

        root.getChildren().add(taskMaking.getRepeatingMenu().getRepeatingLabel());
        root.getChildren().add(taskMaking.getRepeatingMenu().getRepeatingTextField());
        taskMaking.getRepeatingMenu().getRepeatingTextField().setText(String.valueOf(task.getNumberOfDays()));
        root.getChildren().add(taskMaking.getRepeatingMenu().getRepeatingButton());

        root.getChildren().add(taskMaking.getErrorMessages().getAllMessages());

updateButton=new UpdateButton(task,listOfTasks,stage,taskMaking.getErrorMessages().getDateError(), taskMaking.getErrorMessages().getTimeError(),
        taskMaking.getErrorMessages().getPastError(), taskMaking.getErrorMessages().getEmptyName(), taskMaking.getErrorMessages().getEmptyDays(), taskMaking.getName(),
        taskMaking.getDate(),taskMaking.getDescription(),taskMaking.getTime(),taskMaking.getRepeatingMenu().getRepeatingTextField(),
        taskMaking.getRepeatingMenu().getNumberOfDays(), taskMaking.getRepeatingMenu().getIsRepeating(), taskMaking.getRepeatingMenu().getIsCustom());

root.getChildren().add(updateButton);

        root.getChildren().add(taskMaking.getBackButton());


        return editingTaskScene;
    }
    public EditingTaskScene(ListOfTasks listOfTasks, Task task) {
        this.listOfTasks = listOfTasks;
        this.task = task;
    }
}
