package ohtu.rockpaperscissors;

import java.util.Scanner;

public class RPSPlayerVsPlayer {

    private static final Scanner scanner = new Scanner(System.in);

    public void play() {
        Judge judge = new Judge();

        System.out.print("Ensimmäisen pelaajan move: ");
        RPSMove playerOneMove = RPSMove.fromString(scanner.nextLine());
        System.out.print("Toisen pelaajan move: ");
        RPSMove playerTwoMove = RPSMove.fromString(scanner.nextLine());

        while (playerOneMove != null && playerTwoMove != null) {
            judge.recordMoves(playerOneMove, playerTwoMove);
            System.out.println(judge);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan move: ");
            playerOneMove = RPSMove.fromString(scanner.nextLine());

            System.out.print("Toisen pelaajan move: ");
            playerTwoMove = RPSMove.fromString(scanner.nextLine());
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(judge);
    }
}