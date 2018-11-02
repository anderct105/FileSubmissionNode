package eus.ehu.ikasle.eda.segundaFase;

import java.util.NoSuchElementException;

public class UnorderedCircularLinkedList<T> extends CircularLinkedList<T> implements UnorderedListADT<T> {

    public void addToFront(T elem) { // O(1)
        // anade un elemento al comienzo
        Node<T> elemNode = new Node<T>(elem);
        if (this.count != 0) {
            elemNode.next = this.last.next;
            this.last.next = elemNode;
        } else {
            this.last = elemNode;
            elemNode.next = last;
        }
        this.count++;
    }

    public void addToRear(T elem) { // O(1)
        // anade un elemento al final
        Node<T> elemNode = new Node<T>(elem);
        if (this.count != 0) {
            elemNode.next = this.last.next;
            this.last.next = elemNode;
            this.last = elemNode;
        } else {
            this.last = elemNode;
            this.last.next = elemNode;
        }
        this.count++;
    }

    public void addAfter(T elem, T target) { //O(n) n= numero de elementos
        // Anade elem detras de otro elemento concreto, target,  que ya se encuentra en la lista
        Node tmp;
        if (count != 0) {
            tmp = this.last.next;
            if (this.last.data.equals(target)) {
                Node<T> elemNode = new Node<>(elem);
                elemNode.next = this.last.next;
                this.last.next = elemNode;
                this.last = elemNode;
                this.count++;
            } else if (this.last.next.data.equals(target)) {
                Node<T> elemNode = new Node<>(elem);
                elemNode.next = tmp.next;
                tmp.next = elemNode;
                this.count++;
            } else {
                tmp = tmp.next;
                while (!tmp.equals(this.last) && !tmp.data.equals(target)) {
                    tmp = tmp.next;
                }
                if (tmp.data.equals(target)) {
                    Node<T> elemNode = new Node<>(elem);
                    elemNode.next = tmp.next;
                    tmp.next = elemNode;
                    this.count++;
                } else {
                    throw new NoSuchElementException("Target not found");
                }
            }
        }
    }

}
