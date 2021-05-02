package Model;

public class NormalField extends Field{
    private int cost;
    private int ECTS;
    private Player owner;

    public NormalField(int position, String name, int cost, int ECTS, Player owner) {
        super(position, name);
        this.cost = cost;
        this.ECTS = ECTS;
        this.owner = owner;
    }

    @Override
    public void fieldAction() {
        super.fieldAction();

        if(getOwner() != null) {
            System.out.println("Zmiana kaski");
            int i = game.getTurn();
            game.getBoard().passMoney(game.getPlayer(i),owner,getCost());
        }
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }

    @Override
    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "NormalField{" +
                "position=" + position +
                ", name='" + name + '\'' +
                ", game=" + game +
                ", cost=" + cost +
                ", ECTS=" + ECTS +
                ", owner=" + owner +
                '}';
    }
}
