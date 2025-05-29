package com.example.todolistfinalprojectjandos;

import com.example.todolistfinalprojectjandos.Scenes.HomePage;
import com.example.todolistfinalprojectjandos.TaskRelated.ListOfTasks;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
    MainStage mainStage;

    @Override
    public void start(Stage stage) throws IOException {

        mainStage = new MainStage(stage);


    }

    public static void main(String[] args) {
        launch();
    }
}