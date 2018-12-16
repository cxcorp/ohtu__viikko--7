package ohtu.rockpaperscissors.ui;

import ohtu.rockpaperscissors.logic.RPSMove;

class MultiplayerRPSGame extends RPSGame {

    public MultiplayerRPSGame(IO io) {
        super(io);
    }

    @Override
    protected RPSMove getPlayerOneMove() {
        io.print("Ensimmäisen pelaajan siirto: ");
        return RPSMove.fromString(io.readInput());
    }

    @Override
    protected RPSMove getPlayerTwoMove() {
        io.print("Toisen pelaajan siirto: ");
        return RPSMove.fromString(io.readInput());
    }

    @Override
    protected void handleRoundEnd(
        RPSMove playerOneMove,
        RPSMove playerTwoMove
    ) {
        // no implementation needed
    }
}