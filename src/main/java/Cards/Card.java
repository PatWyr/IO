package Cards;

public abstract class Card {
    protected int PlayerID;
    protected String CardUrl;
    protected int forward = 0;
    protected int Backward = 0;
    protected boolean GoStart = false;
    protected boolean Prison = false;
    protected int MoneyUp = 0;
    protected int MoneyDown = 0;
    protected int ECTSUp = 0;
    protected int ECTSDown = 0;

    public Card() {
    }

    public int getPlayerID() {
        return PlayerID;
    }

    public void setPlayerID(int playerID) {
        PlayerID = playerID;
    }

    public int getForward() {
        return forward;
    }

    public int getBackward() {
        return Backward;
    }

    public boolean isGoStart() {
        return GoStart;
    }

    public boolean isPrison() {
        return Prison;
    }

    public int getMoneyUp() {
        return MoneyUp;
    }

    public int getMoneyDown() {
        return MoneyDown;
    }

    public int getECTSUp() {
        return ECTSUp;
    }

    public int getECTSDown() {
        return ECTSDown;
    }

    public String getCardUrl() {
        return CardUrl;
    }

    @Override
    public String toString() {
        return "Card{" +
                "PlayerID=" + PlayerID +
                ", CardUrl='" + CardUrl + '\'' +
                ", forward=" + forward +
                ", Backward=" + Backward +
                ", GoStart=" + GoStart +
                ", Prison=" + Prison +
                ", MoneyUp=" + MoneyUp +
                ", MoneyDown=" + MoneyDown +
                ", ECTSUp=" + ECTSUp +
                ", ECTSDown=" + ECTSDown +
                '}';
    }
}
