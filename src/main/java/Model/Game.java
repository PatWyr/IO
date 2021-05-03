package Model;
import java.util.Arrays;
import java.util.List;


//wzorzec builder Inner Static Fluent Builder

public class Game {
    private boolean running;
    private int round;
    private int playersNo;
    private  Board board = null;
    private Player[] players;
    private boolean requestForRoll = false;
    private boolean requestForBuy = false;
    private int turn = 0;
    Judge judge = Judge.getInstance(this,board);

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

    public void RemovePlayer() {
        Player[] newplayers= new Player[playersNo-1];
        int z =0;
        for( int i=0;i<playersNo;i++){
            if(!players[i].isLost()){
                newplayers[z]= players[i];
                z++;
            }
        }
        playersNo=playersNo-1;
        players=newplayers;
        turn-=1;
        nextTurn();
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

    public int requestForRoll() {
        return playerRound(turn);
    }

    public void nextTurn() {
        if(turn == players.length-1){
            turn = 0;
        } else {
            turn++;
        }
    }

    public boolean isDostepne() {
        if (board.getOneField(players[turn].getPosition()) instanceof NormalField && board.getOneField(players[turn].getPosition()).getOwner() == null) {
            return true;
        }
        return false;
    }

    public void requestForBuy() {
        if (board.getOneField(players[turn].getPosition()).getOwner() == null && board.getPlayerPosition(players[turn]) != 0) {
            players[turn].buyField((NormalField) board.getOneField(players[turn].getPosition()));
        }
    }

    public Board getBoard() {
        return board;
    }



    public boolean endControl() {
        if(board.getLaps()>3){
            return true;
        } if(Arrays.stream(players).anyMatch(Player::isLost)){
            //TODO
        }
        return false;
    }

    public int playerRound(int id) {
        int roll = players[id].rollDice();
        board.movePlayer(players[id],roll);
        board.getOneField(players[id].getPosition()).fieldAction();
        return roll;
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


    //wzorzec builder Inner Static Fluent Builder
    public static final class Builder{
        private boolean running;
        private int round;
        private int playersNo;
        private  Board board = null;
        private Player[] players;

        public Builder running(boolean running) {
            this.running = running;
            return this;
        }

        public Builder round(int round) {
            this.round = round;
            return this;
        }

        public Builder playerNo(int playersNo) {
            this.playersNo = playersNo;
            return this;
        }

        public Builder board(Board board) {
            this.board = board;
            return this;
        }

        public Builder players(Player[] players) {
            this.players = players;
            return this;
        }


    }


}
