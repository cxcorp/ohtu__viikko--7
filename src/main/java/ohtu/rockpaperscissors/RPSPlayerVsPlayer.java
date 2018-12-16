package ohtu.rockpaperscissors;

import java.util.Scanner;
import ohtu.rockpaperscissors.logic.Judge;
import ohtu.rockpaperscissors.logic.RPSMove;

public class RPSPlayerVsPlayer {

    private static final Scanner scanner = new Scanner(System.in);

    public void play() {
        Judge judge = new Judge();

        System.out.print("Ensimmäisen pelaajan siirto: ");
        RPSMove playerOneMove = RPSMove.fromString(scanner.nextLine());
        System.out.print("Toisen pelaajan siirto: ");
        RPSMove playerTwoMove = RPSMove.fromString(scanner.nextLine());

        while (playerOneMove != null && playerTwoMove != null) {
            judge.recordMoves(playerOneMove, playerTwoMove);
            System.out.println(judge);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            playerOneMove = RPSMove.fromString(scanner.nextLine());

            System.out.print("Toisen pelaajan siirto: ");
            playerTwoMove = RPSMove.fromString(scanner.nextLine());
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(judge);
    }
}