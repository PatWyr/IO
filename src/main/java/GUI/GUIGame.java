package GUI;
import Model.Board;
import Model.Game;
import Model.Judge;
import Model.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GUIGame {
    GUIFunctions guiFunctions = new GUIFunctions();
    Board board;
    Game game;

    Pane root;
    Text textP11;
    Text textP12;
    Text textP13;
    Text textP14;

    Text textP21;
    Text textP22;
    Text textP23;
    Text textP24;

    Text textP31;
    Text textP32;
    Text textP33;
    Text textP34;

    Text textP41;
    Text textP42;
    Text textP43;
    Text textP44;

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

    boolean music = false;

    private List<String> names = new ArrayList<>();
    private List<String> Order = new ArrayList<>();


    String style = "-fx-background-color: #a9a9a9;"
            + "-fx-font-size: 38;-fx-border-color: #000000; -fx-border-width: 3px;";
    String style2 = "-fx-background-color: #a9a9a9;"
            + "-fx-font-size: 20;-fx-border-color: #000000; -fx-border-width: 3px;";

    String style3 = "-fx-background-color: grey";

    String style4 = "-fx-background-color: #a9a9a9;"
            + "-fx-font-size: 52;-fx-border-color: #000000; -fx-border-width: 5px;";
    private List<Integer> Coordinates = List.of(-100,0,-100,0,-100,0,-100,0,-100,0,-100,0,-100,0,-100,0,0,-100,0,-100,0,-100,0,
            -100,0,-100,0,-100,0,-100,100,0,100,0,100,0,100,0,100,0,100,0,100,0,0,100,0,100,0,100,0,100,0,100,0,100,0,100);



    public void game(int xd,List<String> names1,List<String> order1,String stylexd) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        style3 = stylexd;
        names = names1;
        Order = order1;
        NumberOfPlayers = xd;
        board = new Board();
        game = new Game.Builder().running(true).round(0).playerNo(NumberOfPlayers).board(board).players(names).build();
       // game = new Game(true,0,NumberOfPlayers,names,board);
        System.out.println(names);
        System.out.println(Order);
        board.addGameToFields(game);
        Button buttonRoll = new Button("Roll");
        Button buttonBuy = new Button("Buy");
        Button buttonNextTurn = new Button("Next Turn");
        Button buttonMusic = new Button();
        Image imgON = new Image(new FileInputStream("Volume.png"));
        ImageView viewON = new ImageView(imgON);
        Image imgOFF = new Image(new FileInputStream("NoVolume.png"));
        ImageView viewOFF = new ImageView(imgOFF);

        buttonMusic.setGraphic(viewOFF);
        buttonMusic.setLayoutX(1600);
        buttonMusic.setLayoutY(0);

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
            root = new Pane(imageView,imageView1,imageView2,buttonMusic);
            root.getChildren().add(buttonRoll);
            root.getChildren().add(buttonNextTurn);
            root.getChildren().add(buttonBuy);
            textP11 = new Text("Player : "+names.get(0)+" Color : "+Order.get(0));
            textP12 = new Text(String.valueOf("Money : "+game.getPlayer(0).getMoney()));
            textP13 = new Text(String.valueOf("ECTS : "+game.getPlayer(0).getECTS()));
            textP14 = new Text(String.valueOf(""));

            textP21 = new Text("Player : "+names.get(1)+" Color : "+Order.get(1));
            textP22 = new Text(String.valueOf("Money : "+game.getPlayer(1).getMoney()));
            textP23 = new Text(String.valueOf("ECTS : "+game.getPlayer(1).getECTS()));
            textP24 = new Text(String.valueOf(""));

            textP11.setX(20);
            textP11.setY(100);
            textP12.setX(20);
            textP12.setY(140);
            textP13.setX(20);
            textP13.setY(180);
            textP14.setX(20);
            textP14.setY(220);

            textP21.setX(20);
            textP21.setY(820);
            textP22.setX(20);
            textP22.setY(860);
            textP23.setX(20);
            textP23.setY(900);
            textP24.setX(20);
            textP24.setY(940);
            root.getChildren().addAll(textP11,textP12,textP13,textP14,textP21,textP22,textP23,textP24);
            textP11.setStyle(style2);
            textP12.setStyle(style2);
            textP13.setStyle(style2);
            textP14.setStyle(style2);

            textP21.setStyle(style2);
            textP22.setStyle(style2);
            textP23.setStyle(style2);
            textP24.setStyle(style2);


            root.setStyle(style3);


        }else if(NumberOfPlayers==3){
            imageView1.setX(1200);
            imageView1.setY(850);

            imageView2.setX(1200);
            imageView2.setY(800);

            imageView3.setX(1150);
            imageView3.setY(850);
            root = new Pane(imageView,imageView1,imageView2,imageView3,buttonMusic);
            root.getChildren().add(buttonRoll);
            root.getChildren().add(buttonNextTurn);
            root.getChildren().add(buttonBuy);
            textP11 = new Text("Player : "+names.get(0)+" Color : "+Order.get(0));
            textP12 = new Text(String.valueOf("Money : "+game.getPlayer(0).getMoney()));
            textP13 = new Text(String.valueOf("ECTS : "+game.getPlayer(0).getECTS()));
            textP14 = new Text(String.valueOf(""));

            textP21 = new Text("Player : "+names.get(1)+" Color : "+Order.get(1));
            textP22 = new Text(String.valueOf("Money : "+game.getPlayer(1).getMoney()));
            textP23 = new Text(String.valueOf("ECTS : "+game.getPlayer(1).getECTS()));
            textP24 = new Text(String.valueOf(""));

            textP31 = new Text("Player : "+names.get(2)+" Color : "+Order.get(2));
            textP32 = new Text(String.valueOf("Money : "+game.getPlayer(2).getMoney()));
            textP33 = new Text(String.valueOf("ECTS : "+game.getPlayer(2).getECTS()));
            textP34 = new Text(String.valueOf(""));

            textP11.setX(20);
            textP11.setY(100);
            textP12.setX(20);
            textP12.setY(140);
            textP13.setX(20);
            textP13.setY(180);
            textP14.setX(20);
            textP14.setY(220);

            textP21.setX(20);
            textP21.setY(820);
            textP22.setX(20);
            textP22.setY(860);
            textP23.setX(20);
            textP23.setY(900);
            textP24.setX(20);
            textP24.setY(940);

            textP31.setX(1270);
            textP31.setY(100);
            textP32.setX(1270);
            textP32.setY(140);
            textP33.setX(1270);
            textP33.setY(180);
            textP34.setX(1270);
            textP34.setY(220);
            root.getChildren().addAll(textP11,textP12,textP13,textP14,textP21,textP22,textP23,textP24,textP31,textP32,textP33,textP34);
            textP11.setStyle(style2);
            textP12.setStyle(style2);
            textP13.setStyle(style2);
            textP14.setStyle(style2);

            textP21.setStyle(style2);
            textP22.setStyle(style2);
            textP23.setStyle(style2);
            textP24.setStyle(style2);

            textP31.setStyle(style2);
            textP32.setStyle(style2);
            textP33.setStyle(style2);
            textP34.setStyle(style2);
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
            root = new Pane(imageView,imageView1,imageView2,imageView3,imageView4,buttonMusic);
            root.getChildren().add(buttonRoll);
            root.getChildren().add(buttonNextTurn);
            root.getChildren().add(buttonBuy);
            textP11 = new Text("Player : "+names.get(0)+" Color : "+Order.get(0));
            textP12 = new Text(String.valueOf("Money : "+game.getPlayer(0).getMoney()));
            textP13 = new Text(String.valueOf("ECTS : "+game.getPlayer(0).getECTS()));
            textP14 = new Text(String.valueOf(""));

            textP21 = new Text("Player : "+names.get(1)+" Color : "+Order.get(1));
            textP22 = new Text(String.valueOf("Money : "+game.getPlayer(1).getMoney()));
            textP23 = new Text(String.valueOf("ECTS : "+game.getPlayer(1).getECTS()));
            textP24 = new Text(String.valueOf(""));

            textP31 = new Text("Player : "+names.get(2)+" Color : "+Order.get(2));
            textP32 = new Text(String.valueOf("Money : "+game.getPlayer(2).getMoney()));
            textP33 = new Text(String.valueOf("ECTS : "+game.getPlayer(2).getECTS()));
            textP34 = new Text(String.valueOf(""));

            textP41 = new Text("Player : "+names.get(3)+" Color : "+Order.get(3));
            textP42 = new Text(String.valueOf("Money : "+game.getPlayer(3).getMoney()));
            textP43 = new Text(String.valueOf("ECTS : "+game.getPlayer(3).getECTS()));
            textP44 = new Text(String.valueOf(""));
            textP11.setX(20);
            textP11.setY(100);
            textP12.setX(20);
            textP12.setY(140);
            textP13.setX(20);
            textP13.setY(180);
            textP14.setX(20);
            textP14.setY(220);

            textP21.setX(20);
            textP21.setY(820);
            textP22.setX(20);
            textP22.setY(860);
            textP23.setX(20);
            textP23.setY(900);
            textP24.setX(20);
            textP24.setY(940);

            textP31.setX(1270);
            textP31.setY(100);
            textP32.setX(1270);
            textP32.setY(140);
            textP33.setX(1270);
            textP33.setY(180);
            textP34.setX(1270);
            textP34.setY(220);

            textP41.setX(1270);
            textP41.setY(820);
            textP42.setX(1270);
            textP42.setY(860);
            textP43.setX(1270);
            textP43.setY(900);
            textP44.setX(1270);
            textP44.setY(940);
            root.getChildren().addAll(textP11,textP12,textP13,textP14,textP21,textP22,textP23,textP24,textP31,textP32,textP33,textP34,textP41,textP42,textP43,textP44);
            textP11.setStyle(style2);
            textP12.setStyle(style2);
            textP13.setStyle(style2);
            textP14.setStyle(style2);

            textP21.setStyle(style2);
            textP22.setStyle(style2);
            textP23.setStyle(style2);
            textP24.setStyle(style2);

            textP31.setStyle(style2);
            textP32.setStyle(style2);
            textP33.setStyle(style2);
            textP34.setStyle(style2);

            textP41.setStyle(style2);
            textP42.setStyle(style2);
            textP43.setStyle(style2);
            textP44.setStyle(style2);
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
            guiFunctions.changeTurn(buttonBuy,buttonRoll,buttonNextTurn);


        });
        buttonMusic.setOnAction(event -> {
            if (music){
                buttonMusic.setGraphic(viewOFF);
                guiFunctions.musicstop();
                music=false;

            }else {
                buttonMusic.setGraphic(viewON);
                guiFunctions.music();
                music=true;

            }
        });

    }

    public void buy(Button button){
        game.requestForBuy();
        button.setDisable(true);
        if(FakeNumberOfPlayers==2){

            textP12.setText(String.valueOf("Money : "+game.getPlayer(0).getMoney()));
            textP13.setText(String.valueOf("ECTS : "+game.getPlayer(0).getECTS()));
            textP14.setText(String.valueOf(game.getBoughtFields(game.getPlayer(0))));

            textP22.setText(String.valueOf("Money : "+game.getPlayer(1).getMoney()));
            textP23.setText(String.valueOf("ECTS : "+game.getPlayer(1).getECTS()));
            textP24.setText(String.valueOf(game.getBoughtFields(game.getPlayer(1))));

        }else if(FakeNumberOfPlayers==3){

            textP12.setText(String.valueOf("Money : "+game.getPlayer(0).getMoney()));
            textP13.setText(String.valueOf("ECTS : "+game.getPlayer(0).getECTS()));
            textP14.setText(String.valueOf(game.getBoughtFields(game.getPlayer(0))));

            textP22.setText(String.valueOf("Money : "+game.getPlayer(1).getMoney()));
            textP23.setText(String.valueOf("ECTS : "+game.getPlayer(1).getECTS()));
            textP24.setText(String.valueOf(game.getBoughtFields(game.getPlayer(1))));

            textP32.setText(String.valueOf("Money : "+game.getPlayer(2).getMoney()));
            textP33.setText(String.valueOf("ECTS : "+game.getPlayer(2).getECTS()));
            textP34.setText(String.valueOf(game.getBoughtFields(game.getPlayer(2))));

        }else if(FakeNumberOfPlayers==4){
            textP12.setText(String.valueOf("Money : "+game.getPlayer(0).getMoney()));
            textP13.setText(String.valueOf("ECTS : "+game.getPlayer(0).getECTS()));
            textP14.setText(String.valueOf(game.getBoughtFields(game.getPlayer(0))));

            textP22.setText(String.valueOf("Money : "+game.getPlayer(1).getMoney()));
            textP23.setText(String.valueOf("ECTS : "+game.getPlayer(1).getECTS()));
            textP24.setText(String.valueOf(game.getBoughtFields(game.getPlayer(1))));

            textP32.setText(String.valueOf("Money : "+game.getPlayer(2).getMoney()));
            textP33.setText(String.valueOf("ECTS : "+game.getPlayer(2).getECTS()));
            textP34.setText(String.valueOf(game.getBoughtFields(game.getPlayer(2))));

            textP42.setText(String.valueOf("Money : "+game.getPlayer(3).getMoney()));
            textP43.setText(String.valueOf("ECTS : "+game.getPlayer(3).getECTS()));
            textP44.setText(String.valueOf(game.getBoughtFields(game.getPlayer(3))));

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
            try {
                File f1 = new File("History.txt");
                FileWriter myWriter = new FileWriter(f1.getName(),true);
                BufferedWriter bw = new BufferedWriter(myWriter);
                bw.write("Name : "+names.get((TurnCalculator%NumberOfPlayers)-1)+" Won with ECTS : "+game.getPlayer((TurnCalculator%NumberOfPlayers)-1).getECTS()+"\n" );
                bw.close();
//                myWriter.write("Name : "+names.get((TurnCalculator%NumberOfPlayers)-1)+" Won with ECTS : "+game.getPlayer((TurnCalculator%NumberOfPlayers)-1).getECTS() );
//                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

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
        //game.getPlayer(TurnCalculator%NumberOfPlayers).setECTS(30);
//        game.getPlayer(TurnCalculator%NumberOfPlayers).setMoney(-100000);
       // System.out.println("xdd"+game.getPlayer(TurnCalculator%NumberOfPlayers).getECTS());
        if(judge.checkWinner(Arrays.asList(game.getPlayers()))){
            EndGame(Game);
        }
        if(game.getPlayer(TurnCalculator%NumberOfPlayers).getMoney()<-500){
            game.getPlayer(TurnCalculator%NumberOfPlayers).setECTS(game.getPlayer(TurnCalculator%NumberOfPlayers).getECTS()-10);
            game.getPlayer(TurnCalculator%NumberOfPlayers).setMoney(0);
            Button buttonOmega = new Button("ok");
            buttonOmega.setStyle(style2);
            Image image = new Image(new FileInputStream("kebap.png"));
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


       // System.out.println("ilegraczy : "+game.getPlayersNo());
       // System.out.println("roll : "+roll);
       // System.out.println("przed ruchem : "+position2);
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
        Logger logger = new Logger(game.getPlayer(TurnCalculator%NumberOfPlayers),0);
        TurnCalculator++;
        logger.update();
    }







    public void move(ImageView a,int roll,int position){
      //  System.out.println("pozycja to : "+position);
       // System.out.println("X : "+a.getX());
      //  System.out.println("Y : "+a.getY());
       // System.out.println("Tura : "+TurnCalculator%NumberOfPlayers);

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
       // System.out.println("X : "+a.getX());
       // System.out.println("Y : "+a.getY());
       // System.out.println("---------------------------------------");

    }
}
