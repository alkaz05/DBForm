module com.example.dbform {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.dbform to javafx.fxml;
    exports com.example.dbform;
}