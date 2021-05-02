package Model;
import java.util.Arrays;
import java.util.List;


public class Game {
    private boolean running;
    private int round;
    private int playersNo;
    private final Board board;
    private Player[] players;
    private boolean requestForRoll = false;
    private boolean requestForBuy = false;
    private int turn = 0;

    public int getTurn() {
        return turn;
    }

    //constructor for testing purpose
    public Game(boolean running, int round, int playersNo, List<String> names) {
        this.running = running;
        this.round = round;
        this.playersNo = playersNo;
        players = new Player[playersNo];
        board = new Board();
        for( int i=0;i<playersNo;i++){
            players[i]=new Player(names.get(i));
        }
    }

    //main constructor
    public Game(boolean running, int round, int playersNo, List<String> names,Board board) {
        this.running = running;
        this.round = round;
        this.playersNo = playersNo;
        players = new Player[playersNo];
        this.board = board;
        for( int i=0;i<playersNo;i++){
            players[i]=new Player(names.get(i));
        }
    }

    public void setRequestForRoll(boolean request) {
        this.requestForRoll = request;
    }

    //Ask functions to GUI
    public void askForRoll(){
        setRequestForRoll(true);
    }

    public void askForBuy(){
        setRequestForBuy(true);
    }

    public void setRequestForBuy(boolean requestForBuy) {
        this.requestForBuy = requestForBuy;
    }

    public Board getBoard() {
        return board;
    }

    public void start(int i, int len){
        int players1 = getPlayersNo();
        do{
            round++;
            if(requestForRoll){
                playerRound(turn);
            }
            if(requestForBuy){
                if(board.getOneField(players[turn].getPosition()).getOwner() == null) {
                    players[turn].buyField((NormalField) board.getOneField(players[turn].getPosition()));
                } else {
                    //TODO
                    //Mozna by tu dodac jakas kontrole
                    System.out.print("Blad");
                }

            }
            if(turn == players1){
               turn = 0;
            }
            if(endControl()){
                break;
            }
            setRequestForRoll(false);
            setRequestForBuy(false);
            i++;
        } while (len>i);
    }

    public boolean endControl() {
        if(board.getLaps()>3){
            return true;
        } if(Arrays.stream(players).anyMatch(Player::isLost)){
            //TODO
        }
        return false;
    }

    public void playerRound(int id) {
        int roll = players[id].rollDice();
        board.movePlayer(players[id],roll);
    }


    public void update(){
        //TODO
    }

    public Player getPlayer(int id){
        return players[id];
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getPlayersNo() {
        return playersNo;
    }

    public void setPlayersNo(int playersNo) {
        this.playersNo = playersNo;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }
}
