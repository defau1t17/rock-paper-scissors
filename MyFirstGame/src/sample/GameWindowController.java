package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label PCScore;

    @FXML
    private Label UserScore;

    @FXML
    private Button StoneButton;

    @FXML
    private Button ScissorsButton;

    @FXML
    private Button PaperButton;

    @FXML
    private ImageView PCIamge;

    @FXML
    private ImageView UserImage;

    @FXML
    private Button ExitButton;

    @FXML
    private Button PlayAgainButton;

    @FXML
    private Button StartGameButton;

    @FXML
    private Text decisionText;

    private int userValue = -1;
    private int PCValue = (int) (Math.random() * 2);
    private int userScore = 0;
    private int PCSc = 0;

    @FXML
    void initialize() {


        // creation Of Animation
        FadeTransition fadeIn = new FadeTransition(Duration.millis(100), StartGameButton);
        fadeIn.setToValue(0.5);
        FadeTransition fadeOut = new FadeTransition(Duration.millis(100), StartGameButton);
        fadeOut.setToValue(1);

        StartGameButton.setOnMouseEntered(mouseEvent -> {
            fadeIn.playFromStart();
        });
        StartGameButton.setOnMouseExited(mouseEvent -> {
            fadeOut.playFromStart();
        });

        FadeTransition fadeIn1 = new FadeTransition(Duration.millis(100), PlayAgainButton);
        fadeIn1.setToValue(0.5);
        FadeTransition fadeOut1 = new FadeTransition(Duration.millis(100), PlayAgainButton);
        fadeOut1.setToValue(1);
        PlayAgainButton.setOnMouseEntered(mouseEvent -> {
            fadeIn1.playFromStart();
        });
        PlayAgainButton.setOnMouseExited(mouseEvent -> {
            fadeOut1.playFromStart();
        });

        FadeTransition fadeIn2 = new FadeTransition(Duration.millis(100), ExitButton);
        fadeIn2.setToValue(0.5);
        FadeTransition fadeOut2 = new FadeTransition(Duration.millis(100), ExitButton);
        fadeOut2.setToValue(1);
        ExitButton.setOnMouseEntered(mouseEvent -> {
            fadeIn2.playFromStart();
        });
        ExitButton.setOnMouseExited(mouseEvent -> {
            fadeOut2.playFromStart();
        });

        FadeTransition fadeIn3 = new FadeTransition(Duration.millis(100), PaperButton);
        fadeIn3.setToValue(0.5);
        FadeTransition fadeOut3 = new FadeTransition(Duration.millis(100), PaperButton);
        fadeOut3.setToValue(1);
        PaperButton.setOnMouseEntered(mouseEvent -> {
            fadeIn3.playFromStart();
        });
        PaperButton.setOnMouseExited(mouseEvent -> {
            fadeOut3.playFromStart();
        });
        FadeTransition fadeIn4 = new FadeTransition(Duration.millis(100), StoneButton);
        fadeIn4.setToValue(0.5);
        FadeTransition fadeOut4 = new FadeTransition(Duration.millis(100), StoneButton);
        fadeOut4.setToValue(1);
        StoneButton.setOnMouseEntered(mouseEvent -> {
            fadeIn4.playFromStart();
        });
        StoneButton.setOnMouseExited(mouseEvent -> {
            fadeOut4.playFromStart();
        });
        FadeTransition fadeIn5 = new FadeTransition(Duration.millis(100), ScissorsButton);
        fadeIn5.setToValue(0.5);
        FadeTransition fadeOut5 = new FadeTransition(Duration.millis(100), ScissorsButton);
        fadeOut5.setToValue(1);
        ScissorsButton.setOnMouseEntered(mouseEvent -> {
            fadeIn5.playFromStart();
        });
        ScissorsButton.setOnMouseExited(mouseEvent -> {
            fadeOut5.playFromStart();
        });

        UserScore.setText("" + userScore);
        PCScore.setText("" + PCSc);

        RotateTransition rotateUserImage = new RotateTransition(Duration.millis(200), UserImage);
        RotateTransition rotatePCImage = new RotateTransition(Duration.millis(200), PCIamge);

        rotatePCImage.setFromAngle(-21.8);
        rotatePCImage.setByAngle(20);
        rotatePCImage.setCycleCount(6);
        rotatePCImage.setAutoReverse(true);


        rotateUserImage.setFromAngle(21.8);
        rotateUserImage.setByAngle(-20);
        rotateUserImage.setCycleCount(6);
        rotateUserImage.setAutoReverse(true);


        Image userP = new Image(getClass().getResourceAsStream("Pictures/User Paper.png"));
        Image userS = new Image(getClass().getResourceAsStream("Pictures/User Stone.png"));
        Image userSC = new Image(getClass().getResourceAsStream("Pictures/User Scissors.png"));

        Image PCP = new Image(getClass().getResourceAsStream("Pictures/PC Paper.png"));
        Image PCS = new Image(getClass().getResourceAsStream("Pictures/PC Stone.png"));
        Image PCSC = new Image(getClass().getResourceAsStream("Pictures/PC Scissors.png"));

        ExitButton.setOnAction(actionEvent -> {
          ExitButton.getScene().getWindow().hide();

        });
        StoneButton.setOnAction(actionEvent -> {
            userValue = 0;
        });

        PaperButton.setOnAction(actionEvent -> {
            userValue = 2;

        });
        ScissorsButton.setOnAction(actionEvent -> {
            userValue = 1;
        });

        StartGameButton.setOnMouseClicked(actionEvent -> {


            if (userValue < 0) {
                System.out.println("Вы не выбрали параметры");
            } else if (userValue >= 0) {
                rotateUserImage.playFromStart();
                rotatePCImage.playFromStart();
                StoneButton.setVisible(false);
                PaperButton.setVisible(false);
                ScissorsButton.setVisible(false);
                StartGameButton.setVisible(false);
            }

            if (userValue == PCValue) {
                decisionText.setText("Ничья");
            }
            if (userValue == 0 && PCValue == 1) {
                decisionText.setText("Вы выиграли");
                userScore++;
            }
            if (userValue == 1 && PCValue == 0) {
                decisionText.setText("Вы проиграли");
                PCSc++;
            }

            if (userValue == 1 && PCValue == 2) {
                decisionText.setText("Вы выиграли");
                userScore++;
            }

            if (userValue == 2 && PCValue == 1) {
                decisionText.setText("Вы проиграли");
                PCSc++;
            }

            if (userValue == 2 && PCValue == 0) {
                decisionText.setText("Вы выиграли");
                userScore++;
            }
            if (userValue == 0 && PCValue == 2) {
                decisionText.setText("Вы проиграли");
                PCSc++;
            }

            rotateUserImage.setOnFinished(actionEvent1 -> {
                if (userValue == 0) {
                    UserImage.setImage(userS);
                } else if (userValue == 1) {
                    UserImage.setImage(userSC);
                } else if (userValue == 2) {
                    UserImage.setImage(userP);
                }

            });

            rotatePCImage.setOnFinished(actionEvent1 -> {
                if (PCValue == 0) {
                    PCIamge.setImage(PCS);
                } else if (PCValue == 1) {
                    PCIamge.setImage(PCSC);
                } else if (PCValue == 2) {
                    PCIamge.setImage(PCP);
                }

                UserScore.setText("" + userScore);
                PCScore.setText("" + PCSc);

                TimerTask tt = new TimerTask() {
                    @Override
                    public void run() {
                        PCIamge.setOpacity(0);
                        UserImage.setOpacity(0);

                        PlayAgainButton.setVisible(true);
                        decisionText.setVisible(true);
                    }
                };
                Timer timer = new Timer();
                timer.schedule(tt, 1000);

            });
        });
        PlayAgainButton.setOnAction(actionEvent2 -> {
            PCIamge.setImage(PCS);
            UserImage.setImage(userS);
            PCIamge.setOpacity(1);
            UserImage.setOpacity(1);
            StartGameButton.setVisible(true);
            PlayAgainButton.setVisible(false);
            decisionText.setVisible(false);
            decisionText.setText("");
            StoneButton.setVisible(true);
            PaperButton.setVisible(true);
            ScissorsButton.setVisible(true);

            userValue = -1;
            PCValue = (int) (Math.random() * 3);
        });
    }
}
