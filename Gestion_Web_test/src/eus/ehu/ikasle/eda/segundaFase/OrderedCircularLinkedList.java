package eus.ehu.ikasle.eda.segundaFase;

import java.util.Iterator;

public class OrderedCircularLinkedList<T extends Comparable<T>> extends CircularLinkedList<T> implements OrderedListADT<T> {
	
	public void add(T elem){
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
        Node<T> actual = this.last.next;
        while(actual != this.last && actual.data.compareTo(elem) < 0 );
        //TODO
	}


}
