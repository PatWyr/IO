package Model;

import java.util.List;


//singleton
public class Judge {

    private static Board board;
    private static Game game;
    private static Judge judge;

    private Judge(Game game,Board board) {
        this.board = board;
        this.game = game;
    }

    public static Judge getInstance(Game game,Board board){
        if(judge==null) {
            judge = new Judge(game, board);
        }
        return judge;
    }

    public boolean checkWinner(List<Player> players){
        for(int i=0;i< game.getPlayersNo() ; i++){
            if(players.get(i).getECTS() == 30){
                Player winner = players.get(i);
                for(int j = 0 ; j< game.getPlayersNo() ; j++){
                    System.out.println("cos");
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
}
