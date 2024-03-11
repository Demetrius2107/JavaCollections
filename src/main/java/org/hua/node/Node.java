package org.hua.node;

public class Node {
    private String data;//要保存的数据
    private Node next;//要保存的下一个节点


    public Node(String data){
        this.data = data;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public Node getNext(Node next){
        return this.next;
    }

    public String getData(){
        return this.data;
    }
}
