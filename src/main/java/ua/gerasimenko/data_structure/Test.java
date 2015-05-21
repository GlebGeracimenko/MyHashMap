package ua.gerasimenko.data_structure;

import java.util.*;

/**
 * Created by gleb on 20.05.15.
 */
public class Test {
    public static void main(String[] args) throws NoFreePlaceException {
        HashMapImpl myHashMap = new HashMapImpl();
//        for (int i = 0; i < 32; i++) {
//            myHashMap.put((int) (Math.random() * -32), (long)(Math.random() * 150));
//        }
        System.out.println(134 % 16);
        System.out.println(myHashMap.get(0));
    }
}
