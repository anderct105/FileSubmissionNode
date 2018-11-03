package eus.ehu.ikasle.eda.segundaFase;

import java.util.Iterator;

public interface ListADT<T> {

    public void setDescr(String nom);
// Actualiza el nombre de la lista

    public String getDescr();
// Devuelve el nombre de la lista

    public T removeFirst();
//Elimina el primer elemento de la lista

    public T removeLast();
//Elimina el ultimo elemento de la lista

    public T remove(T elem);
//Elimina un elemento concreto de la lista

    public T first();
//Da acceso al primer elemento de la lista

    public T last();
//Da acceso al ultimo elemento de la lista

    public boolean contains(T elem);
//Determina si la lista contiene un elemento concreto

    public T find(T elem);
//Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no esta

    public boolean isEmpty();
//Determina si la lista esta vacia

    public int size();
//Determina el numero de elementos de la lista

    public Iterator<T> iterator();

}
