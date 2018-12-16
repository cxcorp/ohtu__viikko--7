
package ohtu.rockpaperscissors.logic.ai;

import ohtu.rockpaperscissors.logic.RPSMove;

/**
 * An AI player which predicts the next move based on the player's previous
 * moves.
 */
public class PredictingAiPlayer implements AiPlayer {
    private final MovePredictor predictor;

    public PredictingAiPlayer(int memorySize) {
        this(new NextMovePredictor(memorySize));
    }

    // Package-private ctor for unit test access
    PredictingAiPlayer(MovePredictor predictor) {
        this.predictor = predictor;
    }

    public void handleOpponentsMove(RPSMove move) {
        predictor.addPlayedMove(move);
    }

    public RPSMove getNextMove() {
        return predictor.getPredictedNextMove();
    }
}