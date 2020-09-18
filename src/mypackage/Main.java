package mypackage;

public class Main {

    public static void main(String[] args) throws Exception {

        java.util.HashMap <String, Integer> a = new java.util.HashMap<>();
        java.util.HashMap <String, Integer> b = new java.util.HashMap<>();
        a.putAll(b);

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

        HashMap<String,Integer> mapMy = new HashMap<>();

        testMap1.putAll(testMap2);



        mapMy.put("a",1);
        mapMy.put("b",2);
        mapMy.put("d",4);
        mapMy.put("e",4);
        mapMy.put("f",6);
        mapMy.put("g",7);
        mapMy.put("h",8);
        mapMy.put("i",9);
        mapMy.put("j",10);
        mapMy.put("k",11);
        mapMy.put("l",12);
        mapMy.put("m",14);
        mapMy.put("n",15);
        mapMy.put("o",16);
        mapMy.put("p",17);
        mapMy.put("q",18);
        mapMy.put("r",19);
        mapMy.put("s",20);
        mapMy.put("t",21);
        mapMy.put("u",22);

        HashMap<Integer,Integer> one = new HashMap<>();
        HashMap<Integer,Integer> two = new HashMap<>();
        HashMap<Integer,Integer> three = new HashMap<>();
        HashMap<Integer,Integer> empty = new HashMap<>();

        one.put(1,1);
        one.put(2,1);
        one.put(3,1);

        two.put(2,1);
        two.put(3,1);
        two.put(1,1);

        three.put(1,1);
        three.put(2,2);
        three.put(3,3);
        three.put(4,4);

        one.putAll(two);
        one.putAll(three);
        one.putAll(empty);



        testMap1.putAll(mapMy);
        System.out.println(one.get(1));
        System.out.println(one.get(2));
        System.out.println(one.get(3));
        System.out.println(one.get(4));


    }
}

