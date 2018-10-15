public class Life {
	
/*	public int change(String key){
		switch(key){
			case "Food":
			{
								
			}
		}
		return 1;
	}
	*/
    public static int food (int state) {
        Zevs.activity = true;
        try {
            System.out.println("Кушаю...");
            Thread.sleep(1000);
            System.out.println("Мм, как вкусно!");
            Thread.sleep(3000);
            System.out.println("Еще немного...");
            Thread.sleep(3000);
            System.out.println("Все! Спасибо большое!");
        } catch (InterruptedException e) {
            System.out.println("Минуточку..."+e.getMessage());
        }
        state += 10;
        if (state > 100) {
            state = 100;
            
          
        }
        return state;
    }

    public static int bath(int state) {
        Zevs.activity = true;
        try {
            System.out.println("Надо наполнить ванную...");
            Thread.sleep(1000);
            System.out.println("Какая теплая водичка!");
            Thread.sleep(3000);
            System.out.println("Пузы-ы-ы-ы-ы-ырики! ♥");
            Thread.sleep(3000);
            System.out.println("Чист и свеж, как майская роза!");
        } catch (InterruptedException e) {
            System.out.println("Минуточку...");
        }
        state += 50;
        if (state > 100) {
            state = 100;
        }
        return state;

    }

    public static int toilet(int state) {
        Zevs.activity = true;
        try {
            System.out.println("Мне нужно отлучиться на минуточку...");
            Thread.sleep(1000);
            System.out.println("/звук закрываемой двери/");
            Thread.sleep(2000);
            System.out.println("/звук... неважно чего/");
            Thread.sleep(3000);
            System.out.println("Я снова тут!");
        } catch (InterruptedException e) {
            System.out.println("Минуточку...");
        }
        state = 100;
        return state;

    }

    public static int sleeping(int state) {
        Zevs.activity = true;
        try {
            System.out.println("Пора отдыхать. Добрых снов мне!");
            Thread.sleep(1000);
            System.out.println("Хр-хр-хррррр");
            Thread.sleep(3000);
            System.out.println("/снятся сны про матан/");
            Thread.sleep(5000);
            System.out.println("Доброе утро!");
        } catch (InterruptedException e) {
            System.out.println("Минуточку...");
        }
        state = 100;
        return state;
    }
}
