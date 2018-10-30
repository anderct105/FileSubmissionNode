package eus.ehu.ikasle.eda.segundaFase;

import java.util.NoSuchElementException;

public class UnorderedCircularLinkedList<T extends Comparable<T>> extends CircularLinkedList<T> implements UnorderedListADT<T> {

    public void addToFront(T elem) { // O(1)
        // a�ade un elemento al comienzo
        // COMPLETAR EL CODIGO Y CALCULAR EL COSTE
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
        // a�ade un elemento al final
        // COMPLETAR EL CODIGO Y CALCULAR EL COSTE
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
        // A�ade elem detr�s de otro elemento concreto, target,  que ya se encuentra en la lista
        // �COMPLETAR OPCIONAL!
        // Target ya viene de la lista o es copia ?
        //Si ya viene
        Node tmp; // anterior al target
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
