package ohtu.rockpaperscissors.ui;

import ohtu.rockpaperscissors.logic.RPSMove;
import ohtu.rockpaperscissors.logic.ai.AiPlayer;

class SingleplayerRPSGame extends RPSGame {

    private final AiPlayer aiPlayer;

    public SingleplayerRPSGame(IO io, AiPlayer aiPlayer) {
        super(io);
        this.aiPlayer = aiPlayer;
    }

    @Override
    protected RPSMove getPlayerOneMove() {
        io.print("Ensimmäisen pelaajan siirto: ");
        return RPSMove.fromString(io.readInput());
    }

    @Override
    protected RPSMove getPlayerTwoMove() {
        RPSMove aiMove = aiPlayer.getNextMove();
        io.print("Tietokone valitsi: " + aiMove + "\n");
        return aiMove;
    }

    @Override
    protected void handleRoundEnd(RPSMove playerOneMove, RPSMove playerTwoMove) {
        aiPlayer.handleOpponentsMove(playerTwoMove);
    }
}
