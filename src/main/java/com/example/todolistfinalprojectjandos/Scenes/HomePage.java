package com.example.todolistfinalprojectjandos.Scenes;

import com.example.todolistfinalprojectjandos.Buttons.PlusButton;
import com.example.todolistfinalprojectjandos.TaskRelated.ListOfTasks;
import com.example.todolistfinalprojectjandos.TaskRelated.Task;
import com.example.todolistfinalprojectjandos.TaskRelated.TaskCell;
import com.example.todolistfinalprojectjandos.OtherUIComponents.Title;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HomePage {
    private ListOfTasks listOfTasks;
    private Title title;
    private PlusButton plusButton;

    public Scene getScene(Stage stage) {
        Group root = new Group();
        Scene homeScene = new Scene(root, 450, 720, Color.WHITE);

        title = new Title();
        title.getTitle().setText("TO-DO LIST");
        double x = (450 - title.getTitle().getBoundsInLocal().getWidth()) / 2;
        title.getTitle().setX(x);
        title.getTitle().setY(110);
        root.getChildren().add(title.getTitle());
        root.getChildren().add(title.getBlackLine());
        root.getChildren().add(title.getBlueBox());


        plusButton = new PlusButton(listOfTasks, stage);
        root.getChildren().add(plusButton);

        ListView<Task> taskListView = new ListView<>();
        taskListView.setItems(listOfTasks.getObservableTasks());
        taskListView.setCellFactory(param -> new TaskCell(listOfTasks, stage));

        taskListView.setStyle("""
                -fx-max-height: 400px;
                -fx-min-height: 400px;
                -fx-max-width: 400px;
                -fx-min-width: 400px;
                -fx-border-radius: 5px;
                -fx-font-size: 20px;
                -fx-background-color: transparent;
                -fx-border-color: transparent;
                -fx-text-fill: black;
                                
                """
        );
        taskListView.setFixedCellSize(50);
        taskListView.setLayoutX(25);
        taskListView.setLayoutY(170);

        root.getChildren().add(taskListView);

        Label time = new Label();
        time.setLayoutY(600);
        time.setLayoutX(15);
        time.setStyle("""
                -fx-font-size: 30;
                                    """);
        time.setTextFill(Color.BLACK);

        time.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                    time.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        root.getChildren().add(time);

        Label date = new Label();
        date.setLayoutX(15);
        date.setLayoutY(640);
        date.setTextFill(Color.BLACK);
        date.setStyle("""
                -fx-font-size: 20;
                                    """);

        root.getChildren().add(date);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        date.setText(LocalDate.now().format(dateFormatter));


        Timeline timeline2 = new Timeline(
                new KeyFrame(Duration.seconds(60), e -> {
                    date.setText(LocalDate.now().format(dateFormatter));
                })
        );
        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline2.play();

        return homeScene;
    }

    public HomePage(ListOfTasks listOfTasks) {
        this.listOfTasks = listOfTasks;
    }
}
