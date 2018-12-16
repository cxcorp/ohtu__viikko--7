package ohtu.rockpaperscissors.ui;

import java.util.Scanner;

public class ConsoleIO implements IO {

    private final Scanner scanner;

    public ConsoleIO(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void print(String str) {
        System.out.print(str);
    }

    @Override
    public String readInput() {
        return scanner.nextLine();
    }
}
