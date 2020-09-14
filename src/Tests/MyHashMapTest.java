package Tests;

import Exceptions.OutOfKeyException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class MyHashMapTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void put() {
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
    public void get() {
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
    public void remove() {
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

        map.remove("test2");
        map.remove("test3");
        resExp = new int[]{7};
        resAct = new int[]{map.get("test4")};
        assertArrayEquals(resExp,resAct);

        map.remove("test4");
        map.remove("Nick");
        map.remove("");


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
    public void equals() {
    }

}