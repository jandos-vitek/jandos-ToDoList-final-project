package com.example.todolistfinalprojectjandos.Buttons;

import com.example.todolistfinalprojectjandos.OtherUIComponents.TaskMaking;
import com.example.todolistfinalprojectjandos.RepeatType;
import com.example.todolistfinalprojectjandos.Scenes.HomePage;
import com.example.todolistfinalprojectjandos.TaskRelated.ListOfTasks;
import com.example.todolistfinalprojectjandos.TaskRelated.Task;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * Custom button that is used for editing tasks
 * It validates the user input before editing the task
 * If the input is wrong it shows the corresponding error message
 */
public class UpdateButton extends AbstractSaveButton {
    private Task task;
    /**
     * Normal constructor where the action is set
     * @param listOfTasks is the list where all the tasks are added
     * @param stage is the main and only stage, it is there for setting the scene
     * @param taskMaking is a class where are all the things needed for creating a task, except the button
     * @param task is the task user is editing
     */
    public UpdateButton(ListOfTasks listOfTasks, Stage stage, TaskMaking taskMaking, Task task) {
        super(listOfTasks, stage, taskMaking);
        this.task = task;

        setAction();
        setText("UPDATE");
    }
    /**
     * This checks if everything is valid, then it updates the task and returns to the homepage
     */
    public void setAction() {
        setOnAction(e -> {
            if(isEverythingValid()) {
                task.setRepeatType(repeatType);
                task.setDescription(description);
                task.setDateTime(dateAndTime(time,date));
                task.setName(name);
                task.setNumberOfDays(Integer.parseInt(numberOfDays));
                listOfTasks.saveTasks();
                homePage = new HomePage(listOfTasks);
                stage.setScene(homePage.getScene(stage));

            }
        });
    }
}

