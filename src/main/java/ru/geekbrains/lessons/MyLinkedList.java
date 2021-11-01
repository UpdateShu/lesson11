package ru.geekbrains.lessons;

public class MyLinkedList<T> {

    private class Node {
        T data;
        Node next;
        Node prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private int size = 0;
    private Node head = null;
    private Node tail = null;

    public void addNode(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public void insertNode(int index, T data) {
        Node newNode = new Node(data);
        Node node = getNode(index);
        if (node == null) {
            if (index != 0 && size != 0) {
                System.out.println("Индекс вставки задан неверно!");
            }
            else {
                addNode(data);
                return;
            }
        }
        else {
            Node prev = node.prev;
            if (prev != null) {
                prev.next = newNode;
            }
            else {
                head = newNode;
            }
            newNode.prev = prev;
            newNode.next = node;
            node.prev = newNode;
        }
        size++;
    }

    public void removeNode(int index) {
        Node node = getNode(index);
        if (node != null)
            removeNode(node);
    }

    void removeNode(Node node)
    {
        Node next = node.next;
        Node prev = node.prev;
        if (prev != null) {
            prev.next = next;
        }
        else {
            head = next;
        }
        if (next != null)
            next.prev = prev;
        else
            tail = prev;
        size--;
    }

    public void printNode(int index) {
        if (index < 0) {
            System.out.println("Индекс с отрицательным значением не может быть найден");
            return;
        }
        if (index >= size) {
            System.out.println("Размер списка меньше искомого значения");
            return;
        }
        Node node = getNode(index);
        System.out.println(node != null ? "найден элемент " + node.data.toString() : "элемент не найден");
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        int middle = (int)((size + 1)/ 2);
        if (index < middle) {
            Node current = head;
            int i = 0;
            while (current != null && i < size) {
                if (i == index)
                    return current;
                current = current.next;
                i++;
            }
        }
        else {
            Node current = tail;
            int i = size - 1;
            while (current != null && i >= 0) {
                if (i == index)
                    return current;
                current = current.prev;
                i--;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        Node current = head;
        while (current != null)
        {
            if (current.prev != null)
                str.append(">");
            str.append(current.data + " ");
            if (current.next != null)
                str.append("-");
            current = current.next;
        }
        return str.toString() + " (" + size + ")";
    }
}
