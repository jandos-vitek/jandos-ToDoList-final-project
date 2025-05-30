package com.example.todolistfinalprojectjandos.Scenes;
import com.example.todolistfinalprojectjandos.Buttons.UpdateButton;
import com.example.todolistfinalprojectjandos.OtherUIComponents.TaskMaking;
import com.example.todolistfinalprojectjandos.RepeatType;
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

        taskMaking.getTitle().getTitle().setText(task.getName());

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

        String minute=String.valueOf(taskDateTime.getMinute()) ;
        if(minute.length()==1){
            minute="0"+minute;
        }


        String time=taskDateTime.getHour()+":"+minute;

        LocalDate localDate = taskDateTime.toLocalDate();

        taskMaking.getDate().setValue(localDate);
        root.getChildren().add(taskMaking.getDate());

        taskMaking.getTime().setText(time);
        root.getChildren().add(taskMaking.getTime());



        switch (task.getRepeatType()) {
            case NONE -> taskMaking.getRepeatingMenu().setAction("No repeat", 0, true, RepeatType.NONE);
            case DAILY -> taskMaking.getRepeatingMenu().setAction("Repeat daily", 1, true, RepeatType.DAILY);
            case WEEKLY -> taskMaking.getRepeatingMenu().setAction("Repeat weekly", 7, true, RepeatType.WEEKLY);
            case MONTHLY -> taskMaking.getRepeatingMenu().setAction("Repeat monthly", 30, true, RepeatType.MONTHLY);
            case CUSTOM -> taskMaking.getRepeatingMenu().setAction("Different", task.getNumberOfDays(), false, RepeatType.CUSTOM);
        }

        root.getChildren().add(taskMaking.getRepeatingMenu().getRepeatingLabel());
        root.getChildren().add(taskMaking.getRepeatingMenu().getRepeatingTextField());
        root.getChildren().add(taskMaking.getRepeatingMenu().getRepeatingButton());
        root.getChildren().add(taskMaking.getErrorMessages().getAllMessages());

updateButton=new UpdateButton(task,listOfTasks,stage,taskMaking);

root.getChildren().add(updateButton);

        root.getChildren().add(taskMaking.getBackButton());


        return editingTaskScene;
    }
    public EditingTaskScene(ListOfTasks listOfTasks, Task task) {
        this.listOfTasks = listOfTasks;
        this.task = task;
    }
}
