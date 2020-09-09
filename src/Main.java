import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        java.util.HashMap<String, Integer> b = new java.util.HashMap<>();
        HashMap<String, Integer> a = new HashMap<>();
        HashMap<String, Integer> d = new HashMap<>();
        a.put("lol", 3);
        a.put("lol2", 3);
        d.put("lol2", 3);
        d.put("lol",3);
        d.put("lol",5);
        d.put("lol",3);
        System.out.println(a.equals(d));

    }
}

