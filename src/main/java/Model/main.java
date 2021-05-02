package Model;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.text.Style;

public class main extends Application implements EventHandler<ActionEvent>{
    Stage window;
    Scene scene;

    Button buttonHistoryOfWinners;
    Button buttonChangeBackground;
    Button buttonStartGame;
    Group root;

    ComboBox<String> comboboxChooseColorOfPawns;

    int NumberOfPlayers = 0;


    String style = "-fx-background-color: #a9a9a9;"
            + "-fx-font-size: 38;-fx-border-color: #000000; -fx-border-width: 3px;";
    String style2 = "-fx-background-color: #a9a9a9;"
            + "-fx-font-size: 20;-fx-border-color: #000000; -fx-border-width: 3px;";

    public void main() {
        launch();
    }


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

        buttonChangeBackground.setOnAction(event -> changeBackground(layout));
        buttonHistoryOfWinners.setOnAction(event -> historyOfWinners());
        buttonStartGame.setOnAction(event -> startGame(layout));
    }
    public void historyOfWinners(){
        Stage stageHistoryOfWinners = new Stage();
        stageHistoryOfWinners.setTitle("History");
        Button buttonClose = new Button("Close");
        buttonClose.setStyle(style);

        VBox layoutHistoryOfWinners = new VBox(10);
        layoutHistoryOfWinners.getChildren().addAll(buttonClose);
        layoutHistoryOfWinners.setStyle(("-fx-background-color: grey"));
        Scene sceneHistoryOfWinners = new Scene(layoutHistoryOfWinners, 1200, 600);
        stageHistoryOfWinners.setScene(sceneHistoryOfWinners);
        stageHistoryOfWinners.show();
        buttonClose.setOnAction(event -> {
            stageHistoryOfWinners.close();
        });



    }
    public void changeBackground(VBox layout){
        Stage stageChangeBackground = new Stage();
        stageChangeBackground.setTitle("changeBackground");
        Text info = new Text("Choose color of background");
        Button buttonChangeColor = new Button("Change color");
        ComboBox<String> comboboxChangeColor = new ComboBox<>();
        info.setStyle(style);
        buttonChangeColor.setStyle(style);
        comboboxChangeColor.setStyle(style);
        comboboxChangeColor.getItems().addAll(
                "RED",
                "BLUE",
                "GREEN"

        );
        VBox layoutChangeBackground = new VBox(10);
        layoutChangeBackground.getChildren().addAll(info,comboboxChangeColor,buttonChangeColor);
        layoutChangeBackground.setStyle(("-fx-background-color: grey"));

        Scene sceneChangeBackground = new Scene(layoutChangeBackground, 1200, 600);


        stageChangeBackground.setScene(sceneChangeBackground);
        stageChangeBackground.show();
        buttonChangeColor.setOnAction(event -> {
            if(comboboxChangeColor.getValue().equals("RED")){
                layout.setStyle(("-fx-background-color: Red"));
            }else if(comboboxChangeColor.getValue().equals("BLUE")){
                layout.setStyle(("-fx-background-color: Blue"));
            }else if(comboboxChangeColor.getValue().equals("GREEN")){
                layout.setStyle(("-fx-background-color: Green"));
            }
            stageChangeBackground.close();
        });

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
                System.out.println(textField.getText());
                /////////////// Setujesz!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! kolor ty debilu oraz nazwe pionka nie zrobione!!!!!!!!!!!!!!!!!!!!!
            });

        }
        Button button = new Button("done");
        button.setStyle(style);
        layout.getChildren().addAll(button);
        button.setOnAction(event -> {
            layout.getChildren().clear();
            try {
                window.close();
                game();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
    public void game() throws FileNotFoundException {


        Button buttonRoll = new Button("Roll");
        Button buttonBuy = new Button("Buy");

        buttonBuy.setStyle(style2);
        buttonRoll.setStyle(style2);

        Image image = new Image(new FileInputStream("abc.jpg"));
        Image image1 = new Image(new FileInputStream("BluePawn.png"));
        Image image2 = new Image(new FileInputStream("RedPawn.png"));
        Image image3 = new Image(new FileInputStream("YellowPawn.png"));
        Image image4 = new Image(new FileInputStream("GreenPawn.png"));
        ImageView imageView = new ImageView(image);
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);
        ImageView imageView4 = new ImageView(image4);
        imageView.setX(500);
        imageView.setY(100);
        imageView.setFitHeight(700);
        imageView.setFitWidth(700);
        buttonRoll.setLayoutX(700);
        buttonRoll.setLayoutY(820);


        if(NumberOfPlayers==2) {
            imageView1.setX(1150);
            imageView1.setY(750);

            imageView2.setX(1150);
            imageView2.setY(700);
            root = new Group(imageView,imageView1,imageView2);
            root.getChildren().add(buttonRoll);


        }else if(NumberOfPlayers==3){
            imageView1.setX(1150);
            imageView1.setY(750);

            imageView2.setX(1150);
            imageView2.setY(700);

            imageView3.setX(1100);
            imageView3.setY(750);
            root = new Group(imageView,imageView1,imageView2,imageView3);
            root.getChildren().add(buttonRoll);


        }else if(NumberOfPlayers==4){
            imageView1.setX(1150);
            imageView1.setY(750);

            imageView2.setX(1150);
            imageView2.setY(700);

            imageView3.setX(1100);
            imageView3.setY(750);

            imageView4.setX(1100);
            imageView4.setY(700);
            root = new Group(imageView,imageView1,imageView2,imageView3,imageView4);
            root.getChildren().add(buttonRoll);

        }

        Stage stageGame = new Stage();
        stageGame.setTitle("History");
        Scene sceneGame = new Scene(root, 1700, 900);
        stageGame.setScene(sceneGame);
        stageGame.show();

        buttonRoll.setOnAction(event -> Roll(imageView1,imageView2,imageView3,imageView4));
//        buttonBuy.setOnAction(event -> );

    }

    public void Roll(ImageView a,ImageView b,ImageView c,ImageView d){
        int ax=100;
        int ay=100;

        if(NumberOfPlayers==2) {




        }else if(NumberOfPlayers==3){




        }else if(NumberOfPlayers==4){


        }

    }

    @Override
    public void handle(ActionEvent event) {

    }
}
