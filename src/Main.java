import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        java.util.HashMap<String, Integer> b = new java.util.HashMap<>();
        HashMap<String, Integer> a = new HashMap<>();
        HashMap<String, Integer> d = new HashMap<>();
        d.put("2",2);
        d.put("1",1);
        d.put("3",1);
        d.put("4",1);
        d.put("5",1);
        d.put("6",1);
        System.out.println(d.containsKey("2"));
        System.out.println(Arrays.toString(d.getKeys()));
        d.remove("2");
        d.remove("d");
        System.out.println(Arrays.toString(d.getKeys()));
    }
}

