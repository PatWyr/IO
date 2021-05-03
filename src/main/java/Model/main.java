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
import javafx.scene.effect.ColorInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import javax.swing.text.Style;

public class main extends Application implements EventHandler<ActionEvent>{
    Stage window;
    Scene scene;
    Board board;
    Game game;
    Button buttonHistoryOfWinners;
    Button buttonChangeBackground;
    Button buttonStartGame;
    Pane root;
    Text textP11;
    Text textP12;
    Text textP13;

    Text textP21;
    Text textP22;
    Text textP23;

    Text textP31;
    Text textP32;
    Text textP33;

    Text textP41;
    Text textP42;
    Text textP43;



    private List<String> names = new ArrayList<>();
    private List<String> Order = new ArrayList<>();
    private List<Integer> Coordinates = List.of(-100,0,-100,0,-100,0,-100,0,-100,0,-100,0,-100,0,-100,0,0,-100,0,-100,0,-100,0,
            -100,0,-100,0,-100,0,-100,100,0,100,0,100,0,100,0,100,0,100,0,100,0,0,100,0,100,0,100,0,100,0,100,0,100,0,100);


    int NumberOfPlayers = 0;
    int FakeNumberOfPlayers =0;
    int TurnCalculator = 0;

    int Piece1X=0;
    int Piece1Y=1;

    int Piece2X=0;
    int Piece2Y=1;

    int Piece3X=0;
    int Piece3Y=1;

    int Piece4X=0;
    int Piece4Y=1;


    String style = "-fx-background-color: #a9a9a9;"
            + "-fx-font-size: 38;-fx-border-color: #000000; -fx-border-width: 3px;";
    String style2 = "-fx-background-color: #a9a9a9;"
            + "-fx-font-size: 20;-fx-border-color: #000000; -fx-border-width: 3px;";

    String style3 = "-fx-background-color: grey";

