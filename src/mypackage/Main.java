package mypackage;

public class Main {

    public static void main(String[] args) throws Exception {

        HashMap<String, Integer> testMap1 = new HashMap<>();
        HashMap<String, Integer> testMap2 = new HashMap<>();

        testMap1.put("1",1);
        testMap1.put("2",2);
        testMap1.put("3",3);
        testMap1.put("4",4);
        testMap1.put("NNNNNNNN",5);

        testMap2.put("5",5);
        testMap2.put("6",6);
        testMap2.put("7",7);
        testMap2.put("8",8);
        testMap2.put("9",9);

        testMap2.put("94",954534);
        testMap2.put("95dafsd",9534);
        testMap2.put("96",9453);


        testMap1.putAll(testMap2);

        System.out.println(testMap1.toStringService());
    }
}

