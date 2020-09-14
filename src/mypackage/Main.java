package mypackage;

import mypackage.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        HashMap<String, Integer> b = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("test",333);
        map.put("test1",2);
        map.put("test2",3);
        map.put("test3",5);
        map.put("test2",6);
        map.put("test4",7);
        map.put("test5",8);

        Object nick = map.put("lol",2);
        System.out.println(nick);
        System.out.println(map.get("lol"));

        int[] resAct = new int[]{map.get("test2"),map.get("test3"),map.get("test4")};


        resAct = new int[]{map.get("test4")};

        map.remove("test4");

        System.out.println(map.get("test"));
        Object old = map.put("test",666);
        System.out.println(old);
        System.out.println(map.get("test"));

        for(Object a:map.getKeys()){
            System.out.println(a);
        }

        //map.remove("Nick");
       // map.remove("");
    }
}

