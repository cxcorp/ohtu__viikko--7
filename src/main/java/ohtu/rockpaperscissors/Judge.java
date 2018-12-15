package ohtu.rockpaperscissors;

// Judge keeps track of the players' scores and the amount of draws
public class Judge {

    private int playerOneScore;
    private int playerTwoScore;
    private int draws;

    public Judge() {
        this.playerOneScore = 0;
        this.playerTwoScore = 0;
        this.draws = 0;
    }

    public void recordMoves(RPSMove playerOneMove, RPSMove playerTwoMove) {
        if (isDraw(playerOneMove, playerTwoMove)) {
            draws++;
        } else if (firstPlayerWins(playerOneMove, playerTwoMove)) {
            playerOneScore++;
        } else {
            playerTwoScore++;
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
        String s = "Pelitilanne: " + playerOneScore + " - " + playerTwoScore + "\n"
            + "Tasapelit: " + draws;
        return s;
    }
}