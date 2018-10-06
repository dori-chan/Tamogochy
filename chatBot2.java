import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class chatBot2 {
    public static Map<String, Integer> state = new HashMap<String, Integer>();

    public static void main(String[] args) {
        IO myrun = new IO();
        Thread th = new Thread(myrun);
        Scanner in = new Scanner(System.in);
        System.out.println("Я родился! Пожалуйста, дай мне имя!");
        String tamagochiName = in.next();
        System.out.println("Мне нравится! А как тебя зовут?");
        String myName = in.next();
        System.out.println(Texts.info);
        state.put("Питание", 100);
        state.put("Общение", 100);
        state.put("Досуг", 100);
        state.put("Естественная нужда", 100);
        state.put("Гигиена", 100);
        state.put("Сон", 100);
        th.start();
        while (true) {
            String key = "";
            while (IO.activity) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
            try {
                Death.changeState(state);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            }
        }






}




