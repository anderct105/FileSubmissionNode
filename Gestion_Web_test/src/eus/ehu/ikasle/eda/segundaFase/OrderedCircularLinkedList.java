package eus.ehu.ikasle.eda.segundaFase;

import java.util.Iterator;

public class OrderedCircularLinkedList<T extends Comparable<T>> extends CircularLinkedList<T> implements OrderedListADT<T> {
	
	public void add(T elem){  //coste O(n) y n = al numero de elementos de la lista
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
        Node<T> n = new Node<>(elem);
        if (!isEmpty()) {
            Node<T> prev = this.last;
            Node<T> actual = this.last.next;
            boolean anadido = false;
            do{
                if (actual.data.compareTo(elem) > 0){
                    n.next = actual;
                    prev.next = n;
                    anadido = true;
                }
                prev = actual;
                actual = actual.next;
            }while(!actual.equals(this.last.next) && !anadido);
            if (!anadido){
                n.next = this.last.next;
                this.last.next = n;
                this.last = n;
            }
        }else{
            this.last = n;
            this.last.next = n;
        }
        this.count++;
	}


}
