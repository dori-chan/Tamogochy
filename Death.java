

public class Death {
	
	public static int changeState(String key)
	{
		switch (key) {
		case "Питание":
		case "Общение":
			return 2;
		
		case "Сон":
			return 1;
		
		case "Досуг":
			return 4;
			
	
		default:
			System.out.println("Эт чё такое");
			return 0;
			
		}
		
	}

}
