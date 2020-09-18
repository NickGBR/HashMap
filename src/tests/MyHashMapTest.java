package Tests;
import exceptions.OutOfKeyException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import mypackage.HashMap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MyHashMapTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void put() throws OutOfKeyException {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("test",1);
        map.put("test1",2);
        map.put("test2",3);
        map.put("test3",5);
        map.put("test2",6);
        map.put("test4",7);
        map.put("test5",8);
        int[] resExp = new int[]{1,2,6,5,7,8};
        int[] resAct = new int[]{map.get("test"),map.get("test1"),map.get("test2"),map.get("test3"),map.get("test4"),map.get("test5")};
        assertArrayEquals(resExp,resAct);
    }

    @Test
    public void get(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("test",1);
        map.put("test1",2);
        map.put("test2",3);
        map.put("test3",5);
        map.put("test2",6);
        map.put("test4",7);
        map.put("test5",8);
        int[] resExp = new int[]{1,6,5,7};
        int[] resAct = new int[]{map.get("test"),map.get("test2"),map.get("test3"),map.get("test4")};
        assertArrayEquals(resExp,resAct);
    }

    @Test
    public void remove(){
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
        int[] resExp = new int[]{6,5,7};
        int[] resAct = new int[]{map.get("test2"),map.get("test3"),map.get("test4")};
        assertArrayEquals(resExp,resAct);

        resExp = new int[]{7};
        resAct = new int[]{map.get("test4")};
        assertArrayEquals(resExp,resAct);

        map.remove("lol");
    }

    @Test
    public void containsKey() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("test",1);
        map.put("test1",2);
        map.put("test2",3);
        map.put("test3",5);
        map.put("test2",6);

        boolean testExp = true;
        boolean testAct = map.containsKey("test");

        boolean test2Exp = true;
        boolean test2Act = map.containsKey("test2");

        boolean nickExp = false;
        boolean nickAct = map.containsKey("nick");

        assertEquals(testExp,testAct);
        assertEquals(test2Exp,test2Act);
        assertEquals(nickExp,nickAct);
    }


    @Test
    public void putAll(){
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

        int[] resExp = new int[]{1,2,3,4};
        int[] resAct = new int[]{one.get(1),one.get(2),one.get(3),one.get(4)};

        assertTrue(Arrays.equals(resAct,resExp));

    }

    @Test
    public void equals() {
        HashMap<Integer,Integer> one = new HashMap<>();
        HashMap<Integer,Integer> two = new HashMap<>();
        HashMap<Integer,Integer> three = new HashMap<>();
        HashMap<Integer,Integer> empty = null;
        String s = "String for testing";

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

        assertTrue(one.equals(one));
        assertTrue(one.equals(two));
        assertTrue(two.equals(two));
        assertTrue(three.equals(three));



        assertFalse(one.equals(three));
        assertFalse(one.equals(empty));
        assertFalse(two.equals(three));
        assertFalse(three.equals(s));
    }

}