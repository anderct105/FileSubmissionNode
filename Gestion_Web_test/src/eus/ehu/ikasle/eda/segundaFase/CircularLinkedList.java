package eus.ehu.ikasle.eda.segundaFase;

import java.util.Iterator;

public class CircularLinkedList<T> implements ListADT<T> {

    // Atributos
    protected Node<T> last; // apuntador al ultimo
    protected String descr;  // descripcion
    protected int count;

    // Constructor
    public CircularLinkedList() {
        last = null;
        descr = "";
        count = 0;
    }

    public void setDescr(String nom) {
        descr = nom;
    }

    public String getDescr() {
        return descr;
    }

    public T removeFirst() {  //O(1)
        // Elimina el primer elemento de la lista
        // Precondicion: la lista tiene al menos un elemento
        T n = null;
        if (!isEmpty()) {
            if (this.last.next != last) {
                n = this.last.next.data;
                this.last.next = this.last.next.next;
            } else {
                n = this.last.data;
                this.last = null;
            }
            this.count--;
        }
        return n;
    }

    public T removeLast() {  //O(n) -> n = el numero de elementos de la lista
        // Elimina el ultimo elemento de la lista
        // Precondicion: la lista tiene al menos un elemento
        T result = null;
        if (!this.isEmpty()) {
            if (this.count == 1) {
                result = this.last.data;
                this.last = null;
            } else {
                Node<T> actual = this.last.next;
                while (actual.next != this.last) {
                    actual = actual.next;
                }
                actual.next = this.last.next;
                result = this.last.data;
                this.last = actual;
            }
            count--;
        }
        return result;
    }

    public T remove(T elem) {  //O(n) -> n = el numero de elementos de la lista
        //Elimina un elemento concreto de la lista
        T result = null;

        if (!isEmpty()) {
            Node<T> actual = this.last.next;
            Node<T> prev = this.last;
            boolean borrado = false;
            if (this.last.data.equals(elem)) {
                result = removeLast();
            } else if (actual.data.equals(elem)) {
                result = removeFirst();
            } else {
                prev = actual;
                actual = actual.next;
                while (!actual.equals(this.last) && !borrado) {
                    if (actual.data.equals(elem)) {
                        result = actual.data;
                        prev.next = actual.next;
                        borrado = true;
                    }
                    prev = actual;
                    actual = actual.next;
                }
                if (borrado) {
                    count--;
                }
            }
        }
        return result;
    }

    public T first() {  //O(1)
        //Da acceso al primer elemento de la lista
        if (isEmpty())
            return null;
        else return last.next.data;
    }

    public T last() {  //O(1)
        //Da acceso al ultimo elemento de la lista
        if (isEmpty())
            return null;
        else return last.data;
    }

    public boolean contains(T elem) { //coste O(n) y n = al numero de elementos de la lista
        boolean esta = false;
        if (this.last != null) {
            Node actual = this.last.next;
            if (this.last.data.equals(elem) || actual.data.equals(elem)) {
                esta = true;
            } else {
                actual = actual.next;
                while (!esta && actual != last) {
                    if (actual.data.equals(elem)) {
                        esta = true;
                    }
                    actual = actual.next;
                }
            }
        }
        return esta;
    }

    public T find(T elem) {  //coste O(n) y n = al numero de elementos de la lista
        //Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no est�
        Node<T> actual = last.next;
        T result = null;
        if (!isEmpty()) {
            if (actual.data.equals(elem)) {
                result = actual.data;
            }
            actual = actual.next;
            while (result == null && !actual.equals(this.last.next)) {
                if (actual.data.equals(elem)) {
                    result = actual.data;
                }
                actual = actual.next;
            }
        }
        return result;

    }

    public boolean isEmpty()
    //Determina si la lista esta vacia
    {
        return last == null;
    }

    ;

    public int size() {
        //Determina el numero de elementos de la lista
        return this.count;
    }


    /**
     * Return an iterator to the stack that iterates through the items .
     */
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<T> {

        private Node<T> actualNode;
        private int count;

        public ListIterator() {
            this.count = 0;
            if (hasNext()) {
                actualNode = CircularLinkedList.this.last.next;
            }
        }

        @Override
        public boolean hasNext() { // O(1)
            return this.count < CircularLinkedList.this.count;
        }

        @Override
        public T next() { //O(1)
            T result = null;
            if (hasNext()) {
                result = this.actualNode.data;
                this.actualNode = actualNode.next;
                count++;

            }
            return result;
        }
    } // private class


    public void visualizarNodos() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {  //coste O(n^2) y n = al numero de elementos de la lista
        String result = new String();
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            T elem = it.next();
            result = result + "[" + elem.toString() + "] ";
        }
        return "SimpleLinkedList [ " + result + "]";
    }

}
