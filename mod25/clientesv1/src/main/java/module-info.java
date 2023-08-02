module br.ldnovaes.clientesv1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens br.ldnovaes.clientesv1 to javafx.fxml;
    exports br.ldnovaes.clientesv1;

    exports br.ldnovaes.clientesv1.controller;
    opens br.ldnovaes.clientesv1.controller to javafx.fxml;

    exports br.ldnovaes.clientesv1.service;
    opens br.ldnovaes.clientesv1.service to javafx.fxml;

    exports br.ldnovaes.clientesv1.enums;
    opens br.ldnovaes.clientesv1.enums to javafx.fxml;

    exports br.ldnovaes.clientesv1.interfaces;
    opens br.ldnovaes.clientesv1.interfaces to javafx.fxml;

    exports br.ldnovaes.clientesv1.model;
    opens br.ldnovaes.clientesv1.model to javafx.fxml;

    exports br.ldnovaes.clientesv1.utills;
    opens br.ldnovaes.clientesv1.utills to javafx.fxml;
}