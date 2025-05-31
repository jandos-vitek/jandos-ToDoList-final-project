package com.example.todolistfinalprojectjandos.Buttons;

import com.example.todolistfinalprojectjandos.OtherUIComponents.ErrorMessages;
import com.example.todolistfinalprojectjandos.OtherUIComponents.RepeatingMenu;
import com.example.todolistfinalprojectjandos.OtherUIComponents.TaskMaking;
import com.example.todolistfinalprojectjandos.RepeatType;
import com.example.todolistfinalprojectjandos.TaskRelated.ListOfTasks;
import com.example.todolistfinalprojectjandos.Scenes.HomePage;
import com.example.todolistfinalprojectjandos.TaskRelated.Task;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Custom button that is used for creating tasks
 * It validates the user input before saving the task
 * If the input is wrong it shows the corresponding error message
 */
public class SaveButton extends AbstractSaveButton {
    /**
     * Normal constructor where the action is set
     * @param listOfTasks is the list where all the tasks are added
     * @param stage is the main and only stage, it is there for setting the scene
     * @param taskMaking is a class where are all the things needed for creating a task, except the button
     */
    public SaveButton(ListOfTasks listOfTasks, Stage stage, TaskMaking taskMaking) {
        super(listOfTasks, stage, taskMaking);
        setAction();
        setText("SAVE");
    }

    /**
     * This checks if everything is valid, then it adds new task to the list and returns to the homepage
     */
    public void setAction() {
        setOnAction(e -> {
            if(isEverythingValid()) {
                listOfTasks.addTask(new Task(name, description, dateAndTime(time, date), Integer.parseInt(numberOfDays), repeatType));
                homePage = new HomePage(listOfTasks);
                stage.setScene(homePage.getScene(stage));

            }
        });
    }



}
