package ohtu.rockpaperscissors.logic.ai;

import ohtu.rockpaperscissors.logic.RPSMove;

public interface MovePredictor {
    void addPlayedMove(RPSMove move);

    RPSMove getPredictedNextMove();
}
