package GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GUIFunctions {
    Thread thread;


    String style = "-fx-background-color: #a9a9a9;"
            + "-fx-font-size: 38;-fx-border-color: #000000; -fx-border-width: 3px;";

    String style3;

    String style5 = "-fx-background-color: #a9a9a9;"
            + "-fx-font-size: 38;-fx-border-color: #000000; -fx-border-width: 3px;-fx-font: 100px Tahoma;\n" +
            "-fx-fill: white;\n"+
            "    -fx-stroke: black;\n" +
            "    -fx-stroke-width: 3;";



    public void  music() {
         thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileInputStream fileInputStream = new FileInputStream("xd.mp3");
                    Player player = new Player(fileInputStream);
                    player.play();


                } catch (JavaLayerException | FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
    public void musicstop(){
        thread.stop();
    }

    public void changeTurn(Button button,Button button1,Button button2){
        button.setDisable(true);
        button1.setDisable(false);
        button2.setDisable(true);
    }

    public void historyOfWinners(String stylexd) throws FileNotFoundException {
        Text text123 = new Text("History of winners");
        text123.setStyle(style5);
        text123.setX(450);
        text123.setY(80);
        Image imgON = new Image(new FileInputStream("mon.png"));
        ImageView viewON = new ImageView(imgON);
        viewON.setX(0);
        viewON.setY(230);


        Stage stageHistoryOfWinners = new Stage();
        stageHistoryOfWinners.setTitle("History");
        Button buttonClose = new Button("Close");
        buttonClose.setLayoutY(800);
        buttonClose.setLayoutX(1400);


        File myObj = new File("History.txt");
        Scanner myReader = new Scanner(myObj);
        String data="";
        while (myReader.hasNextLine()) {
            data += myReader.nextLine();
            data += "\n";
            System.out.println(data);
        }
        myReader.close();
        Text text = new Text(data);
        text.setY(130);
        text.setX(450);
        text.setStyle(style);
        buttonClose.setStyle(style);

        Pane layoutHistoryOfWinners = new Pane();

        layoutHistoryOfWinners.getChildren().addAll(text123,viewON,text,buttonClose);
        layoutHistoryOfWinners.setStyle(stylexd);

        Scene sceneHistoryOfWinners = new Scene(layoutHistoryOfWinners, 1700, 900);
        stageHistoryOfWinners.setScene(sceneHistoryOfWinners);
        stageHistoryOfWinners.show();
        buttonClose.setOnAction(event -> {
            stageHistoryOfWinners.close();
        });

    }


}
