package com.example.todolistfinalprojectjandos.TaskRelated;

import com.example.todolistfinalprojectjandos.RepeatType;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Task implements Serializable, Comparable<Task> {
    private String name,description;
    private LocalDateTime dateTime;
    private int numberOfDays;
    private RepeatType repeatType;


    public Task(String name, String description, LocalDateTime dateTime, int numberOfDays, RepeatType repeatType) {
        this.name = name;
        this.description = description;
        this.dateTime = dateTime;
        this.numberOfDays = numberOfDays;
        this.repeatType = repeatType;
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
        public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public RepeatType getRepeatType() {
        return repeatType;
    }

    public void setRepeatType(RepeatType repeatType) {
        this.repeatType = repeatType;
    }

    @Override
    public int compareTo(Task other) {
        return this.dateTime.compareTo(other.dateTime);
    }

    @Override
    public String toString() {
        String minute=String.valueOf(dateTime.getMinute()) ;
        if(minute.length()==1){
            minute="0"+minute;
        }
        return  name +" "+ dateTime.getHour()+":"+minute+"   "+dateTime.getDayOfMonth()+". "+ dateTime.getMonthValue()+". "+dateTime.getYear();

    }
    public boolean isOverdue(){
        LocalDateTime currentTime=LocalDateTime.now();
        return getDateTime().isBefore(currentTime);
    }
}
