package com.example.todolistfinalprojectjandos.TaskRelated;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Task implements Serializable, Comparable<Task> {
    private String name,description;
    private LocalDateTime dateTime;
    private boolean isRepeating;
    private int numberOfDays;


    public Task(String name, String description, LocalDateTime dateTime, boolean isRepeating, int numberOfDays) {
        this.name = name;
        this.description = description;
        this.dateTime = dateTime;
        this.isRepeating = isRepeating;
        this.numberOfDays = numberOfDays;
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

    public boolean isRepeating() {
        return isRepeating;
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

    public void setRepeating(boolean repeating) {
        isRepeating = repeating;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
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
