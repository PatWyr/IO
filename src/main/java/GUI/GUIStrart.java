package GUI;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.FileInputStream;
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
    Pane root;

    boolean music = false;

    private final List<String> names = new ArrayList<>();
    private final List<String> Order = new ArrayList<>();

    int NumberOfPlayers = 0;

    String style = "-fx-background-color: #a9a9a9;"
            + "-fx-font-size: 38;-fx-border-color: #000000; -fx-border-width: 3px;";

    String style5 = "-fx-background-color: #a9a9a9;"
            + "-fx-font-size: 38;-fx-border-color: #000000; -fx-border-width: 3px;-fx-font: 100px Tahoma;\n" +
            "-fx-fill: white;\n"+
            "    -fx-stroke: black;\n" +
            "    -fx-stroke-width: 3;";
    String style6 = "-fx-background-color: #a9a9a9;"
            + "-fx-font-size: 38;-fx-border-color: #000000; -fx-border-width: 3px;-fx-font: 80px Tahoma;\n" +
            "-fx-fill: white;\n"+
            "    -fx-stroke: black;\n" +
            "    -fx-stroke-width: 3;";
    String style3 = "-fx-background-color: #808080";



    @Override
    public void start(Stage stage) throws Exception {
        buttonChangeBackground = new Button("Change BackGround");
        buttonHistoryOfWinners = new Button("Histo ry");
        buttonStartGame = new Button("Start New Game");
        buttonChangeBackground.setStyle(style);
        buttonHistoryOfWinners.setStyle(style);
        buttonStartGame.setStyle(style);
        Image imgON = new Image(new FileInputStream("mon.png"));
        ImageView viewON = new ImageView(imgON);
        viewON.setX(0);
        viewON.setY(0);
        buttonChangeBackground.setLayoutY(720);
        buttonChangeBackground.setLayoutX(1200);
        buttonHistoryOfWinners.setLayoutY(720);
        buttonHistoryOfWinners.setLayoutX(750);
        buttonStartGame.setLayoutY(720);
        buttonStartGame.setLayoutX(200);

        root = new Pane(viewON,buttonChangeBackground,buttonHistoryOfWinners,buttonStartGame);
        root.setStyle(style3);
        scene = new Scene(root,1700, 900);
        window = stage;
        window.setTitle("Monopoly");


        window.setScene(scene);
        window.show();

        buttonChangeBackground.setOnAction(event -> {
            try {
                style3 = changeBackground(root);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        buttonHistoryOfWinners.setOnAction(event -> {
            try {
                guiFunctions.historyOfWinners(style3);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        buttonStartGame.setOnAction(event -> {
            try {
                startGame(root);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
    }


    public void startGame(Pane layout) throws FileNotFoundException {
        Text text123 = new Text("Choose Number OF Players");
        text123.setStyle(style5);
        text123.setX(280);
        text123.setY(80);

        Button buttonChooseNumberOfPlayers = new Button("Set number of players");
        ComboBox<String> comboboxChooseNumberOfPlayers = new ComboBox<>();
        Image imgON = new Image(new FileInputStream("mon.png"));
        ImageView viewON = new ImageView(imgON);
        viewON.setX(0);
        viewON.setY(220);
        comboboxChooseNumberOfPlayers.setLayoutX(600);
        comboboxChooseNumberOfPlayers.setLayoutY(100);
        buttonChooseNumberOfPlayers.setLayoutX(800);
        buttonChooseNumberOfPlayers.setLayoutY(100);

        comboboxChooseNumberOfPlayers.setStyle(style);
        buttonChooseNumberOfPlayers.setStyle(style);
        comboboxChooseNumberOfPlayers.getItems().addAll(
                "2",
                "3",
                "4"
        );
        layout.getChildren().clear();
        layout.getChildren().addAll(text123,viewON,comboboxChooseNumberOfPlayers,buttonChooseNumberOfPlayers);

        buttonChooseNumberOfPlayers.setOnAction(event -> {
            if(comboboxChooseNumberOfPlayers.getValue().equals("2")){
                NumberOfPlayers = 2;
            }else if(comboboxChooseNumberOfPlayers.getValue().equals("3")){
                NumberOfPlayers = 3;
            }else if(comboboxChooseNumberOfPlayers.getValue().equals("4")){
                NumberOfPlayers = 4;
            }
           layout.getChildren().clear();
            try {
                ChooseColorOfPawnsAndNameThem(layout);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

    }

    public void ChooseColorOfPawnsAndNameThem(Pane layout) throws FileNotFoundException {
        List<String> AlreadyIs = new ArrayList<>();
        Image imgON = new Image(new FileInputStream("mon1.png"));
        ImageView viewON = new ImageView(imgON);
        viewON.setX(640);
        viewON.setY(480);
        int tmp =0;
        Text text2 = new Text("");
        text2.setY(65);
        text2.setX(500);
        text2.setStyle(style6);
        for(int i =1; i<=NumberOfPlayers; i++){
            ComboBox<String> comboboxChooseColorOfPawn = new ComboBox<>();
            GridPane gridPane = new GridPane();
            String textString = "Write Name of Player : "+i;
            Text text = new Text(textString);
            Text text1 = new Text("Choose Color");

            TextField textField = new TextField();
            Button button = new Button("Set");
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
            text1.setY(150+tmp);
            text1.setX(1000);
            text.setX(50);
            text.setY(150+tmp);
            textField.setLayoutX(500);
            textField.setLayoutY(100*i);
            comboboxChooseColorOfPawn.setLayoutX(1300);
            comboboxChooseColorOfPawn.setLayoutY(100*i);
            button.setLayoutX(1580);
            button.setLayoutY(100*i);
            button.setMaxSize(140,100);
            button.setMaxSize(140,100);
            layout.getChildren().addAll(text,text1,textField,button,comboboxChooseColorOfPawn);
            tmp+=100;
            button.setOnAction(event -> {
                boolean check = true;
                for(int x =0; x <AlreadyIs.size(); x++ ){
                    if(comboboxChooseColorOfPawn.getValue().equals(AlreadyIs.get(x))){
                        check=false;
                    }
                }

                if(check&&!comboboxChooseColorOfPawn.getValue().equals("")){
                    AlreadyIs.add(comboboxChooseColorOfPawn.getValue());
                    Image imgOFF = null;
                    try {
                        imgOFF = new Image(new FileInputStream("ok.png"));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    ImageView viewOFF = new ImageView(imgOFF);
                    button.setGraphic(viewOFF);
                    button.setStyle(style3);
                    button.setText("");
                    button.setDisable(true);
                    String xd = textField.getText();
                    names.add(xd);
                    Order.add(comboboxChooseColorOfPawn.getValue());
                    text2.setText("");
                } else {
                    text2.setText("Color Already Used");

                }


            });


        }
        Button button = new Button("Done");
        button.setStyle(style);
        button.setLayoutY(580);
        button.setLayoutX(50);
        layout.getChildren().addAll(button,viewON,text2);
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

    public String changeBackground(Pane layout) throws FileNotFoundException {
        Image imgON = new Image(new FileInputStream("mon.png"));
        ImageView viewON = new ImageView(imgON);
        viewON.setX(0);
        viewON.setY(230);
        Stage stageChangeBackground = new Stage();
        stageChangeBackground.setTitle("changeBackground");

        Text info = new Text("Choose color of background");
        info.setX(200);
        info.setY(100);
        Button buttonChangeColor = new Button("Change color");
        ComboBox<String> comboboxChangeColor = new ComboBox<>();
        comboboxChangeColor.setLayoutX(600);
        comboboxChangeColor.setLayoutY(150);
        buttonChangeColor.setLayoutX(800);
        buttonChangeColor.setLayoutY(150);

        info.setStyle(style5);
        buttonChangeColor.setStyle(style);
        comboboxChangeColor.setStyle(style);
        comboboxChangeColor.getItems().addAll(
                "RED",
                "BLUE",
                "GREEN",
                "GREY"
        );

        Pane layoutChangeBackground = new Pane();

        layoutChangeBackground.getChildren().addAll(viewON,info,comboboxChangeColor,buttonChangeColor);

        layoutChangeBackground.setStyle(style3);




        Scene sceneChangeBackground = new Scene(layoutChangeBackground, 1700, 900);


        stageChangeBackground.setScene(sceneChangeBackground);
        stageChangeBackground.show();
        buttonChangeColor.setOnAction(event -> {
            if(comboboxChangeColor.getValue().equals("RED")){
                layout.setStyle(("-fx-background-color: Red"));
                style3 = "-fx-background-color: Red";
            }else if(comboboxChangeColor.getValue().equals("BLUE")){
                layout.setStyle(("-fx-background-color: Blue"));
                style3 = "-fx-background-color: Blue";
            }else if(comboboxChangeColor.getValue().equals("GREEN")){
                layout.setStyle(("-fx-background-color: Green"));
                style3 = "-fx-background-color: Green";
            }else if(comboboxChangeColor.getValue().equals("GREY")) {
                layout.setStyle(("-fx-background-color: Grey"));
                style3 = "-fx-background-color: grey";
            }
            stageChangeBackground.close();

        });
        return style3;
    }



    @Override
    public void handle(ActionEvent event) {

    }
}
