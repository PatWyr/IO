package Cards;

import java.util.ArrayList;
import java.util.List;

public class ListOfCards {
    List<Card> ListOfCards = new ArrayList<>();

    public ListOfCards() {
        Card Card1 = new CardA();
        Card Card2 = new CardA();

        Card Card3 = new CardB();
        Card Card4 = new CardB();

        Card Card5 = new CardC();
        Card Card6 = new CardC();

        Card Card7 = new CardD();
        Card Card8 = new CardD();

        Card Card9 = new CardE();
        Card Card10 = new CardE();

        Card Card11 = new CardF();
        Card Card12 = new CardF();

        Card Card13 = new CardG();
        Card Card14 = new CardG();

        Card Card15 = new CardH();
        Card Card16 = new CardH();

        ListOfCards.add(Card1);
        ListOfCards.add(Card2);
        ListOfCards.add(Card3);
        ListOfCards.add(Card4);
        ListOfCards.add(Card5);
        ListOfCards.add(Card6);
        ListOfCards.add(Card7);
        ListOfCards.add(Card8);
        ListOfCards.add(Card9);
        ListOfCards.add(Card10);
        ListOfCards.add(Card11);
        ListOfCards.add(Card12);
        ListOfCards.add(Card13);
        ListOfCards.add(Card14);
        ListOfCards.add(Card15);
        ListOfCards.add(Card16);
    }

    public List<Card> getListOfCards() {
        return ListOfCards;
    }
}
