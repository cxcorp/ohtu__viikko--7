package ohtu.rockpaperscissors;

import java.util.Scanner;
import ohtu.rockpaperscissors.logic.ai.SimpleAiPlayer;
import ohtu.rockpaperscissors.logic.Judge;
import ohtu.rockpaperscissors.logic.RPSMove;

public class RPSAiPlayer {

    private static final Scanner scanner = new Scanner(System.in);

    public void play() {
        Judge judge = new Judge();
        SimpleAiPlayer aiPlayer = new SimpleAiPlayer();

        System.out.print("Ensimmäisen pelaajan siirto: ");
        RPSMove playerOneMove = RPSMove.fromString(scanner.nextLine());
        RPSMove playerTwoMove = aiPlayer.getNextMove();
        System.out.println("Tietokone valitsi: " + playerTwoMove);


        while (playerOneMove != null && playerTwoMove != null) {
            judge.recordMoves(playerOneMove, playerTwoMove);
            System.out.println(judge);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            playerOneMove = RPSMove.fromString(scanner.nextLine());

            playerTwoMove = aiPlayer.getNextMove();
            System.out.println("Tietokone valitsi: " + playerTwoMove);
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(judge);
    }
}