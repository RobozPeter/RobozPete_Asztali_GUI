package hu.petrik.countdown;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelloController {

    @FXML
    private Button startButton;
    @FXML
    private Text CountdownText;
    @FXML
    private TextField datePickker;

    private LocalDateTime dateTime;
    private LocalDateTime now = LocalDateTime.now();
    private Timeline timeline;
    public void initialize() {

    }

    @FXML
public void startCountdown(ActionEvent actionEvent) {
    String input = datePickker.getText();
    try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        dateTime = LocalDateTime.parse(input, formatter);
        System.out.println("Parsed DateTime: " + dateTime);
    } catch (Exception ex) {
        System.out.println("Invalid format. Please use 'yyyy-MM-dd HH:mm:ss'.");
        return;
    }

    if (dateTime == null) {
        System.out.println("DateTime is null.");
        return;
    }

    if (now.isAfter(dateTime)) {
        System.out.println("This is in the past");
        return;
    }

     timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
        long diff = java.time.Duration.between(LocalDateTime.now(), dateTime).getSeconds();
        if (diff <= 0) {
            CountdownText.setText("Time's up!");
            timeline.stop();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Countdown Finished");
            alert.setHeaderText(null);
            alert.setContentText("The countdown has ended!");
            alert.show();
        } else {
            CountdownText.setText(diff + " seconds remaining");
        }
    }));
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();


}

}