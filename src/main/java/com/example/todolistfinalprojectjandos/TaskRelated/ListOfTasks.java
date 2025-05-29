package com.example.todolistfinalprojectjandos.TaskRelated;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.TreeSet;

public class ListOfTasks implements Serializable {
    private TreeSet<Task> tasks = new TreeSet<>();
    private ObservableList<Task> observableTasks = FXCollections.observableArrayList();

    public void addTask(Task task) {
        tasks.add(task);
        updateList();
        saveTasks();
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        updateList();
        saveTasks();
    }

    public ObservableList<Task> getObservableTasks() {
        return observableTasks;
    }

    private void updateList() {
        observableTasks.setAll(tasks);
    }
    public void saveTasks() {
        File tasksFile = new File("data/tasks.ser");

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
