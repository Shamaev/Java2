import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Phone {

    TreeMap<String, ArrayList<String>> tel = new TreeMap<>();
    public void add(String name, String number) {
        if (tel.containsKey(name)) {
            tel.get(name).add(number);
        } else {
            ArrayList<String> num = new ArrayList<>();
            num.add(number);
            tel.put(name, num);
        }
    }

    public void get(String name) {
        if (tel.containsKey(name)) {
            System.out.println();
            System.out.println("Поиск:");
            System.out.print(name + " ");
            System.out.println(tel.get(name));
        }
    }


    public void print() {
        Set<Map.Entry<String, ArrayList<String>>> trr = tel.entrySet();
        for (Map.Entry<String, ArrayList<String>> me : trr) {
            System.out.println(me.getKey() + " " + me.getValue());

        }
    }
}
