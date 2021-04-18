import Model.Board;
import Model.Game;
import Model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GameTest {
    private Game game;
    private Board board;
    private List<String> names = List.of("1","2","3","4");


    @BeforeEach
    public void prepare(){
        board = new Board();
        game = new Game(true,0,4,names,board);
    }

    @Test
    public void gameCreateTest(){

    }

    @Test
    public void gameSimulation(){
        game.start(0,10);
        assertEquals(10,game.getRound());
        game.setRequestForRoll(true);
        game.start(0,1);
        assertNotEquals(0,game.getPlayer(0).getPosition());
        game.setRequestForBuy(true);
        game.start(0,1);
        assertEquals(game.getPlayer(0),game.getBoard().getOneField(game.getPlayer(0).getPosition()).getOwner());
    }
}
