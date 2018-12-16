package ohtu.rockpaperscissors.ui;

import com.google.common.base.Strings;

public class MainMenu {

    private final IO io;

    public MainMenu(IO io) {
        this.io = io;
    }

    public void start() {
        while (true) {
            printMenu();
            String input = io.readInput();
            if (Strings.isNullOrEmpty(input)) {
                return;
            }

            String gameMode = getLastCharacter(input);
            RPSGame game = gameFromChoice(gameMode);

            if (game == null) {
                return;
            }

            io.print("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s\n");
            game.play();
        }
    }

    private String getLastCharacter(String input) {
        return input.substring(input.length() - 1);
    }

    private RPSGame gameFromChoice(String choice) {
        switch (choice) {
            case "a":
                return RPSGame.createMultiplayer(io);
            case "b":
                return RPSGame.createEasySingleplayer(io);
            case "c":
                return RPSGame.createDifficultSingleplayer(io);
            default:
                return null;
        }
    }

    private void printMenu() {
        io.print("\nValitse pelataanko"
            + "\n (a) ihmistä vastaan "
            + "\n (b) tekoälyä vastaan"
            + "\n (c) parannettua tekoälyä vastaan"
            + "\nmuilla valinnoilla lopetataan\n"
        );
    }
}
