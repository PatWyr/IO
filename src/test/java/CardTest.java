import Cards.ListOfCards;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {
    @Test
    public void createTest(){
        ListOfCards List = new ListOfCards();
        System.out.println(List.getListOfCards().get(0).getForward());
        System.out.println(List.getListOfCards().get(1).getForward());
        System.out.println(List.getListOfCards().get(2).getBackward());
        System.out.println(List.getListOfCards().get(3).getBackward());
        System.out.println(List.getListOfCards().get(4).isGoStart());
        System.out.println(List.getListOfCards().get(5).isGoStart());
        System.out.println(List.getListOfCards().get(6).isPrison());
        System.out.println(List.getListOfCards().get(7).isPrison());
        System.out.println(List.getListOfCards().get(8).getMoneyUp());
        System.out.println(List.getListOfCards().get(9).getMoneyUp());
        System.out.println(List.getListOfCards().get(10).getMoneyDown());
        System.out.println(List.getListOfCards().get(11).getMoneyDown());
        System.out.println(List.getListOfCards().get(12).getECTSUp());
        System.out.println(List.getListOfCards().get(13).getECTSUp());
        System.out.println(List.getListOfCards().get(14).getECTSDown());
        System.out.println(List.getListOfCards().get(15).getECTSDown());
    }
}
