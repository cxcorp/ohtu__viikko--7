package ohtu.rockpaperscissors;

public class AiPlayer {

    private int move;

    public AiPlayer() {
        move = 0;
    }

    public String getNextMove() {
        move++;
        move = move % 3;

        if (move == 0) {
            return "k";
        } else if (move == 1) {
            return "p";
        } else {
            return "s";
        }
    }

    public void addOpponentsMove(String move) {
        // do nothing
    }
}
