module datastructures {
    requires javafx.controls;
    requires javafx.fxml;

    opens datastructures to javafx.fxml;
    exports datastructures;
}
