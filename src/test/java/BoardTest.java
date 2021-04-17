import Model.Board;
import Model.Field;
import Model.NormalField;
import Model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.*;
public class BoardTest {

    private Board board;
    private Player player;

    @BeforeEach
    public void prepare(){
      board = new Board();
      player = new Player("Test");
    }


    @Test
    public void createTest(){
        assertEquals(30,board.getListSize());
    }

    @Test
    public void moveTest(){
        player.setPosition(10);
        assertEquals(player.getPosition(),10);
        board.movePlayer(player,5);
        assertEquals(player.getPosition(),15);
        board.movePlayer(player,16);
        assertEquals(player.getPosition(),1);
        assertEquals(player.getMoney(),600);
    }

    @Test
    public void positionTest(){
        player.setPosition(10);
        assertEquals(10,board.getPlayerPosition(player));
    }

    @Test
    public void stunTest(){
        player.setPosition(10);
        board.stunPlayer(2,player);
        assertEquals(2,player.getStunLen());
        assertEquals(true,player.isStun());
    }

    @Test
    public void ownershipTest(){
        NormalField testField;
        testField = (NormalField) board.getOneField(1);
        testField.setOwner(player);
        assertEquals(true,board.checkOwnerShip(testField,player));
    }

}
