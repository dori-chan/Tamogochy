import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class ChatBot {
	// public static Map<String, Integer> state = new HashMap<String,
	// Integer>();//check it

	// Needs Needs2D = Zevs.Needs;

	public static void main(String[] args) {
		Zevs myrun = new Zevs();
		Thread zeus = new Thread(myrun);
		Scanner inName = new Scanner(System.in);
		System.out.println("Я родился! Пожалуйста, дай мне имя!");
		String tamagochiName = inName.next();
		System.out.println("Мне нравится! А как тебя зовут?");
		String myName = inName.next();
		System.out.println(Texts.info);
		// put all in Needs class constructor
		zeus.start();

		while (true) {
			String key = "";

			while (Zevs.activity) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}

			myrun.Death();
		}
	}
}
