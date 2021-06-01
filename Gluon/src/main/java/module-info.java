module programacionii.gluon {
    requires javafx.controls;
    requires javafx.fxml;

    opens programacionii.gluon to javafx.fxml;
    exports programacionii.gluon;
}
