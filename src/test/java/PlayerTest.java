import Model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class PlayerTest {
    private Player player;

    @BeforeEach
    public void prepare(){
        player=new Player("Test");

    }

    @Test
    public void rollTest(){
        int roll = player.rollDice();
        boolean test = false;
        if(roll>=1 && roll <=6){
            test = true;
        }
        assertEquals(true,test);
    }

    @Test
    public void buyFieldTest(){
        //TODO
    }
}
