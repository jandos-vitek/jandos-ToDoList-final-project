package com.example.todolistfinalprojectjandos.TaskRelated;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.TreeSet;
/**
 * This class manages the list of tasks using a TreeSet and an ObservableList for UI updates.
 * Provides methods for  adding, removing, and loading tasks.
 */
public class ListOfTasks implements Serializable {
    private TreeSet<Task> tasks = new TreeSet<>();
    private ObservableList<Task> observableTasks = FXCollections.observableArrayList();

    /**
     * adds a new task to the list
     * updates UI
     * saves the list to a file, ensuring the list is complete when loading
     * @param task is the task being added
     */
    public void addTask(Task task) {
        tasks.add(task);
        updateList();
        saveTasks();
    }
    /**
     * removes a  task to the list and updates UI
     * saves the list to a file, ensuring the list is complete when loading
     * @param task is the task being removed
     */
    public void removeTask(Task task) {
        tasks.remove(task);
        updateList();
        saveTasks();
    }

    public ObservableList<Task> getObservableTasks() {
        return observableTasks;
    }

    /**
     * This updates the ObservableList, so it always matches with the TreeSet
     */
    public void updateList() {
        observableTasks.setAll(tasks);
    }

    /**
     * This saves the list to a file
     */
    public void saveTasks() {
        File tasksFile = new File("data/tasks.ser");

        //THIS WAS MADE BY AI
        File parentDir = tasksFile.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }



        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(tasksFile))) {
            out.writeObject(tasks);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * This loads the list from a file
     */
    public void loadTasks() throws IOException {
        File tasksFile=new File("data/tasks.ser");
        if(tasksFile.exists() && tasksFile.length() > 0) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(tasksFile))) {
                tasks = (TreeSet<Task>) in.readObject();
                updateList();
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }



}
