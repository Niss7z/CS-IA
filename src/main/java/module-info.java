module com.example.cs_ia {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.xerial.sqlitejdbc;
    requires org.kordamp.bootstrapfx.core;
    requires org.kordamp.ikonli.javafx;

    requires java.sql;
    opens com.controllers to javafx.fxml;
    exports com.controllers;
    exports com.controllers.task_manager;
    opens com.controllers.task_manager to javafx.fxml;
    exports com.models;
    opens com.models to javafx.fxml;
}