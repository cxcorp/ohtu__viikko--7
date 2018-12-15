package ohtu.rockpaperscissors;

import java.util.Scanner;

public class RPSImprovedAiPlayer {

    private static final Scanner scanner = new Scanner(System.in);

    public void play() {
        Judge judge = new Judge();
        ImprovedAiPlayer aiPlayer = new ImprovedAiPlayer(20);

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
            aiPlayer.addOpponentsMove(playerOneMove);
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(judge);
    }
}
