package com.domain.lesson10;

public class LinkedList <T> { //связный список
    private  Node head; //ссылка на первый узел
    public void add(T value){
        if (head == null) {
            head = new Node <>(value);        //пустой или нет? добавление первого
            return;
        }
        find(-1).next = new Node<> (value); // когда первый уже занят, искать другой, где есть ссылка на null
    }
    public T get(int ind) {   //1
        Node<T> result = find(ind);
        return result == null ? null : result.value;
    }

    private Node find(int ind){
        if (ind ==0) return head;
        int cnt = 0;
        Node node = head;
        while (node !=null){
            if (cnt++ == ind) return node;
            if (ind <0 && node.next ==null) return node;
            node = node.next;
        }
        return null;
    }


}




class Node <T>{ //узлы
    T value; //не знаем,какого типа будет, потому дженерик
    Node next;

    public Node(T value) {
        this.value = value;
    }
}