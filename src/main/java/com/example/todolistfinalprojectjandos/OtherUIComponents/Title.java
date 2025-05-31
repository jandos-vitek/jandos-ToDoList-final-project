package com.example.todolistfinalprojectjandos.OtherUIComponents;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
/**
 * Represents a styled title composed of a blue rectangle background,
 * a black separator line, and a customizable text title.
 */
public class Title {
    private Rectangle blueBox;
    private Rectangle blackLine;
    private Text title;

    /**
     *  Initializes the visual elements of the title component
     */
    public Title() {
        blueBox = new Rectangle(0, 0, 450, 60);
        blueBox.setFill(Color.rgb(0, 110, 255));

        blackLine = new Rectangle(0, 60, 450, 5);
        blackLine.setFill(Color.BLACK);

        title = new Text();
        title.setFill(Color.BLACK);
        title.setFont(Font.font("System", FontWeight.BOLD, 40));

    }

    public Text getTitle() {
        return title;
    }

    public Rectangle getBlueBox() {
        return blueBox;
    }

    public Rectangle getBlackLine() {
        return blackLine;
    }
}
