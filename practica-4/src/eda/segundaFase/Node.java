package eda.segundaFase;

public class Node<T> {
    public T data;            // dato del nodo
    public Node<T> next;    // puntero al siguiente nodo de la lista
    // -------------------------------------------------------------

    public Node(T dd)        // constructor
    {
        data = dd;
        next = null;

    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }
}


