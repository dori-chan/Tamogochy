import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ConsoleEntryPoint {
    public static void main(String[] args) {
        Bot bot = new Bot();
        while (true) {
            String input = readInput();
            String userID = getUserId();
            String reply = bot.reply(input, userID);
            bot.EventHandler(input, userID);
            System.out.println("ID: " + userID + " || " + reply);
        }
    }

    public static String readInput() {
        Scanner input = new Scanner(System.in);
        String command = input.next();
        return command;
    }

    public static String getUserId() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
        return String.valueOf(randomNum);
    }
}