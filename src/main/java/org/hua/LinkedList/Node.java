package org.hua.LinkedList;

public class Node {
    Node previous;//前一个节点
    Node next;//下一个节点
    Object element;//本节点保存的值

    public Node (Node previous,Node next,Object element){
        this.previous = previous;
        this.next = next;
        this.element = element;
    }

    public Node(Object element){
        this.element = element;
    }
}
