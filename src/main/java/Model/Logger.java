package Model;

public class Logger implements Observer {

    private Player player;
    private int move;

    public Logger(Player player, int move) {
        this.player = player;
        this.move = move;
    }

    @Override
    public void update() {
        move = player.getPosition();
        System.out.println("Player "+ player.toString() + "moved to "+ move);
    }
}
