package GUI;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;





public class GUIStrart extends Application implements EventHandler<ActionEvent>{
    GUIFunctions guiFunctions = new GUIFunctions();
    Stage window;
    Scene scene;
    Button buttonHistoryOfWinners;
    Button buttonChangeBackground;
    Button buttonStartGame;

    boolean music = false;

    private List<String> names = new ArrayList<>();
    private List<String> Order = new ArrayList<>();

    int NumberOfPlayers = 0;

    String style = "-fx-background-color: #a9a9a9;"
            + "-fx-font-size: 38;-fx-border-color: #000000; -fx-border-width: 3px;";

    String style3 = "-fx-background-color: grey";



    @Override
    public void start(Stage stage) throws Exception {
        buttonChangeBackground = new Button("Change BackGround");
        buttonHistoryOfWinners = new Button("History");
        buttonStartGame = new Button("Start New Game");
        buttonChangeBackground.setStyle(style);
        buttonHistoryOfWinners.setStyle(style);
        buttonStartGame.setStyle(style);

        VBox layout = new VBox(10);
        scene = new Scene(layout,1700, 900);
        window = stage;
        window.setTitle("Monopoly");
        layout.setPadding(new Insets(15, 15, 15, 15));
        layout.getChildren().addAll(buttonChangeBackground,buttonHistoryOfWinners,buttonStartGame);
        layout.setStyle(("-fx-background-color: grey"));
        window.setScene(scene);
        window.show();

        buttonChangeBackground.setOnAction(event -> {
            style3 = guiFunctions.changeBackground(layout);
        });
        buttonHistoryOfWinners.setOnAction(event -> {
            try {
                guiFunctions.historyOfWinners();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        buttonStartGame.setOnAction(event ->startGame(layout));
    }


    public void startGame(VBox layout){

        Button buttonChooseNumberOfPlayers = new Button("Set number of players");
        ComboBox<String> comboboxChooseNumberOfPlayers = new ComboBox<>();
        comboboxChooseNumberOfPlayers.setStyle(style);
        buttonChooseNumberOfPlayers.setStyle(style);
        comboboxChooseNumberOfPlayers.getItems().addAll(
                "2",
                "3",
                "4"
        );
        layout.getChildren().remove(buttonChangeBackground);
        layout.getChildren().remove(buttonStartGame);
        layout.getChildren().remove(buttonHistoryOfWinners);
        layout.getChildren().addAll(comboboxChooseNumberOfPlayers,buttonChooseNumberOfPlayers);

        buttonChooseNumberOfPlayers.setOnAction(event -> {
            if(comboboxChooseNumberOfPlayers.getValue().equals("2")){
                NumberOfPlayers = 2;
            }else if(comboboxChooseNumberOfPlayers.getValue().equals("3")){
                NumberOfPlayers = 3;
            }else if(comboboxChooseNumberOfPlayers.getValue().equals("4")){
                NumberOfPlayers = 4;
            }
            layout.getChildren().remove(comboboxChooseNumberOfPlayers);
            layout.getChildren().remove(buttonChooseNumberOfPlayers);
            ChooseColorOfPawnsAndNameThem(layout);
        });

    }

    public void ChooseColorOfPawnsAndNameThem(VBox layout){

        for(int i =1; i<=NumberOfPlayers; i++){
            ComboBox<String> comboboxChooseColorOfPawn = new ComboBox<>();
            GridPane gridPane = new GridPane();
            String textString = "Write Name of Player : "+i;
            Text text = new Text(textString);
            Text text1 = new Text("Choose Color");
            TextField textField = new TextField();
            Button button = new Button("set");
            comboboxChooseColorOfPawn.getItems().addAll(
                    "RED",
                    "BLUE",
                    "GREEN",
                    "YELLOW"

            );
            text1.setStyle(style);
            comboboxChooseColorOfPawn.setStyle(style);
            text.setStyle(style);
            textField.setStyle(style);
            button.setStyle(style);
            gridPane.add(text,1,i);
            gridPane.add(textField,2,i);
            gridPane.add(text1,3,i);
            gridPane.add(comboboxChooseColorOfPawn,4,i);
            gridPane.add(button,5,i);
            layout.getChildren().addAll(gridPane);
            button.setOnAction(event -> {
                String xd = textField.getText();
                names.add(xd);
                Order.add(comboboxChooseColorOfPawn.getValue());

            });


        }
        Button button = new Button("done");
        button.setStyle(style);
        layout.getChildren().addAll(button);
        button.setOnAction(event -> {
            layout.getChildren().clear();
            try {
                window.close();
                GUIGame guiGame = new GUIGame();
                guiGame.game(NumberOfPlayers,names,Order,style3);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
        });
    }



    @Override
    public void handle(ActionEvent event) {

    }
}
