package ohtu.rockpaperscissors.ui;

import ohtu.rockpaperscissors.logic.Game;
import ohtu.rockpaperscissors.logic.RPSMove;
import ohtu.rockpaperscissors.logic.ai.PredictingAiPlayer;
import ohtu.rockpaperscissors.logic.ai.SimpleAiPlayer;

public abstract class RPSGame {

    protected final Game game;
    protected final IO io;

    protected RPSMove playerOneMove;
    protected RPSMove playerTwoMove;

    protected RPSGame(IO io) {
        this.io = io;
        this.game = new Game();
    }

    public void play() {
        while (true) {
            playerOneMove = getPlayerOneMove();
            playerTwoMove = getPlayerTwoMove();

            if (playerOneMove == null || playerTwoMove == null) {
                break;
            }

            game.playRound(playerOneMove, playerTwoMove);
            handleRoundEnd(playerOneMove, playerTwoMove);
            io.print(game + "\n");
        }

        io.print("\nKiitos!\n");
        io.print(game + "\n");
    }

    protected abstract RPSMove getPlayerOneMove();

    protected abstract RPSMove getPlayerTwoMove();

    protected abstract void handleRoundEnd(
        RPSMove playerOneMove,
        RPSMove playerTwoMove
    );

    public static RPSGame createMultiplayer(IO io) {
        return new MultiplayerRPSGame(io);
    }

    public static RPSGame createEasySingleplayer(IO io) {
        return new SingleplayerRPSGame(io, new SimpleAiPlayer());
    }

    public static RPSGame createDifficultSingleplayer(IO io) {
        return new SingleplayerRPSGame(io, new PredictingAiPlayer(20));
    }
}
