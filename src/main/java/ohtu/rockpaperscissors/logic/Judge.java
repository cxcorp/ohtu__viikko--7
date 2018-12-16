package ohtu.rockpaperscissors.logic;

public class Judge {

    private final Scoreboard scoreboard;

    public Judge() {
        this(new Scoreboard());
    }

    Judge(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }

    public void recordMoves(RPSMove playerOneMove, RPSMove playerTwoMove) {
        if (isDraw(playerOneMove, playerTwoMove)) {
            scoreboard.addDraw();
        } else if (firstPlayerWins(playerOneMove, playerTwoMove)) {
            scoreboard.addWinForPlayerOne();
        } else {
            scoreboard.addWinForPlayerTwo();
        }
    }

    private static boolean isDraw(RPSMove firstMove, RPSMove secondMove) {
        if (firstMove == secondMove) {
            return true;
        }

        return false;
    }

    private static boolean firstPlayerWins(RPSMove firstMove, RPSMove secondMove) {
        if (firstMove == RPSMove.Rock && secondMove == RPSMove.Scissors) {
            return true;
        } else if (firstMove == RPSMove.Scissors && secondMove == RPSMove.Paper) {
            return true;
        } else if (firstMove == RPSMove.Paper && secondMove == RPSMove.Rock) {
            return true;
        }

        return false;
    }

    public String toString() {
        return String.format(
            "Pelitilanne: %d - %d\nTasapelit: %d\n",
            scoreboard.getPlayerOneScore(),
            scoreboard.getPlayerTwoScore(),
            scoreboard.getDraws()
        );
    }
}