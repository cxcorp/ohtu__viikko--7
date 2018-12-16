package ohtu.rockpaperscissors;

import java.util.Scanner;
import ohtu.rockpaperscissors.logic.ai.PredictingAiPlayer;
import ohtu.rockpaperscissors.logic.Game;
import ohtu.rockpaperscissors.logic.RPSMove;

public class RPSImprovedAiPlayer {

    private static final Scanner scanner = new Scanner(System.in);

    public void play() {
        Game game = new Game();
        PredictingAiPlayer aiPlayer = new PredictingAiPlayer(20);

        System.out.print("Ensimmäisen pelaajan siirto: ");
        RPSMove playerOneMove = RPSMove.fromString(scanner.nextLine());
        RPSMove playerTwoMove = aiPlayer.getNextMove();
        System.out.println("Tietokone valitsi: " + playerTwoMove);


        while (playerOneMove != null && playerTwoMove != null) {
            game.playRound(playerOneMove, playerTwoMove);
            System.out.println(game);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            playerOneMove = RPSMove.fromString(scanner.nextLine());

            playerTwoMove = aiPlayer.getNextMove();
            System.out.println("Tietokone valitsi: " + playerTwoMove);
            aiPlayer.addOpponentsMove(playerOneMove);
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(game);
    }
}
