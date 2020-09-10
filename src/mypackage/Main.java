package mypackage;

import mypackage.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        java.util.HashMap<String, Integer> b = new java.util.HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("test",1);
        map.put("test1",2);
        map.put("test2",3);
        map.put("test3",5);
        map.put("test2",6);
        map.put("test4",7);
        map.put("test5",8);
        map.remove("test");
        map.remove("test1");

        int[] resAct = new int[]{map.get("test2"),map.get("test3"),map.get("test4")};

        map.remove("test2");
        map.remove("test3");

        resAct = new int[]{map.get("test4")};

        map.remove("test4");
        //map.remove("Nick");
       // map.remove("");
    }
}

