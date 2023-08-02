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

}