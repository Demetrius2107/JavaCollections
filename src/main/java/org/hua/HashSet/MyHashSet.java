package org.hua.HashSet;

import org.hua.HashMap.MyHashMap;

import java.util.HashMap;

public class MyHashSet {
    HashMap map;

    private static final Object PRESENT = new Object();

    public MyHashSet(){
        map = new HashMap();
    }

    public int size(){
        return map.size();
    }

    public void add(Object object){
        map.put(object,PRESENT);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (Object o: map.keySet()){
            sb.append(o + " ");
        }
        sb.setCharAt(sb.length() - 1 ,']');
        return sb.toString();
    }


    public static void main(String[] args) {
        final MyHashSet myHashSet = new MyHashSet();
        myHashSet.add("aa");
        myHashSet.add("bb");
        myHashSet.add("cc");
        System.out.println(myHashSet);
    }
}
