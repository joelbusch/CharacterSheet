module com.charactersheet.charactersheet {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.charactersheet.charactersheet to javafx.fxml;
    exports com.charactersheet.charactersheet;
}