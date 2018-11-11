import java.util.ArrayList;
import java.util.HashMap;

public class Bot {
    public static HashMap<String, Needs> TamagochyMap = new HashMap<String, Needs>();
    public static ArrayList<Event> events = new ArrayList<Event>();
    public static int minus(String input) {

        switch (input) {
            case "Питание": {
                return 20;
            }
            case "Сон": {

                return 100;
            }
            case "Туалет": {
                return 50;
            }
            case "Счастье": {
                return 10;
            }
            case "Гигиена": {
                return 15;
            }
            default:
                break;
        }
        return 0;
    }
    public static String reply(String input, String ID) {
        if (!Bot.TamagochyMap.containsKey(ID)) {
            Needs needs = new Needs();
            Bot.TamagochyMap.put(ID, needs);
            return "Я родился!";
        }
        switch (input) {

            case "Питание": {
                return "Сейчас я буду кушать, сейчас меня покормят!";
            }
            case "Сон": {
                return "Я ложусь спать, не беспокой меня несколько минут!";
            }
            case "Туалет": {
                return "Секундочку, я отлучусь...";
            }
            case "Счастье": {
                return "Я так рад, что ты у меня есть!";
            }
            case "Гигиена": {
                return "А сейчас я хочу расслабиться и принять ванну";
            }
            case "Команды": {
                return Texts.commands;
            }
            case "Проверка": {
                return Bot.TamagochyMap.get(ID).getStates();
            }
            default:
                return "Я не знаю такой команды! Если хочешь узнать список доступных, введи \"Команды\"";
        }

    }
}



