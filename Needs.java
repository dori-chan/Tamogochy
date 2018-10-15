import java.util.HashMap;

//import com.sun.javafx.collections.MappingChange.Map;

public class Needs {
	private HashMap<String, Integer> states = new HashMap<String, Integer>();

	public HashMap getValue() {
		return states;
	}

	public int getValue(String key) {

		return states.get(key);
	}

	public void setValue(String key, int value) {

		try {
			states.put(key, value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Needs() {
		states.put("Питание", 100);
		states.put("Общение", 100);
		states.put("Досуг", 100);
		states.put("Естественная нужда", 100);
		states.put("Гигиена", 100);
		states.put("Сон", 100);
	}

	public void Up(String key, int value) {
		System.out.println("удовлетворяю свои низменные потребности");
		try {
			int ex_value = this.getValue(key);
			int upedValue = (ex_value + value);

			if (upedValue > 100) {
				upedValue = 100;
			}

			this.setValue(key, upedValue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void Down(String key, int value) {

		try {
			int ex_value = this.getValue(key);
			int updatedValue = ex_value + value;
			if (updatedValue < 30) {
				System.out.println("помираю" + this.getValue());
			}
			this.setValue(key, ex_value - value);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
