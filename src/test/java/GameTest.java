import Model.Board;
import Model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GameTest {
    private Game game;
    private Board board;
    private final List<String> names = List.of("1","2","3","4");


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

    }
}
