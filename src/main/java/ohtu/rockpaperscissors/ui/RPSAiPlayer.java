package ohtu.rockpaperscissors;

import java.util.Scanner;
import ohtu.rockpaperscissors.logic.ai.SimpleAiPlayer;
import ohtu.rockpaperscissors.logic.Game;
import ohtu.rockpaperscissors.logic.RPSMove;

public class RPSAiPlayer {

    private static final Scanner scanner = new Scanner(System.in);

    public void play() {
        Game game = new Game();
        SimpleAiPlayer aiPlayer = new SimpleAiPlayer();

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
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(game);
    }
}