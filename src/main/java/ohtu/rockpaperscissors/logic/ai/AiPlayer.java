package ohtu.rockpaperscissors.logic.ai;

import ohtu.rockpaperscissors.logic.RPSMove;

public interface AiPlayer {
    RPSMove getNextMove();

    void handleOpponentsMove(RPSMove move);
}
