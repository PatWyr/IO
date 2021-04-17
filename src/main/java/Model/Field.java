package Model;

public abstract class Field {
    protected int position;
    protected String name;

    public Field(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public void fieldAction(){
        //TODO
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

    public void setName(String name) {
        this.name = name;
    }
}
