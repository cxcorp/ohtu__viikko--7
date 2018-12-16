package ohtu.rockpaperscissors.logic;

import java.util.HashMap;
import java.util.Map;

public class Rules {
    private final Map<RPSMove, RPSMove> moveToLosingMove;

    public Rules() {
        moveToLosingMove = new HashMap<>();
        moveToLosingMove.put(RPSMove.Rock, RPSMove.Scissors);
        moveToLosingMove.put(RPSMove.Scissors, RPSMove.Paper);
        moveToLosingMove.put(RPSMove.Paper, RPSMove.Rock);
    }

    public boolean isDraw(RPSMove playerOneMove, RPSMove playerTwoMove) {
        return playerOneMove == playerTwoMove;
    }

    public boolean isWinForFirstPlayer(
        RPSMove playerOneMove,
        RPSMove playerTwoMove
    ) {
        return moveToLosingMove.get(playerOneMove) == playerTwoMove;
    }
}
