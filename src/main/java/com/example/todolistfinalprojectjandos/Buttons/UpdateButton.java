package com.example.todolistfinalprojectjandos.Buttons;

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

public class UpdateButton extends Button {
    private ListOfTasks listOfTasks;
    private Task task;
    private Stage stage;
    private HomePage homePage;
    private Label dateError;
    private Label timeError;
    private Label pastError;
    private Label emptyName;
    private Label emptyDays;

    private TextField name;
    private DatePicker date;
    private TextArea description;
    private TextField time;
    private TextField repeatingDays;
    private AtomicInteger numberOfDays;
    private AtomicBoolean isRepeating;
    private AtomicBoolean isCustom;

    public UpdateButton(Task task, ListOfTasks listOfTasks, Stage stage, Label dateError, Label timeError,
                        Label pastError, Label emptyName, Label emptyDays, TextField name, DatePicker date, TextArea description, TextField time,
                        TextField repeatingDays, AtomicInteger numberOfDays, AtomicBoolean isRepeating, AtomicBoolean isCustom) {
        this.task=task;
        this.listOfTasks = listOfTasks;
        this.stage = stage;
        this.dateError = dateError;
        this.timeError = timeError;
        this.pastError = pastError;
        this.emptyName = emptyName;
        this.emptyDays = emptyDays;
        this.name = name;
        this.date = date;
        this.description = description;
        this.time = time;
        this.repeatingDays = repeatingDays;
        this.numberOfDays = numberOfDays;
        this.isRepeating = isRepeating;
        this.isCustom = isCustom;
        setText("UPDATE");
        setStyle("""            
                -fx-background-color: rgb(0, 110, 255);
                -fx-text-fill: black;
                -fx-font-size: 25px;
                -fx-font-weight: bold;
                -fx-max-height: 50px;
                -fx-min-height: 50px;
                -fx-max-width: 140px;
                -fx-min-width: 140px;              
                -fx-background-radius: 5px;     
                """);
        setLayoutX(260);
        setLayoutY(590);

        setAction();
    }
    public void setAction(){
        setOnAction(e->{
            timeError.setTextFill(Color.TRANSPARENT);
            dateError.setTextFill(Color.TRANSPARENT);
            pastError.setTextFill(Color.TRANSPARENT);
            emptyName.setTextFill(Color.TRANSPARENT);
            emptyDays.setTextFill(Color.TRANSPARENT);

            boolean isTimeValid = validTime(time.getText());
            boolean isNameValid = validName(name.getText());
            boolean isDateValid = validDate(date.getEditor().getText());
            boolean isNumberOfDaysValid=validDays(repeatingDays.getText());

            if (!isTimeValid || !isNameValid || !isDateValid) {
                return;
            }
            boolean isDateInFuture =futureDate();
            if(!isDateInFuture){
                return;
            }
            int days;
            if(isCustom.get()){
                if(!isNumberOfDaysValid){
                    return;
                }
                days=Integer.parseInt(repeatingDays.getText());
            }
            else {
                days=numberOfDays.get();
            }

            task.setName(name.getText());
            task.setDescription(description.getText());
            task.setDateTime(dateAndTime(time.getText(),date.getValue()));
            task.setNumberOfDays(days);
            if(days!=0){
                task.setRepeating(true);
            }

            homePage = new HomePage(listOfTasks);
            stage.setScene(homePage.getScene(stage));




        });
    }
    public boolean validTime(String time){
        boolean validTime=time.matches("(([0]?[0-9])|([1][0-9])|2[0-3]):[0-5][0-9]");
        if(!validTime){
            timeError.setTextFill(Color.RED);
        }
        return validTime;
    }
    public boolean validDate(String date){
        boolean validDate=date.matches("^(?:(?:31/(?:0?[13578]|1[02]))|(?:29|30)/(?:0?[1,3-9]|1[0-2])|(?:0?[1-9]|1\\d|2[0-8])/0?2|(?:0?[1-9]|1\\d|2[0-8])/(?:0?[1-9]|1[0-2]))/(?:19|20)\\d{2}$");
        if(!validDate){
            dateError.setTextFill(Color.RED);
        }
        return validDate;
    }
    public boolean validName(String name){
        boolean validName=!name.trim().isEmpty();
        if(!validName){
            emptyName.setTextFill(Color.RED);
        }
        return validName;
    }
    public boolean validDays(String days){
        boolean validDays=!repeatingDays.getText().trim().isEmpty();
        if(!validDays){
            emptyDays.setTextFill(Color.RED);
        }
        return validDays;
    }
    public boolean futureDate(){
        LocalDateTime currentDateTime=LocalDateTime.now();
        boolean futureDate=dateAndTime(time.getText(),date.getValue()).isAfter(currentDateTime);
        if(!futureDate){
            pastError.setTextFill(Color.RED);
        }
        return futureDate;
    }

    public LocalDateTime dateAndTime(String time, LocalDate date){
        String[] splitTime = time.split(":");
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        int hour = Integer.parseInt(splitTime[0]);
        int minute = Integer.parseInt(splitTime[1]);

        LocalDateTime dateAndTime = LocalDateTime.of(year, month, day, hour, minute);

        return dateAndTime;
    }

}
