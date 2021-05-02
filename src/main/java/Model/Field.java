package Model;

public abstract class Field {
    protected int position;
    protected String name;
    protected Game game;

    public Field(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public void fieldAction(){
        System.out.println("Wykonuje akcje");
    }

    public Player getOwner(){
        return null;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void addGame(Game game){
        this.game=game;
    }

    public void setName(String name) {
        this.name = name;
    }
}
