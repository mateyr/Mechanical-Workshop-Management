module programacionii.mechanic_workshop_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens programacionii.mechanic_workshop_system to javafx.fxml;
    exports programacionii.mechanic_workshop_system;
    exports programacionii.mechanic_workshop_system.controller;
}
