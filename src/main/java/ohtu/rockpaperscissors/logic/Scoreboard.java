package ohtu.rockpaperscissors.logic;

public class Scoreboard {
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private int draws = 0;

    public void addWinForPlayerOne() {
        playerOneScore++;
    }

    public void addWinForPlayerTwo() {
        playerTwoScore++;
    }

    public void addDraw() {
        draws++;
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }

    public int getDraws() {
        return draws;
    }
}
