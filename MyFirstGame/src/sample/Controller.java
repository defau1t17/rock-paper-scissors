package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainStage;

    @FXML
    private Button startButton;

    @FXML
    void initialize() throws Exception {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(100), startButton);
        fadeIn.setToValue(0.5);
        FadeTransition fadeOut = new FadeTransition(Duration.millis(100), startButton);
        fadeOut.setToValue(1);

        startButton.setOnMouseEntered(mouseEvent -> {
            fadeIn.playFromStart();
        });
        startButton.setOnMouseExited(mouseEvent -> {
            fadeOut.playFromStart();
        });


        startButton.setOnAction(actionEvent -> {
            startButton.getScene().getWindow().hide();


            FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(getClass().getResource("/sample/GameWindowFXML.fxml"));


            try {
                loader1.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader1.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Камень Ножницы Бумага");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.getIcons().add(new Image(Main.class.getResourceAsStream("Pictures/orig.png")));
            stage.show();


        });


    }
}
