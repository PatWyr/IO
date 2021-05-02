package Model;

import java.util.List;

public class Judge {

    private static Board board;
    private static Game game;
    private static Judge judge = new Judge(game,board);


    public Judge(Game game,Board board) {
        this.board = board;
        this.game = game;
    }

    public static Judge getInstance(){
        return judge;
    }

    public boolean checkWinner(List<Player> players){
        for(int i=0;i< game.getPlayersNo() ; i++){
            if(players.get(i).getECTS() == 30){
                Player winner = players.get(i);
                for(int j = 0 ; j< game.getPlayersNo() ; j++){
                    players.get(j).setLost(true);
                }
                winner.setLost(false);
               return true;
            } else if(board.getLaps()>3){
                return true;
            }
        }
        return false;
    }

    public boolean checkLost(List<Player> players){
        for(int i=0;i< game.getPlayersNo() ; i++){
            if(players.get(i).getMoney()<0){
                players.get(i).setLost(true);
                players.get(i).setMoney(0);
                //mozliwe ze do poprawy
                players.get(i).setStunLen(10000);
                return true;
            }
        }
        return false;
    }
}
