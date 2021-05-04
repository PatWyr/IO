package Model;
import org.apache.commons.lang3.builder.ToStringBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board implements Observable {
    private final int fieldNo=28;
    private int laps;
    List<Field> fields = new ArrayList<>();
    List<Field> fieldsFree = new ArrayList<>();
    List<Field> fieldsOwned = new ArrayList<>();
    List<Player> stunnedPlayers = new ArrayList<>();
    private final Set<Observer> observers = new HashSet<>();

    public Board() {
        this.laps = 0;
        prepareBoard();
    }

    public void addGameToFields(Game game) {
        for(Field field : fields){
            field.addGame(game);
        }

    }


    public void prepareBoard() {
        fields.add(new NormalField(0,"Start",0,0,null));
        fields.add(new NormalField(1,"Komputerowe wspomaganie",50,1,null));
        fields.add(new NormalField(2,"Kulturowe i etyczne aspekty",100,2,null));
        fields.add(new SpecialField(3,"Wez karte"));
        fields.add(new NormalField(4,"Podstawy zarzadzania projektam",100,2,null));
        fields.add(new NormalField(5,"Podstawy analizy cyklu zycia",100,2,null));
        fields.add(new NormalField(6,"Pracownia problemowa",100,2,null));
        fields.add(new SpecialField(7,"Platny parking"));
        fields.add(new NormalField(8,"Wprowadzenie do informatyki",150,3,null));
        fields.add(new NormalField(9,"Podstawy grafiki komputerowej",150,3,null));
        fields.add(new NormalField(10,"Systemy wbudowne",150,3,null));
        fields.add(new SpecialField(11,"Wez karte"));
        fields.add(new NormalField(12,"Telekomunikacja i przetwarzanie",200,4,null));
        fields.add(new NormalField(13,"Technologie XML",200,4,null));
        fields.add(new SpecialField(14,"Wez karte"));
        fields.add(new NormalField(15,"Fizyka I",200,4,null));
        fields.add(new NormalField(16,"Architektura komputerow",200,4,null));
        fields.add(new SpecialField(17,"Wez karte"));
        fields.add(new NormalField(18,"Matematyka dyskretna",200,4,null));
        fields.add(new NormalField(19,"Programowanie obiektowe",250,5,null));
        fields.add(new NormalField(20,"Systemy wbudowane",250,5,null));
        fields.add(new SpecialField(21, "Przerwa obiadowa"));
        fields.add(new NormalField(22,"Podstawy sieci komputerowych",250,5,null));
        fields.add(new NormalField(23,"Programowanie komponentowe",300,6,null));
        fields.add(new NormalField(24,"Inzynieria oprogramowania",300,6,null));
        fields.add(new SpecialField(25,"Wez karte"));
        fields.add(new NormalField(26,"Algorytmy i struktury danych",300,6,null));
        fields.add(new NormalField(27,"Matematyka",400,8,null));

    }

    public int getPlayerPosition(Player player){
        return player.getPosition();
    }

    public void movePlayer(Player player,int number){
        int currentposition=player.getPosition();
        currentposition = currentposition+number;
        if(currentposition >= 28){
            currentposition = currentposition-28;
            int currentmoney = player.getMoney();
            currentmoney = currentmoney + 100;
            player.setMoney(currentmoney);
        }
        player.setPosition(currentposition);
        notifyObservers();
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

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }
}
