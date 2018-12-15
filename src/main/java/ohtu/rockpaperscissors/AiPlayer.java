package ohtu.rockpaperscissors;

public class AiPlayer {

    private int move;

    public AiPlayer() {
        move = 0;
    }

    public RPSMove getNextMove() {
        move++;
        move = move % 3;

        if (move == 0) {
            return RPSMove.Rock;
        } else if (move == 1) {
            return RPSMove.Paper;
        } else {
            return RPSMove.Scissors;
        }
    }
}
