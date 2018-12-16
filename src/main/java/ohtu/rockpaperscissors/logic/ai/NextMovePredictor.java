package ohtu.rockpaperscissors.logic.ai;

import com.google.common.collect.EvictingQueue;
import ohtu.rockpaperscissors.logic.RPSMove;

/**
 * Predicts what the next rock-paper-scissors move is going to be by counting
 * which move the player has most frequently played after the previous move,
 * then attempting to counter that.
 */
class NextMovePredictor implements MovePredictor {
    private final EvictingQueue<RPSMove> moveHistory;
    private final NextMoveFrequencyCalculator nextMoveCalculator;

    private int timesRockHasBeenPlayedNext;
    private int timesPaperHasBeenPlayedNext;
    private int timesScissorsHasBeenPlayedNext;
    private RPSMove previouslyPlayedMove;

    public NextMovePredictor(int historySampleSize) {
        moveHistory = EvictingQueue.create(historySampleSize);
        nextMoveCalculator = new NextMoveFrequencyCalculator();
    }

    @Override
    public void addPlayedMove(RPSMove move) {
        moveHistory.add(move);
        previouslyPlayedMove = move;
    }

    @Override
    public RPSMove getPredictedNextMove() {
        if (isSampleSizeTooSmall()) {
            return RPSMove.Rock;
        }

        return predictNextMoveBasedOnEarlierRounds();
    }

    private boolean isSampleSizeTooSmall() {
        return moveHistory.size() <= 1;
    }

    private RPSMove predictNextMoveBasedOnEarlierRounds() {
        countFrequencyOfMovesPlayedAfterPreviousMove();

        if (hasRockBeenPlayedNextMostOften()) {
            return RPSMove.Paper;
        }
        if (hasPaperBeenPlayedNextMostOften()) {
            return RPSMove.Scissors;
        }
        return RPSMove.Rock;
    }

    private void countFrequencyOfMovesPlayedAfterPreviousMove() {
        Counter<RPSMove> counter = nextMoveCalculator.calculate(
            previouslyPlayedMove,
            getHistoryAsArray()
        );

        timesRockHasBeenPlayedNext = counter.getCount(RPSMove.Rock);
        timesPaperHasBeenPlayedNext = counter.getCount(RPSMove.Paper);
        timesScissorsHasBeenPlayedNext = counter.getCount(RPSMove.Scissors);
    }

    private RPSMove[] getHistoryAsArray() {
        RPSMove[] moves = new RPSMove[moveHistory.size()];
        moveHistory.toArray(moves);
        return moves;
    }

    private boolean hasPaperBeenPlayedNextMostOften() {
        return timesPaperHasBeenPlayedNext > timesRockHasBeenPlayedNext
            && timesPaperHasBeenPlayedNext > timesScissorsHasBeenPlayedNext;
    }

    private boolean hasRockBeenPlayedNextMostOften() {
        return timesRockHasBeenPlayedNext > timesPaperHasBeenPlayedNext
            && timesRockHasBeenPlayedNext > timesScissorsHasBeenPlayedNext;
    }
}