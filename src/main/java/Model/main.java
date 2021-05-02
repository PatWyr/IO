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

    Board board;
    Game game;
    Button buttonHistoryOfWinners;
    Button buttonChangeBackground;
    Button buttonStartGame;
    Group root;
    private List<String> names = new ArrayList<>();
    private List<String> Order = new ArrayList<>();
//    private List<Integer> Coordinates = List.of(-100,0,-100,0,-100,0,-100,0,-100,0,-100,0,-100,0,-100,0,0,-100,0,-100,0,-100,0,
//            -100,0,-100,0,-100,0,-100,100,0,100,0,100,0,100,0,100,0,100,0,100,0,0,100,0,100,0,100,0,100,0,100,0,100,0,100);
    private List<Integer> Coordinates = List.of(-100,0,-100,0,-100,0,-100,0,-100,0,-100,0,-100,0,-100,0,0,-100,0,-100,0,-100,0,
            -100,0,-100,0,-100,0,-100,100,0,100,0,100,0,100,0,100,0,100,0,100,0,0,100,0,100,0,100,0,100,0,100,0,100,0,100);

    ComboBox<String> comboboxChooseColorOfPawns;

    int NumberOfPlayers = 0;
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

        buttonBuy.setStyle(style2);
        buttonRoll.setStyle(style2);
        buttonNextTurn.setStyle(style2);
        String First;
        String Second;
        String Third;
        String Forth;
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

//        Image image = new Image(new FileInputStream("abc.png"));
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

        imageView.setX(450);
        imageView.setY(100);
        imageView.setFitHeight(800);
        imageView.setFitWidth(800);
        buttonRoll.setLayoutX(700);
        buttonRoll.setLayoutY(920);
        buttonNextTurn.setLayoutX(780);
        buttonNextTurn.setLayoutY(920);


        if(NumberOfPlayers==2) {
            imageView1.setX(1200);
            imageView1.setY(850);

            imageView2.setX(1200);
            imageView2.setY(800);
            root = new Group(imageView,imageView1,imageView2);
            root.getChildren().add(buttonRoll);
            root.getChildren().add(buttonNextTurn);


        }else if(NumberOfPlayers==3){
            imageView1.setX(1200);
            imageView1.setY(850);

            imageView2.setX(1200);
            imageView2.setY(800);

            imageView3.setX(1150);
            imageView3.setY(850);
            root = new Group(imageView,imageView1,imageView2,imageView3);
            root.getChildren().add(buttonRoll);
            root.getChildren().add(buttonNextTurn);


        }else if(NumberOfPlayers==4){
            imageView1.setX(1200);
            imageView1.setY(850);

            imageView2.setX(1200);
            imageView2.setY(800);

            imageView3.setX(1150);
            imageView3.setY(850);

            imageView4.setX(1150);
            imageView4.setY(800);
            root = new Group(imageView,imageView1,imageView2,imageView3,imageView4);
            root.getChildren().add(buttonRoll);
            root.getChildren().add(buttonNextTurn);

        }

        Stage stageGame = new Stage();
        stageGame.setTitle("Monopoly");
        Scene sceneGame = new Scene(root, 1700, 1000);
        stageGame.setScene(sceneGame);
        stageGame.show();

        buttonRoll.setOnAction(event -> Roll(ImageViewList.get(TurnCalculator%NumberOfPlayers)));
//        buttonBuy.setOnAction(event -> );

    }

    public void Roll(ImageView a){
        System.out.println("calcualtor"+TurnCalculator%NumberOfPlayers);
        int position2 = game.getPlayer(TurnCalculator%NumberOfPlayers).getPosition();
        int roll =game.requestForRoll();
        int position = game.getPlayer(TurnCalculator%NumberOfPlayers).getPosition();
        System.out.println(position2);


        move(a,position);
        TurnCalculator++;
    }







    public void move(ImageView a,int roll){
        System.out.println(roll);
        System.out.println(Order.get(TurnCalculator%NumberOfPlayers));
//        for(int x =0; x<roll;x++){
            if(Order.get(TurnCalculator%NumberOfPlayers).equals("RED")){
//                if(Piece1X == 56 ){
//                    Piece1X = 0;
//                    Piece1Y = 1;
//                }
//                 Piece1X += 2;
//                 Piece1Y += 2;
//                 a.setX(a.getX() + Coordinates.get(Piece1X));
//                 a.setY(a.getY() + Coordinates.get(Piece1Y));
                 Piece1X = 2*roll;
                 Piece1Y = 2*roll+1;
                 a.setX(a.getX() + Coordinates.get(Piece1X));
                 a.setY(a.getY() + Coordinates.get(Piece1Y));
            }else if(Order.get(TurnCalculator%NumberOfPlayers).equals("BLUE")){
//                if(Piece2X == 56 ){
//                    Piece2X = 0;
//                    Piece2Y = 1;
//                }
//                 Piece2X += 2;
//                 Piece2Y += 2;
//                 a.setX(a.getX() + Coordinates.get(Piece2X));
//                 a.setY(a.getY() + Coordinates.get(Piece2Y));
                 Piece2X = 2*roll;
                 Piece2Y = 2*roll+1;
                 a.setX(a.getX() + Coordinates.get(Piece2X));
                 a.setY(a.getY() + Coordinates.get(Piece2Y));
            }else if(Order.get(TurnCalculator%NumberOfPlayers).equals("GREEN")){
//                if(Piece3X == 56 ){
//                    Piece3X = 0;
//                    Piece3Y = 1;
//                }
//                 Piece3X += 2;
//                 Piece3Y += 2;
//                 a.setX(a.getX() + Coordinates.get(Piece3X));
//                 a.setY(a.getY() + Coordinates.get(Piece3Y));
                 Piece3X = 2*roll;
                 Piece3Y = 2*roll+1;
                 a.setX(a.getX() + Coordinates.get(Piece3X));
                 a.setY(a.getY() + Coordinates.get(Piece3Y));
            }else if(Order.get(TurnCalculator%NumberOfPlayers).equals("YELLOW")){
//                if(Piece4X == 56 ){
//                    Piece4X = 0;
//                    Piece4Y = 1;
//                }
//                 Piece4X += 2;
//                 Piece4Y += 2;
//                 a.setX(a.getX() + Coordinates.get(Piece4X));
//                 a.setY(a.getY() + Coordinates.get(Piece4Y));
                Piece4X = 2*roll;
                Piece4Y = 2*roll+1;
                a.setX(a.getX() + Coordinates.get(Piece4X));
                a.setY(a.getY() + Coordinates.get(Piece4Y));
            }

        }

//    }

    @Override
    public void handle(ActionEvent event) {

    }
}
