package Model;
import org.apache.commons.lang3.builder.ToStringBuilder;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int fieldNo=30;
    private int laps;
    List<Field> fields = new ArrayList<>();
    List<Field> fieldsFree = new ArrayList<>();
    List<Field> fieldsOwned = new ArrayList<>();
    List<Player> stunnedPlayers = new ArrayList<>();

    public Board() {
        this.laps = 0;
        //Funkcja do testu
        for(int i=0;i<fieldNo;i++){
            fields.add(new NormalField(i,"Testowe pola",100,10,null));
        }
    }

    public void prepareBoard(){
        Field field1 = new NormalField(1,"Komputerowe wspomaganie projektowania z elementami normalizacji",50,1,null);
    }

    public int getPlayerPosition(Player player){
        return player.getPosition();
    }

    public void movePlayer(Player player,int number){
        int currentposition=player.getPosition();
        currentposition = currentposition+number;
        if(currentposition > 30){
            currentposition = currentposition-30;
            int currentmoney = player.getMoney();
            currentmoney = currentmoney + 100;
            player.setMoney(currentmoney);
        }
        player.setPosition(currentposition);
    }

    public void getFieldAction(Field field){
        //TODO
    }

    public void getFieldActon(int position){
        //TODO
    }

    public void stunPlayer(int duration,Player player){
        player.setStun(true);
        player.setStunLen(duration);
    }

    public boolean checkOwnerShip(Field field,Player player){
        return player.equals(field.getOwner());
    }

    public boolean checkStunnedPlayers(){
        return !stunnedPlayers.isEmpty();
    }

    public void passMoney(Player player1,Player player2,int money){
        if(player1.getMoney()<money){
            player1.setLost(true);
        } else {
            int currentMoney = player1.getMoney();
            player1.setMoney(currentMoney-money);
            currentMoney = player2.getMoney();
            player2.setMoney(currentMoney+money);
        }
    }

    public Field getOneField(int position){
        return fields.get(position);
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    public List<Field> getFields() {
        return fields;
    }

    public List<Field> getFieldsFree() {
        return fieldsFree;
    }

    public List<Field> getFieldsOwned() {
        return fieldsOwned;
    }

    public List<Player> getStunnedPlayers() {
        return stunnedPlayers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(fieldNo, board.fieldNo)
                .append(laps, board.laps)
                .append(fields, board.fields)
                .append(fieldsFree, board.fieldsFree)
                .append(fieldsOwned, board.fieldsOwned)
                .append(stunnedPlayers, board.stunnedPlayers)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(fieldNo)
                .append(laps)
                .append(fields)
                .append(fieldsFree)
                .append(fieldsOwned)
                .append(stunnedPlayers)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("fieldNo", fieldNo)
                .append("laps", laps)
                .append("fields", fields)
                .append("fieldsFree", fieldsFree)
                .append("fieldsOwned", fieldsOwned)
                .append("stunnedPlayers", stunnedPlayers)
                .toString();
    }

    public int getListSize(){
        return fields.size();
    }
}
