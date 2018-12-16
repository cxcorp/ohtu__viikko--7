package ohtu.rockpaperscissors.logic;

public class Game {

    private final Scoreboard scoreboard;
    private final Rules rules;

    public Game() {
        this(new Scoreboard(), new Rules());
    }

    Game(Scoreboard scoreboard, Rules rules) {
        this.scoreboard = scoreboard;
        this.rules = rules;
    }

    public void playRound(RPSMove playerOneMove, RPSMove playerTwoMove) {
        if (rules.isDraw(playerOneMove, playerTwoMove)) {
            scoreboard.addDraw();
            return;
        }

        if (rules.isWinForFirstPlayer(playerOneMove, playerTwoMove)) {
            scoreboard.addWinForPlayerOne();
        } else {
            scoreboard.addWinForPlayerTwo();
        }
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