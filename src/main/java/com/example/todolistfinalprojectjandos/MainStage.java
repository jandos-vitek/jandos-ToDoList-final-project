package com.example.todolistfinalprojectjandos;

import com.example.todolistfinalprojectjandos.Scenes.HomePage;
import com.example.todolistfinalprojectjandos.TaskRelated.ListOfTasks;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainStage {
    ListOfTasks listOfTasks;
    Stage stage;
    public MainStage(Stage stage) throws IOException {
        listOfTasks=new ListOfTasks();
        this.stage=stage;
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

}
