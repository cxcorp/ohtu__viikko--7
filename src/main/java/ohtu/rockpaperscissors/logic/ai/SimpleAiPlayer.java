package ohtu.rockpaperscissors.logic.ai;

import ohtu.rockpaperscissors.logic.RPSMove;

/**
 * A simple AI which gets the next move directly from an array.
 */
public class SimpleAiPlayer {

    private final RPSMove[] moves;
    private int currentMove;

    public SimpleAiPlayer() {
        this(RPSMove.values());
    }

    // Package-private ctor for unit test access
    SimpleAiPlayer(RPSMove[] moves) {
        this.moves = moves;
        currentMove = 0;
    }

    public RPSMove getNextMove() {
        goToNextMove();
        return moves[currentMove];
    }

    private void goToNextMove() {
        currentMove++;
        currentMove = currentMove % moves.length;
    }
}
