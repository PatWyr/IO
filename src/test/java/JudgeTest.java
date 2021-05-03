import Model.Board;
import Model.Game;
import Model.Judge;
import Model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class JudgeTest {
    private Game game;
    private Judge judge;
    private Board board;
    List<String> names = List.of("1","2","3","4");

    @BeforeEach
    public void prepare(){
        game = new Game(true,0,4,names);
        board = new Board();
        judge = Judge.getInstance(game,board);
    }

    @Test
    public void winnerTest(){
      boolean test = judge.checkWinner(Arrays.asList(game.getPlayers()));
      assertEquals(false,test);
      Player testPlayer = game.getPlayer(1);
      testPlayer.setECTS(30);
      test = judge.checkWinner(Arrays.asList(game.getPlayers()));
      assertEquals(true,test);



    }
}
