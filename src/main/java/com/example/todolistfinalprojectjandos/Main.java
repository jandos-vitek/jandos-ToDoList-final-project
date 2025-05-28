package com.example.todolistfinalprojectjandos;

import com.example.todolistfinalprojectjandos.Scenes.HomePage;
import com.example.todolistfinalprojectjandos.TaskRelated.ListOfTasks;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
    ListOfTasks listOfTasks=new ListOfTasks();

    @Override
    public void start(Stage stage) throws IOException {


        listOfTasks.loadTasks();
        stage.setTitle("TO DO LIST");
        stage.setResizable(false);
        stage.setWidth(450);
        stage.setHeight(720);

        HomePage h=new HomePage(listOfTasks);
        stage.setScene(h.getScene(stage));

        Image icon = new Image(getClass().getResource("/logo.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.setScene(h.getScene(stage));
        stage.show();


    }
    public static void main(String[] args) {
        launch();
    }
}