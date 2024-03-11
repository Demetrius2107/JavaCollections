package org.hua.HashMap;

import java.util.HashSet;
import java.util.Set;

public class MyHashMap {
    Node[] table;   //位桶数组
    int size;//存放的键值对个数

    public MyHashMap() {
        table = new Node[16];//长度是默认，一般是2的整数幂
    }

    //计算Hash值
    public int myHash(int v, int length) {
        System.out.println("方法一计算Hash值" + v % length);
        System.out.println("方法二:" + (v & (length - 1)));
        return v & (length - 1);
    }

    //添加
    public void put(Object key, Object value) {
        //定义新的节点
        Node newNode = new Node();
        newNode.hash = myHash(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        Node temp = table[newNode.hash];
        Node iterLast = null;//正在遍历的最后一个元素
        boolean keyRepeat = false;
        //判断数组中元素是否为空、为空直接将新节点放进去
        if (temp == null) {
            table[newNode.hash] = newNode;
            size++;
        } else {
            //此处数组不为空,则需要遍历对应的单链表
            while (temp != null) {
                //判断key是否重复， 如果重复则进行覆盖
                if (temp.key.equals(key)) {
                    System.out.println("key重复了");
                    temp.value = value;
                    keyRepeat = true;
                    break;
                } else {
                    //key值不重复 则遍历下一个
                    iterLast = temp;
                    temp = temp.next;
                }
            }
            //添加节点到链表的最后一个
            if (!keyRepeat & iterLast != null) {
                iterLast.next = newNode;
                size++;
            }
        }
    }

    //添加get方法获取value
    public Object get(Object key) {
        int hash = myHash(key.hashCode(), table.length);
        Object value = null;
        if (table[hash] != null) {
            Node temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key)) {
                    value = temp.value;
                    break;
                } else {
                    temp = temp.next;
                }
            }
        }
        return value;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < table.length; i++) {
            Node node = table[i];
            while (node != null) {
                sb.append(node.key + ":" + node.value + ",");
                node = node.next;
            }
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }


    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(10, "aa");
        myHashMap.put(20, "bb");
        myHashMap.put(30, "cc");
        myHashMap.put(30, "mm");
        myHashMap.put(53, "bb");
        myHashMap.put(69, "cc");
        myHashMap.put(85, "mm");
        System.out.println(myHashMap);
        System.out.println(myHashMap.get(85));

    }
}
