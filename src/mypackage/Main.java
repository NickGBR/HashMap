package mypackage;

import mypackage.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {

        java.util.HashMap<String, Integer> b = new java.util.HashMap<String, Integer>();
        b.put("lol",231);
        System.out.println(b.get("1"));
        HashMap<String, Integer> map = new HashMap<>();
        map.put("house",333);
        map.put("doge",2);
        map.put("green",3);
        map.put("eco",5);
        map.put("sofa",6333333);
        map.put("length",7);
        map.put("dad",8);
        map.put("also",8);
        map.put("international",8);
        map.put("blizzard",8);
        map.put("hello",8);
        map.put("floor",222);
        map.put("flap",222);
        map.put("man",222);
        map.put("woman",222);
        map.put("топор",222);
        map.put("огонь",222);
        map.put("Как дела",222);
        map.put("только",222);
        map.put("Не много",222);
        map.put("What's uo",222);
        map.put("a little bit",222);
        System.out.println(map.get("also"));
        System.out.println(map);
        map.remove("also");
        map.remove("4234");
        System.out.println(map.remove("43424"));
        System.out.println(map);

        System.out.println(map.get("housefff"));


    }
}

