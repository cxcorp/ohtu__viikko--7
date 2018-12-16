package ohtu.rockpaperscissors.logic.ai;

import ohtu.rockpaperscissors.logic.RPSMove;

/**
 * Calculates the frequencies of moves played after a specific move.
 */
class NextMoveFrequencyCalculator {

    /**
     * Calculates the frequencies of moves in the {@code moveHistory} played
     * right after {@code previouslyPlayedMove}.
     */
    public Counter<RPSMove> calculate(
        RPSMove previouslyPlayedMove,
        RPSMove[] moveHistory
    ) {
        Counter<RPSMove> counter = new Counter<>();
        for (int i = 0; i < moveHistory.length - 1; i++) {
            if (moveHistory[i] != previouslyPlayedMove) {
                continue;
            }

            RPSMove movePlayedAfter = moveHistory[i + 1];
            counter.increment(movePlayedAfter);
        }

        return counter;
    }
}
