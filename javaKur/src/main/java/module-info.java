module client.javakur {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens client.javakur to javafx.fxml;
    exports client.javakur;
    exports client.javakur.controllers;
    opens client.javakur.controllers to javafx.fxml;
}