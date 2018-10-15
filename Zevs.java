import java.util.Scanner;

public class Zevs implements Runnable {

	public static boolean activity = false;
	public static boolean game = false;

	public Needs Needs = new Needs();

/*	public String reply(String chatId, String userMessage){
		
	}
*/	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			while (game) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}

			String keyWord = scanner.next();

			if (keyWord.equals("проверка")) {
				System.out.println(Needs.getValue());
				activity = false;
			}

			if (keyWord.equals("покормить")) {
				activity = true;
				Needs.Up("Питание", 10);
				Needs.Up("Общение", 5);
				// ChatBot.state.put("Питание",
				// Life.food(ChatBot.state.get("Питание"))); //TODO: INCAPSULL
				// METHOD?? Life.up("food")
				// ChatBot.state.put("Общение", ChatBot.state.get("Общение")
				// +5);//up(String key)::void
				activity = false;
			}

			if (keyWord.equals("туалет")) {
				activity = true;

				Needs.Up("Естественная нужда", 10);
				Needs.Up("Общение", 5);
				activity = false;
			}

			if (keyWord.equals("спать")) {
				activity = true;

				Needs.Up("Сон", 100);
				activity = false;
			}

			if (keyWord.equals("вымыть")) {
				activity = true;

				Needs.Up("Гигиена", 10);
				Needs.Up("Общение", 5);
				activity = false;
			}

			if (keyWord.equals("справка")) {
				System.out.println(Texts.info);

			}

			if (keyWord.equals("команды")) {
				for (String el : Texts.commands) {
					System.out.println(el);
				}
			}

			if (keyWord.equals("выход")) {
				System.exit(0);
			}

			if (keyWord.equals("города")) {
				GameCityes mythread = new GameCityes();
				Thread th = new Thread(mythread);
				th.start();
			}

		}

	}

	public void Death() {
		try {
			Needs.Down("Питание", Death.changeState("Питание"));
			Needs.Down("Сон", Death.changeState("Сон"));
			Needs.Down("Гигиена", Death.changeState("Гигиена"));
			Needs.Down("Естественная нужда",
					Death.changeState("Естественная нужда"));
			Needs.Down("Досуг", Death.changeState("Досуг"));
			Needs.Down("Общение", Death.changeState("Общение"));
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
