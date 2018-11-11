import java.util.ArrayList;
import java.util.HashMap;

//import com.sun.javafx.collections.MappingChange.Map;

public class Needs {
    private HashMap<String, Integer> states = new HashMap<String, Integer>();

    public HashMap getValue() {
        return states;
    }
    public boolean alive = true;

    public String getStates() {
        String out = "";
        for (String key: states.keySet()) {
            String str = key + ": " + getValue(key) + " || ";
            out += str;
        }
        return out;
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
        states.put("Счастье", 100);
        states.put("Туалет", 100);
        states.put("Гигиена", 100);
        states.put("Сон", 100);
    }

    public void Up(String key, int value) {
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
            int updatedValue = ex_value - value;
            if (updatedValue < 30) {
                System.out.println("!!!помираю: " + key + ": " + value);
            }
            if (key.equals("Питание") && updatedValue < 0) {
                alive = false;
            }
            if (updatedValue < 0) {
                updatedValue = 0;
            }
            this.setValue(key, updatedValue);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
