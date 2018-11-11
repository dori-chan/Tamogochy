import java.text.DateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

public class Logic {
    public static void main(String[] args) {
        Death killer = new Death();
        Thread th = new Thread(killer);
        th.start();
        while(true) {
            String input = readInput();
            String userID = getUserId();
            if (Arrays.asList(Texts.needs).contains(input) && Bot.TamagochyMap.containsKey(userID)) {
                Event event = new Event(input, userID);
                Bot.events.add(event);
            }
            String reply = Bot.reply(input, userID);
            Event currentAction = new Event();
            if (Bot.events.size() != 0) {
                currentAction = Bot.events.get(0);
            }
            if (!(currentAction.isEmpty()) && (currentAction.What.equals("Death"))) {
                for ( String key: Bot.TamagochyMap.keySet()) {
                    Needs need = Bot.TamagochyMap.get(key);
                    need.Down("Питание", 3);
                    need.Down("Сон", 2);
                    need.Down("Гигиена", 5);
                    need.Down("Счастье", 3);
                    Bot.TamagochyMap.put(key, need);
                }
                Bot.events.remove(0);
            }
            if (!(currentAction.isEmpty()) && !(currentAction.What.equals("Death"))) {
                currentAction.HowMuch = Bot.minus(input);
                Bot.TamagochyMap.get(currentAction.Who).Up(currentAction.What, currentAction.HowMuch);
                Bot.events.remove(0);
                System.out.println("удовлетворяю свои низменные потребности: " + currentAction.Who);
            }
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

