module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.example to javafx.fxml;
    exports com.example;
    exports com.example.model;
    exports com.example.vista;
    exports com.example.interfaz;
}
