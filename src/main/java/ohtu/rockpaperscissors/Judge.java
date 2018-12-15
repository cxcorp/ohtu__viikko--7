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

    public void recordMoves(String playerOneMove, String playerTwoMove) {
        if (isDraw(playerOneMove, playerTwoMove)) {
            draws++;
        } else if (firstPlayerWins(playerOneMove, playerTwoMove)) {
            playerOneScore++;
        } else {
            playerTwoScore++;
        }
    }

    private static boolean isDraw(String firstMove, String secondMove) {
        if (firstMove.equals(secondMove)) {
            return true;
        }

        return false;
    }

    private static boolean firstPlayerWins(String firstMove, String secondMove) {
        if ("k".equals(firstMove) && "s".equals(secondMove)) {
            return true;
        } else if ("s".equals(firstMove) && "p".equals(secondMove)) {
            return true;
        } else if ("p".equals(firstMove) && "k".equals(secondMove)) {
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