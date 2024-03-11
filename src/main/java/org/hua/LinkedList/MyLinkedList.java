package org.hua.LinkedList;

public class MyLinkedList {

    private Node first;//第一个节点
    private Node last;//最后一个节点
    private int size;//当前节点个数


    //增加节点
    private void add(Object object){
        Node node = new Node(object);
        if(first == null){
            node.previous = null;
            node.next = null;
            first = node;
            last = node;
        } else {
            node.previous = last;
            node.next = null;
            last.next = node;
            last = node;
        }
        size ++;
    }


    //删除节点值，先要通过索引来查出节点
    public void remove(int index){
        Node temp = getNode(index);
        if(temp != null){
            Node up = temp.previous;
            Node down = temp.next;
            if(up != null){
                up.next = down;
            }
            if(down != null){
                down.previous = up;
            }
            //被删除的第一个节点
            if(index == 0){
                first = down;
            }
            //被删除的最后一个节点
            if(index == size - 1){
                last = up;
            }
            size --;
        }
    }

    //插入节点
    public void insert(int index,Object object){
        Node newNode = new Node(object);
        Node temp = getNode(index);
        if(temp != null){
            Node up = temp.previous;
            if(up != null){
                up.next = newNode;
                newNode.previous = up;
                newNode.next = temp;
                temp.previous = newNode;
            }
            size ++;
        }
    }

    //根据index获取节点
    public Node getNode(int index){
        if(index < 0 || index > size - 1){
            throw  new RuntimeException("索引不合法");
        }
        Node temp = null;
        if(index <= (size>>1)){
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            temp = last;
            for (int i = size - 1; i > index ; i--) {
                temp = temp.previous;
            }
            return temp;
        }
    }

    //获取节点值
    public Object get(int index){
        Node temp = getNode(index);
        return temp != null ? temp.element:null;
    }

    public int size(){
        return size;
    }

    public Object[] toArray(){
        Object[] temp = new Object[size];
        Node node = first;
        for (int i = 0; i < size; i++) {
            temp[i] = node.element;
            node = node.next;
        }
        return temp;
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        Node temp = first;
        while(temp != null){
            sb.append(temp.element + ",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }


    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add("a");
        myLinkedList.add("b");
        myLinkedList.add("c");
        myLinkedList.add("d");
        myLinkedList.add("e");
        myLinkedList.add("f");
       /* System.out.println(myLin);
        System.out.println(myLin.get(4));
        myLin.remove(0);
        System.out.println(myLin);
        myLin.remove(4);
        System.out.println(myLin);*/
        Object[] all = myLinkedList.toArray();
        for (int i = 0; i < all.length; i++) {
            Object o = all[i];
            System.out.print(o+",");
        }
    }
}