    String style4 = "-fx-background-color: #a9a9a9;"
            + "-fx-font-size: 52;-fx-border-color: #000000; -fx-border-width: 5px;";

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
                style3 = "-fx-background-color: Red";
            }else if(comboboxChangeColor.getValue().equals("BLUE")){
                layout.setStyle(("-fx-background-color: Blue"));
                style3 = "-fx-background-color: Blue";
            }else if(comboboxChangeColor.getValue().equals("GREEN")){
                layout.setStyle(("-fx-background-color: Green"));
                style3 = "-fx-background-color: Green";
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
                game();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
    public void game() throws FileNotFoundException {

        board = new Board();
        game = new Game(true,0,NumberOfPlayers,names,board);
        System.out.println(names);
        System.out.println(Order);
        board.addGameToFields(game);
        Button buttonRoll = new Button("Roll");
        Button buttonBuy = new Button("Buy");
        Button buttonNextTurn = new Button("Next Turn");

        Text roll = new Text();
        Text PlayerTurn = new Text();
        roll.setX(1000);
        roll.setY(50);
        PlayerTurn.setX(600);
        PlayerTurn.setY(50);
        roll.setStyle(style);
        PlayerTurn.setStyle(style);

        buttonBuy.setStyle(style2);
        buttonRoll.setStyle(style2);
        buttonNextTurn.setStyle(style2);
        List<FileInputStream> InputStream = new ArrayList<>();
        List<ImageView> ImageViewList = new ArrayList<>();

        for(int x =0; x < NumberOfPlayers;x++){
            if(Order.get(x).equals("RED")){
                InputStream.add(new FileInputStream("RedPawn.png"));
            }else if(Order.get(x).equals("BLUE")){
                InputStream.add(new FileInputStream("BluePawn.png"));
            }else if(Order.get(x).equals("GREEN")){
                InputStream.add(new FileInputStream("GreenPawn.png"));
            }else if(Order.get(x).equals("YELLOW")){
                InputStream.add(new FileInputStream("YellowPawn.png"));
            }
        }
        if(NumberOfPlayers==2){
            InputStream.add(new FileInputStream("YellowPawn.png"));
            InputStream.add(new FileInputStream("YellowPawn.png"));
        }
        if(NumberOfPlayers==3){
            InputStream.add(new FileInputStream("YellowPawn.png"));
        }

        System.out.println(InputStream);
        Image image = new Image(new FileInputStream("Plansza800x800.png"));
        Image image1 = new Image(InputStream.get(0));
        Image image2 = new Image(InputStream.get(1));
        Image image3 = new Image(InputStream.get(2));
        Image image4 = new Image(InputStream.get(3));
        ImageView imageView = new ImageView(image);
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);
        ImageView imageView4 = new ImageView(image4);

        imageView.setX(450);
        imageView.setY(100);
        imageView.setFitHeight(800);
        imageView.setFitWidth(800);
        buttonRoll.setLayoutX(700);
        buttonRoll.setLayoutY(920);
        buttonNextTurn.setLayoutX(780);
        buttonNextTurn.setLayoutY(920);
        buttonBuy.setLayoutX(980);
        buttonBuy.setLayoutY(920);
        buttonBuy.setDisable(true);
        FakeNumberOfPlayers = NumberOfPlayers;


        if(NumberOfPlayers==2){
            ImageViewList.add(imageView1);
            ImageViewList.add(imageView2);

        }else if(NumberOfPlayers==3){
            ImageViewList.add(imageView1);
            ImageViewList.add(imageView2);
            ImageViewList.add(imageView3);
        }else if(NumberOfPlayers==4){
            ImageViewList.add(imageView1);
            ImageViewList.add(imageView2);
            ImageViewList.add(imageView3);
            ImageViewList.add(imageView4);
        }

        if(NumberOfPlayers==2) {
            imageView1.setX(1200);
            imageView1.setY(850);

            imageView2.setX(1200);
            imageView2.setY(800);
            root = new Pane(imageView,imageView1,imageView2);
            root.getChildren().add(buttonRoll);
            root.getChildren().add(buttonNextTurn);
            root.getChildren().add(buttonBuy);
            textP11 = new Text("Player : "+names.get(0)+" Color : "+Order.get(0));
            textP12 = new Text(String.valueOf("Money : "+game.getPlayer(0).getMoney()));
            textP13 = new Text(String.valueOf("ECTS : "+game.getPlayer(0).getECTS()));

            textP21 = new Text("Player : "+names.get(1)+" Color : "+Order.get(1));
            textP22 = new Text(String.valueOf("Money : "+game.getPlayer(1).getMoney()));
            textP23 = new Text(String.valueOf("ECTS : "+game.getPlayer(1).getECTS()));

            textP11.setX(20);
            textP11.setY(100);
            textP12.setX(20);
            textP12.setY(140);
            textP13.setX(20);
            textP13.setY(180);

            textP21.setX(20);
            textP21.setY(820);
            textP22.setX(20);
            textP22.setY(860);
            textP23.setX(20);
            textP23.setY(900);
            root.getChildren().addAll(textP11,textP12,textP13,textP21,textP22,textP23);
            textP11.setStyle(style2);
            textP12.setStyle(style2);
            textP13.setStyle(style2);

            textP21.setStyle(style2);
            textP22.setStyle(style2);
            textP23.setStyle(style2);
            root.setStyle(style3);


        }else if(NumberOfPlayers==3){
            imageView1.setX(1200);
            imageView1.setY(850);

            imageView2.setX(1200);
            imageView2.setY(800);

            imageView3.setX(1150);
            imageView3.setY(850);
            root = new Pane(imageView,imageView1,imageView2,imageView3);
            root.getChildren().add(buttonRoll);
            root.getChildren().add(buttonNextTurn);
            root.getChildren().add(buttonBuy);
            textP11 = new Text("Player : "+names.get(0)+" Color : "+Order.get(0));
            textP12 = new Text(String.valueOf("Money : "+game.getPlayer(0).getMoney()));
            textP13 = new Text(String.valueOf("ECTS : "+game.getPlayer(0).getECTS()));

            textP21 = new Text("Player : "+names.get(1)+" Color : "+Order.get(1));
            textP22 = new Text(String.valueOf("Money : "+game.getPlayer(1).getMoney()));
            textP23 = new Text(String.valueOf("ECTS : "+game.getPlayer(1).getECTS()));

            textP31 = new Text("Player : "+names.get(2)+" Color : "+Order.get(2));
            textP32 = new Text(String.valueOf("Money : "+game.getPlayer(2).getMoney()));
            textP33 = new Text(String.valueOf("ECTS : "+game.getPlayer(2).getECTS()));

            textP11.setX(20);
            textP11.setY(100);
            textP12.setX(20);
            textP12.setY(140);
            textP13.setX(20);
            textP13.setY(180);

            textP21.setX(20);
            textP21.setY(820);
            textP22.setX(20);
            textP22.setY(860);
            textP23.setX(20);
            textP23.setY(900);

            textP31.setX(1270);
            textP31.setY(100);
            textP32.setX(1270);
            textP32.setY(140);
            textP33.setX(1270);
            textP33.setY(180);
            root.getChildren().addAll(textP11,textP12,textP13,textP21,textP22,textP23,textP31,textP32,textP33);
            textP11.setStyle(style2);
            textP12.setStyle(style2);
            textP13.setStyle(style2);

            textP21.setStyle(style2);
            textP22.setStyle(style2);
            textP23.setStyle(style2);

            textP31.setStyle(style2);
            textP32.setStyle(style2);
            textP33.setStyle(style2);
            root.setStyle(style3);

        }else if(NumberOfPlayers==4){
            imageView1.setX(1200);
            imageView1.setY(850);

            imageView2.setX(1200);
            imageView2.setY(800);

            imageView3.setX(1150);
            imageView3.setY(850);

            imageView4.setX(1150);
            imageView4.setY(800);
            root = new Pane(imageView,imageView1,imageView2,imageView3,imageView4);
            root.getChildren().add(buttonRoll);
            root.getChildren().add(buttonNextTurn);
            root.getChildren().add(buttonBuy);
            textP11 = new Text("Player : "+names.get(0)+" Color : "+Order.get(0));
            textP12 = new Text(String.valueOf("Money : "+game.getPlayer(0).getMoney()));
            textP13 = new Text(String.valueOf("ECTS : "+game.getPlayer(0).getECTS()));

            textP21 = new Text("Player : "+names.get(1)+" Color : "+Order.get(1));
            textP22 = new Text(String.valueOf("Money : "+game.getPlayer(1).getMoney()));
            textP23 = new Text(String.valueOf("ECTS : "+game.getPlayer(1).getECTS()));

            textP31 = new Text("Player : "+names.get(2)+" Color : "+Order.get(2));
            textP32 = new Text(String.valueOf("Money : "+game.getPlayer(2).getMoney()));
            textP33 = new Text(String.valueOf("ECTS : "+game.getPlayer(2).getECTS()));

            textP41 = new Text("Player : "+names.get(3)+" Color : "+Order.get(3));
            textP42 = new Text(String.valueOf("Money : "+game.getPlayer(3).getMoney()));
            textP43 = new Text(String.valueOf("ECTS : "+game.getPlayer(3).getECTS()));
            textP11.setX(20);
            textP11.setY(100);
            textP12.setX(20);
            textP12.setY(140);
            textP13.setX(20);
            textP13.setY(180);

            textP21.setX(20);
            textP21.setY(820);
            textP22.setX(20);
            textP22.setY(860);
            textP23.setX(20);
            textP23.setY(900);

            textP31.setX(1270);
            textP31.setY(100);
            textP32.setX(1270);
            textP32.setY(140);
            textP33.setX(1270);
            textP33.setY(180);

            textP41.setX(1270);
            textP41.setY(820);
            textP42.setX(1270);
            textP42.setY(860);
            textP43.setX(1270);
            textP43.setY(900);
            root.getChildren().addAll(textP11,textP12,textP13,textP21,textP22,textP23,textP31,textP32,textP33,textP41,textP42,textP43);
            textP11.setStyle(style2);
            textP12.setStyle(style2);
            textP13.setStyle(style2);

            textP21.setStyle(style2);
            textP22.setStyle(style2);
            textP23.setStyle(style2);

            textP31.setStyle(style2);
            textP32.setStyle(style2);
            textP33.setStyle(style2);

            textP41.setStyle(style2);
            textP42.setStyle(style2);
            textP43.setStyle(style2);
            root.setStyle(style3);

        }
        buttonNextTurn.setDisable(true);
        root.getChildren().add(PlayerTurn);
        root.getChildren().add(roll);

        Stage stageGame = new Stage();
        stageGame.setTitle("Monopoly");
        Scene sceneGame = new Scene(root, 1700, 1000);
        stageGame.setScene(sceneGame);
        stageGame.show();

        buttonRoll.setOnAction(event -> {
            try {
                Roll(ImageViewList.get(TurnCalculator%NumberOfPlayers),buttonBuy,buttonRoll,buttonNextTurn,roll,PlayerTurn,stageGame,ImageViewList);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        buttonBuy.setOnAction(event -> buy(buttonBuy));
        buttonNextTurn.setOnAction(event -> {
            game.nextTurn();
            changeTurn(buttonBuy,buttonRoll,buttonNextTurn);

        });

    }
    public void changeTurn(Button button,Button button1,Button button2){
        button.setDisable(true);
        button1.setDisable(false);
        button2.setDisable(true);
    }
    public void buy(Button button){
        game.requestForBuy();
        button.setDisable(true);
        if(FakeNumberOfPlayers==2){
            textP12.setText(String.valueOf("Money : "+game.getPlayer(0).getMoney()));
            textP13.setText(String.valueOf("ECTS : "+game.getPlayer(0).getECTS()));

            textP22.setText(String.valueOf("Money : "+game.getPlayer(1).getMoney()));
            textP23.setText(String.valueOf("ECTS : "+game.getPlayer(1).getECTS()));


        }else if(FakeNumberOfPlayers==3){
            textP12.setText(String.valueOf("Money : "+game.getPlayer(0).getMoney()));
            textP13.setText(String.valueOf("ECTS : "+game.getPlayer(0).getECTS()));

            textP22.setText(String.valueOf("Money : "+game.getPlayer(1).getMoney()));
            textP23.setText(String.valueOf("ECTS : "+game.getPlayer(1).getECTS()));

            textP32.setText(String.valueOf("Money : "+game.getPlayer(2).getMoney()));
            textP33.setText(String.valueOf("ECTS : "+game.getPlayer(2).getECTS()));

        }else if(FakeNumberOfPlayers==4){
            textP12.setText(String.valueOf("Money : "+game.getPlayer(0).getMoney()));
            textP13.setText(String.valueOf("ECTS : "+game.getPlayer(0).getECTS()));

            textP22.setText(String.valueOf("Money : "+game.getPlayer(1).getMoney()));
            textP23.setText(String.valueOf("ECTS : "+game.getPlayer(1).getECTS()));

            textP32.setText(String.valueOf("Money : "+game.getPlayer(2).getMoney()));
            textP33.setText(String.valueOf("ECTS : "+game.getPlayer(2).getECTS()));

            textP42.setText(String.valueOf("Money : "+game.getPlayer(3).getMoney()));
            textP43.setText(String.valueOf("ECTS : "+game.getPlayer(3).getECTS()));

        }

    }

    public void EndGame(Stage stage ){
        stage.close();
        Button buttonOmega2 = new Button("END");
        Button buttonOmega3 = new Button("Save to history");
        buttonOmega2.setStyle(style2);
        buttonOmega3.setStyle(style2);
        buttonOmega2.setLayoutX(150);
        buttonOmega2.setLayoutY(350);
        buttonOmega3.setLayoutX(250);
        buttonOmega3.setLayoutY(350);
        Text text = new Text("The Winner is  : "+names.get(TurnCalculator%NumberOfPlayers)+ "!!!!");
        text.setStyle(style);
        text.setX(50);
        text.setY(100);
        Pane pane = new Pane(text,buttonOmega2,buttonOmega3);
        pane.setStyle(style3);
        Stage stageCard = new Stage();
        stageCard.initStyle(StageStyle.UNDECORATED);
        stageCard.setTitle("Monopoly");
        Scene sceneCard = new Scene(pane, 500, 500);
        stageCard.setScene(sceneCard);
        stageCard.show();
        buttonOmega2.setOnAction(event -> {
            stageCard.close();
        });
        buttonOmega3.setOnAction(event -> {

        });

    }

    public void Roll(ImageView a,Button button,Button button1,Button button2,Text roll2,Text player,Stage Game,List<ImageView> ImageViewList) throws FileNotFoundException {
        if(NumberOfPlayers<2){
            EndGame(Game);
        }

        Judge judge = Judge.getInstance(game,board);
        game.getPlayer(TurnCalculator%NumberOfPlayers).setCurrentCard(null);
        int position2 = game.getPlayer(TurnCalculator%NumberOfPlayers).getPosition();
        int roll =game.requestForRoll();
        int position = game.getPlayer(TurnCalculator%NumberOfPlayers).getPosition();
        if(judge.checkWinner(Arrays.asList(game.getPlayers()))){
            EndGame(Game);
        }
        if(game.getPlayer(TurnCalculator%NumberOfPlayers).getMoney()<-1000){
            game.getPlayer(TurnCalculator%NumberOfPlayers).setECTS(game.getPlayer(TurnCalculator%NumberOfPlayers).getECTS()-10);
        }


        if(game.getPlayer(TurnCalculator%NumberOfPlayers).getCurrentCard()!= null){

            Button buttonOmega = new Button("ok");
            buttonOmega.setStyle(style2);
            Image image = new Image(new FileInputStream(game.getPlayer(TurnCalculator%NumberOfPlayers).getCurrentCard().getCardUrl()));
            ImageView imageView4 = new ImageView(image);
            imageView4.setX(0);
            imageView4.setY(0);
            buttonOmega.setLayoutX(420);
            buttonOmega.setLayoutY(600);
            Pane pane = new Pane(imageView4,buttonOmega);
            pane.setStyle(style3);
            Stage stageCard = new Stage();
            stageCard.initStyle(StageStyle.UNDECORATED);
            stageCard.setTitle("Monopoly");
            Scene sceneCard = new Scene(pane, 842, 700);
            stageCard.setScene(sceneCard);
            stageCard.show();
            buttonOmega.setOnAction(event -> {
                stageCard.close();
            });
        }


        System.out.println("ilegraczy : "+game.getPlayersNo());
        System.out.println("roll : "+roll);
        System.out.println("przed ruchem : "+position2);
        if(position-position2<-3){
            move(a,position-position2,0);
            move(a,position,position);
        } else {
            move(a,position-position2,position);
        }
        if(game.isDostepne()){
            button.setDisable(false);
        }
        button1.setDisable(true);
        button2.setDisable(false);
        roll2.setText(" Rolled : "+String.valueOf(roll));
        player.setText("Player : "+names.get(TurnCalculator%NumberOfPlayers));

        if(FakeNumberOfPlayers==2){
            textP12.setText(String.valueOf("Money : "+game.getPlayer(0).getMoney()));
            textP13.setText(String.valueOf("ECTS : "+game.getPlayer(0).getECTS()));

            textP22.setText(String.valueOf("Money : "+game.getPlayer(1).getMoney()));
            textP23.setText(String.valueOf("ECTS : "+game.getPlayer(1).getECTS()));


        }else if(FakeNumberOfPlayers==3){
            textP12.setText(String.valueOf("Money : "+game.getPlayer(0).getMoney()));
            textP13.setText(String.valueOf("ECTS : "+game.getPlayer(0).getECTS()));

            textP22.setText(String.valueOf("Money : "+game.getPlayer(1).getMoney()));
            textP23.setText(String.valueOf("ECTS : "+game.getPlayer(1).getECTS()));

            textP32.setText(String.valueOf("Money : "+game.getPlayer(2).getMoney()));
            textP33.setText(String.valueOf("ECTS : "+game.getPlayer(2).getECTS()));

        }else if(FakeNumberOfPlayers==4){
            textP12.setText(String.valueOf("Money : "+game.getPlayer(0).getMoney()));
            textP13.setText(String.valueOf("ECTS : "+game.getPlayer(0).getECTS()));

            textP22.setText(String.valueOf("Money : "+game.getPlayer(1).getMoney()));
            textP23.setText(String.valueOf("ECTS : "+game.getPlayer(1).getECTS()));

            textP32.setText(String.valueOf("Money : "+game.getPlayer(2).getMoney()));
            textP33.setText(String.valueOf("ECTS : "+game.getPlayer(2).getECTS()));

            textP42.setText(String.valueOf("Money : "+game.getPlayer(3).getMoney()));
            textP43.setText(String.valueOf("ECTS : "+game.getPlayer(3).getECTS()));

        }
        TurnCalculator++;
    }







    public void move(ImageView a,int roll,int position){
        System.out.println("pozycja to : "+position);
        System.out.println("X : "+a.getX());
        System.out.println("Y : "+a.getY());
        System.out.println("Tura : "+TurnCalculator%NumberOfPlayers);

        if(position==0){
            if(TurnCalculator%NumberOfPlayers==0) {
                Piece1X = 0;
                Piece1Y = 1;
                a.setX(1200);
                a.setY(850);
                return;
            }else if(TurnCalculator%NumberOfPlayers==1){
                Piece2X = 0;
                Piece2Y = 1;
                a.setX(1200);
                a.setY(800);
                return;
            }else if(TurnCalculator%NumberOfPlayers==2){
                Piece3X = 0;
                Piece3Y = 1;
                a.setX(1150);
                a.setY(850);
                return;
            } else if(TurnCalculator%NumberOfPlayers==3){
                Piece4X = 0;
                Piece4Y = 1;
                a.setX(1150);
                a.setY(800);
                return;
            }

        }
        if(roll>=0 && position !=0) {
            for (int x = 0; x < roll; x++) {
                if (TurnCalculator%NumberOfPlayers==0) {
                    if (Piece1X == 56) {
                        Piece1X = 0;
                        Piece1Y = 1;
                    }
                    Piece1X += 2;
                    Piece1Y += 2;
                    a.setX(a.getX() + Coordinates.get(Piece1X));
                    a.setY(a.getY() + Coordinates.get(Piece1Y));

                } else if (TurnCalculator%NumberOfPlayers==1) {
                    if (Piece2X >= 56) {
                        Piece2X = 0;
                        Piece2Y = 1;
                    }
                    Piece2X += 2;
                    Piece2Y += 2;
                    a.setX(a.getX() + Coordinates.get(Piece2X));
                    a.setY(a.getY() + Coordinates.get(Piece2Y));

                } else if (TurnCalculator%NumberOfPlayers==2) {
                    if (Piece3X >= 56) {
                        Piece3X = 0;
                        Piece3Y = 1;
                    }
                    Piece3X += 2;
                    Piece3Y += 2;
                    a.setX(a.getX() + Coordinates.get(Piece3X));
                    a.setY(a.getY() + Coordinates.get(Piece3Y));

                } else if (TurnCalculator%NumberOfPlayers==3) {
                    if (Piece4X >= 56) {
                        Piece4X = 0;
                        Piece4Y = 1;
                    }
                    Piece4X += 2;
                    Piece4Y += 2;
                    a.setX(a.getX() + Coordinates.get(Piece4X));
                    a.setY(a.getY() + Coordinates.get(Piece4Y));

                }

            }
        }else {
            for (int x = 0; x > roll; x--) {
                if (TurnCalculator%NumberOfPlayers==0) {
                    Piece1X -= 2;
                    Piece1Y -= 2;
                    if (Piece1X < 0) {
                        Piece1X = 0;
                        Piece1Y = 1;
                    }
                    a.setX(a.getX() - Coordinates.get(Piece1X));
                    a.setY(a.getY() - Coordinates.get(Piece1Y));

                } else if (TurnCalculator%NumberOfPlayers==1) {
                    Piece2X -= 2;
                    Piece2Y -= 2;
                    if(Piece2X < 0){
                        Piece2X = 0;
                        Piece2Y = 1;
                    }
                    a.setX(a.getX() - Coordinates.get(Piece2X));
                    a.setY(a.getY() - Coordinates.get(Piece2Y));

                } else if (TurnCalculator%NumberOfPlayers==2) {
                    Piece3X -= 2;
                    Piece3Y -= 2;
                    if (Piece3X < 0) {
                        Piece3X = 0;
                        Piece3Y = 1;
                    }
                    a.setX(a.getX() - Coordinates.get(Piece3X));
                    a.setY(a.getY() - Coordinates.get(Piece3Y));

                } else if (TurnCalculator%NumberOfPlayers==3) {
                    Piece4X -= 2;
                    Piece4Y -= 2;
                    if (Piece4X < 0) {
                        Piece4X = 0;
                        Piece4Y = 1;
                    }
                    a.setX(a.getX() - Coordinates.get(Piece4X));
                    a.setY(a.getY() - Coordinates.get(Piece4Y));

                }

            }
        }
        System.out.println("X : "+a.getX());
        System.out.println("Y : "+a.getY());
        System.out.println("---------------------------------------");

    }

    @Override
    public void handle(ActionEvent event) {

    }
}
