module programacionii.mavenproject1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens programacionii.mavenproject1 to javafx.fxml;
    exports programacionii.mavenproject1;
}
