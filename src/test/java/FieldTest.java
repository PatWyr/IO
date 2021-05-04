import Model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FieldTest {

    private Board board;
    private Game game;
    private final List<String> names = List.of("1","2","3","4");

    @BeforeEach
    public void prepare(){
       board = new Board();
       game = new Game(true,0,4,names,board);
       board.addGameToFields(game);
    }


    @Test
    public  void fieldConstTest() {
        assertEquals(28,board.getListSize());
        System.out.println(board.getFields().get(0).getName());
        System.out.println(board.getFields().get(3).getName());
        System.out.println(board.getFields().get(27).getName());
        System.out.println(board.getFields().get(3) instanceof SpecialField);
        System.out.println(board.getFields().get(0) instanceof NormalField);
    }

    @Test
    public void actionTest(){
        board.getFields().get(3).fieldAction();


    }
}
