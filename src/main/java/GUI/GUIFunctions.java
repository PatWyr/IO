package GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

    String style3 = "-fx-background-color: grey";


    public String changeBackground(VBox layout){
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
        return style3;
    }
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

    public void historyOfWinners() throws FileNotFoundException {
        Stage stageHistoryOfWinners = new Stage();
        stageHistoryOfWinners.setTitle("History");
        Button buttonClose = new Button("Close");
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
        text.setStyle(style);
        buttonClose.setStyle(style);

        VBox layoutHistoryOfWinners = new VBox(10);
        layoutHistoryOfWinners.getChildren().addAll(text,buttonClose);
        layoutHistoryOfWinners.setStyle(("-fx-background-color: grey"));
        Scene sceneHistoryOfWinners = new Scene(layoutHistoryOfWinners, 1200, 600);
        stageHistoryOfWinners.setScene(sceneHistoryOfWinners);
        stageHistoryOfWinners.show();
        buttonClose.setOnAction(event -> {
            stageHistoryOfWinners.close();
        });

    }


}
