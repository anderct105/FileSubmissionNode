package eus.ehu.ikasle.eda.segundaFase;

import java.util.Iterator;

public class OrderedCircularLinkedList<T extends Comparable<T>> extends CircularLinkedList<T> implements OrderedListADT<T> {
	
	public void add(T elem){
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
        Node<T> actual = this.last;
        Node<T> n = new Node<>(elem);
        if (!isEmpty()) {
            do{
                actual = actual.next;
            }while (actual != last && actual.next.data.compareTo(elem) < 0);
            if (actual != last){
                n.next = actual.next;
                actual.next = n;
            }else{
                n.next = this.last.next;
                this.last.next = n;
                this.last = n;
            }
        }else{
            this.last = n;
            this.last.next = n;
        }
	}


}
