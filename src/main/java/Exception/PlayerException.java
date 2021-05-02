package Exception;

public class PlayerException extends NullPointerException{
    public PlayerException() {
    }

    public PlayerException(String s) {
        super(s);
    }
}
