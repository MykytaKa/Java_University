module org.example.lab_5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lab_5.view to javafx.fxml;
    exports org.example.lab_5;
    exports org.example.lab_5.view;
}