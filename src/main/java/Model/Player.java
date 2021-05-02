package Model;

import java.util.Random;

public class Player {
    private boolean stun;
    private int stunLen;
    private boolean lost;

    public int getStunLen() {
        return stunLen;
    }

    public void setStunLen(int stunLen) {
        this.stunLen = stunLen;
    }

    private  String name;
    private int ECTS;
    private int money;
    private int position;


    public Player(String name) {
        this.stun = false;
        this.lost = false;
        this.name = name;
        this.ECTS = 0;
        this.money = 500;
        this.position = 0;
    }

    public int rollDice(){
        Random random = new Random();
        return random.nextInt(6)+1;
    }

    public void buyField(NormalField field){
        int tmp;
        int money;
         if(field.getCost()<=this.getMoney()) {
             money = this.getMoney();
             this.setMoney(money - field.getCost());
             field.setOwner(this);
             tmp = this.getECTS();
             setECTS(tmp + field.getECTS());
         }
    }

    public boolean isStun() {
        return stun;
    }

    public void setStun(boolean stun) {
        this.stun = stun;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "stun=" + stun +
                ", stunLen=" + stunLen +
                ", lost=" + lost +
                ", name='" + name + '\'' +
                ", ECTS=" + ECTS +
                ", money=" + money +
                ", position=" + position +
                '}';
    }
}
