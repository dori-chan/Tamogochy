import java.util.Map;

public class Death {
    public static void changeState (Map< String, Integer > dict) {
        if (dict.get("Питание") - 1 < 30) {
            System.out.println("Я очень голоден!!");
        }
        if (dict.get("Питание") - 1 <= 0) {
            System.out.println("Питание: 0. Кажется, вот он... конец...");
            System.exit(0);
        }
        if (dict.get("Естественная нужда") - 5 < 20) {
            System.out.println("Зов природы становится невыносимым! Ну отпусти на минуточку!");
        }
        if (dict.get("Естественная нужда") - 5 <= 0) {
            System.out.println("Тут такое дело... В общем, произошла утечка...");
            dict.put("Естественная нужда", 100);
            dict.put("Гигиена", 0);
        }
        else{
            dict.put("Естественная нужда", dict.get("Естественная нужда") - 5);
        }

        if (dict.get("Гигиена") - 3 < 20 && dict.get("Гигиена") - 3 > 0) {
            System.out.println("Я, конечно, понимаю, что многие считают, мол, зачем мыться, когда есть духи" +
                    "и дезодоранты, но я-то не такой...");
        }
        if (dict.get("Гигиена") - 3 <= 0) {
            System.out.println("В общем, если хочешь подойти, обняться там... Лучше подходи в противогазе");
        }
        else {
            dict.put("Гигиена", dict.get("Гигиена") - 3);
        }
        if (dict.get("Сон") - 1 <= 0) {
            System.out.println("Кажется, я засыпаю...");
            try {
                Thread.sleep(5000);
                System.out.println("Ой, извини, что заснул...");

            } catch (InterruptedException e) {
                System.out.println("Минуточку...");
            }
            dict.put("Сон", 40);

        }
        dict.put("Питание", dict.get("Питание") - 2);
        dict.put("Общение", dict.get("Общение") - 2);
        dict.put("Сон", dict.get("Сон") - 1);
        dict.put("Досуг", dict.get("Досуг") - 4);

    }
}
