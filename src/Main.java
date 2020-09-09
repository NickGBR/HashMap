

public class Main {

    public static void main(String[] args) throws Exception {
        java.util.HashMap<String, Integer> b = new java.util.HashMap<>();
        HashMap<String, Integer> a = new HashMap<>();
        a.put("lol", 2);
        a.put("lol2", 4);
        a.put("pp", 7);
        a.put("pp", 7);
        a.put("lol", 444);
        a.put("nick", 333);
        a.put("nick", 777);
//        System.out.println("--------");
//        a.get();
        a.put("Green", 222);
//        System.out.println("--------");
//        a.get();
        a.put("Green", 123);
//        System.out.println("--------");
        Integer value = a.get("lol");
        System.out.println(value);
        System.out.println(a.containsKey("lol"));
        System.out.println(a.containsKey("lolff"));
    }
}

