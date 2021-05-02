package Model;

import Cards.Card;
import Cards.ListOfCards;
import java.util.Random;

public class SpecialField extends Field {
    private ListOfCards listOfCards = new ListOfCards();


    public SpecialField(int position, String name) {
        super(position, name);
    }

    public Card getCard(){
        Card tmp;
        Random random = new Random();
        int rand = random.nextInt(16);
        tmp = listOfCards.getListOfCards().get(rand);
        return tmp;
    }

    public void makeAction(Player player){
        int var = 0;
        Card tmp = getCard();
        System.out.println(tmp.toString());
        if(tmp.getForward() != 0) {
            System.out.println("Forward");
            var = player.getPosition();
            var += tmp.getForward();
            player.setPosition(var);
            return;
        } if(tmp.getBackward() != 0) {
            System.out.println("Backward");
            var = player.getPosition();
            var += tmp.getBackward();
            player.setPosition(var);
            return;
        } if(tmp.isGoStart()) {
            System.out.println("Start");
            player.setPosition(0);
            return;
        } if(tmp.getMoneyUp() != 0) {
            System.out.println("MoneyUp");
            var = player.getMoney();
            var += tmp.getMoneyUp();
            player.setMoney(var);
            return;
        } if(tmp.getMoneyDown() != 0) {
            System.out.println("MoneyDown");
            var = player.getMoney();
            var += tmp.getMoneyDown();
            player.setMoney(var);
            return;
        } if(tmp.getECTSUp() != 0) {
            System.out.println("EctsUp");
            var = player.getECTS();
            var += tmp.getECTSUp();
            player.setECTS(var);
            return;
        } if(tmp.getECTSDown() != 0) {
            System.out.println("EctsDown");
            var = player.getECTS();
            var += tmp.getECTSDown();
            player.setECTS(var);
            return;
        }
    }

    @Override
    public void fieldAction() {
        super.fieldAction();
       // System.out.println(game.getPlayer(0));
        int turn = game.getTurn();
        makeAction(game.getPlayer(turn));
       // System.out.println(game.getPlayer(turn));
       // System.out.println("Po akcji");
    }
}
