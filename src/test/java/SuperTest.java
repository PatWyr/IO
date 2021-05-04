import Model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;


public class SuperTest {
    private final List<String> names = List.of("1","2","3","4");

    @Test
    public void allGame(){
        Board board = new Board();
        Game game = new Game(true,0,4,names,board);
        board.addGameToFields(game);
        game.requestForRoll();
        game.nextTurn();
        game.requestForRoll();
        game.nextTurn();
        game.requestForRoll();
        game.nextTurn();
        game.requestForRoll();
        game.nextTurn();
        game.requestForRoll();
        if(game.isDostepne()){
            System.out.println("Kupiono");
            game.requestForBuy();
            System.out.println(board.getOneField(game.getPlayer(0).getPosition()).getOwner().toString());
            System.out.println(board.getOneField(game.getPlayer(0).getPosition()).toString());
        }
        game.nextTurn();
        System.out.println(game.getTurn());
        game.requestForRoll();
//        System.out.println(game.getPlayer(0).toString());
//        System.out.println(game.getPlayer(1).toString());
        Judge judge = Judge.getInstance(game,board);
        game.nextTurn();
        game.nextTurn();
        game.getPlayer(3).setMoney(-10);
//        System.out.println(game.getPlayer(3).toString());
        System.out.println("LOST");
//        System.out.println(game.getPlayers().length);
//        System.out.println(game.getPlayer(0).toString());
//        System.out.println(game.getPlayer(1).toString());
//        System.out.println(game.getPlayer(2).toString());
        game.requestForRoll();
//        System.out.println(game.getPlayer(0).toString());
//        System.out.println(game.getPlayer(1).toString());
//        System.out.println(game.getPlayer(2).toString());
        game.nextTurn();
        game.getPlayer(1).setMoney(-20);
//        System.out.println(game.getPlayer(0).toString());
//        System.out.println(game.getPlayer(1).toString());
        game.requestForRoll();
//        System.out.println(game.getPlayer(0).toString());
//        System.out.println(game.getPlayer(1).toString());
        game.getPlayer(0).setECTS(30);
        judge.checkWinner(Arrays.asList(game.getPlayers()));
//        System.out.println(game.getPlayer(0).isLost());
//        System.out.println(game.getPlayer(1).isLost());




    }

}
