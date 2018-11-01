package eus.ehu.ikasle.eda.segundaFase;

public class OrderedCircularLinkedList<T extends Comparable<T>> extends CircularLinkedList<T> implements OrderedListADT<T> {

    public void add(T elem) {  //coste O(n) y n = al numero de elementos de la lista
        // COMPLETAR EL CODIGO Y CALCULAR EL COSTE
        Node<T> n = new Node<>(elem);
        if (!isEmpty()) {
            if (this.last.data.compareTo(elem) < 0) {
                n.next = this.last.next;
                this.last.next = n;
                this.last = n;
            } else {
                Node<T> prev = this.last;
                Node<T> actual = this.last.next;
                boolean anadido = false;
                if (actual.data.compareTo(elem) > 0) {
                    n.next = actual;
                    prev.next = n;
                } else {
                    prev = actual;
                    actual = actual.next;
                    while (!actual.equals(this.last.next) && actual.data.compareTo(elem) < 0) {
                        prev = actual;
                        actual = actual.next;
                    }
                    prev.next = n;
                    n.next = actual;
                }
            }
        } else {
            this.last = n;
            this.last.next = n;
        }
        this.count++;
    }


}
