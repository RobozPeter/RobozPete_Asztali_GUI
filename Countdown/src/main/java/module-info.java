module hu.petrik.countdown {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens hu.petrik.countdown to javafx.fxml;
    exports hu.petrik.countdown;
}