package Model;

import java.util.List;

public class Judge {

    private static Board board;
    private static Game game;


    public Judge(Game game,Board board) {
        this.board = board;
        this.game = game;
    }

    public static Judge getInstance(Game game,Board board){
        return new Judge(game,board);
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
                Player loser = players.get(i);
                players.get(i).setLost(true);
                players.get(i).setMoney(0);
                players.remove(i);
                return true;
            }
        }
        return false;
    }
}
