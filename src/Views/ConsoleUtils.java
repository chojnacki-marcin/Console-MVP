package Views;

import java.io.IOException;

class ConsoleUtils {
    static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ignored) {
        }
    }


    static void displayDivider() {
        System.out.println();
        System.out.println();
    }
}
