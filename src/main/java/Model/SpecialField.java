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
        int rand = random.nextInt(12);
        tmp = listOfCards.getListOfCards().get(rand);
        return tmp;
    }

    @Override
    public void fieldAction() {
        super.fieldAction();

    }
}
