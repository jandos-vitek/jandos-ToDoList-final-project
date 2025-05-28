module com.example.todolistfinalprojectjandos {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.todolistfinalprojectjandos to javafx.fxml;
    exports com.example.todolistfinalprojectjandos;
    exports com.example.todolistfinalprojectjandos.Scenes;
    opens com.example.todolistfinalprojectjandos.Scenes to javafx.fxml;
    exports com.example.todolistfinalprojectjandos.Buttons;
    opens com.example.todolistfinalprojectjandos.Buttons to javafx.fxml;
    exports com.example.todolistfinalprojectjandos.OtherUIComponents;
    opens com.example.todolistfinalprojectjandos.OtherUIComponents to javafx.fxml;
    exports com.example.todolistfinalprojectjandos.TaskRelated;
    opens com.example.todolistfinalprojectjandos.TaskRelated to javafx.fxml;
}