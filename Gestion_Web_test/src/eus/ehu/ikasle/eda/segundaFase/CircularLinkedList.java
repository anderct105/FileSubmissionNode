package eus.ehu.ikasle.eda.segundaFase;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CircularLinkedList<T extends Comparable<T>> implements ListADT<T> {

	// Atributos
	protected Node<T> last; // apuntador al ultimo
	protected String descr;  // descripci�n
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

	public T removeFirst() {
	// Elimina el primer elemento de la lista
        // Precondici�n: la lista tiene al menos un elemento
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		if(this.last.next != null) {
			this.last.next = this.last.next.next;
		}
		else{
			this.last = null;
		}
		return (T) this;//???para que devuelve algo
		//coste lineal; el mejor de los casos que el último apunte a null

	}

	public T removeLast() {
	// Elimina el �ltimo elemento de la lista
        // Precondici�n: la lista tiene al menos un elemento
			// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
			Iterator<T> itr = this.iterator();
			Node<T> n = null;
			if(!last.next.equals(last)) {
				while (!itr.next().equals(last)) {
					n = (Node<T>) itr.next(); //es necesario esta instruccion? como es circular el siguiente nunca es null
				}
				n.next = last.next;
			}
			else{
				last=null;
			}
			return null;
		   }


	public T remove(T elem) {
	//Elimina un elemento concreto de la lista
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Iterator<T> itr = this.iterator();
		Node<T> n1 = null;
		Node<T> n2 = this.last;
		while(!n2.equals(elem)){
			n1 = n2;
			n2 = (Node<T>) itr.next();
		}
		n1.next = n2.next;
		return null;
	}

	public T first() {
	//Da acceso al primer elemento de la lista
	      if (isEmpty())
	          return null;
	      else return last.next.data;
	}

	public T last() {
	//Da acceso al �ltimo elemento de la lista
	      if (isEmpty())
	          return null;
	      else return last.data;
	}

	public boolean contains(T elem) {
		Iterator<T> itr = this.iterator();
		Node<T> n = last;
		boolean esta = true;
		while(!n.equals(elem) && esta){
			n = (Node<T>) itr.next();
			if(n.equals(last)){ //si ha dado una vuelta para
				esta = false;
			}
		}
		return esta;


		   }

	public T find(T elem) {
	//Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no est�
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		return null;
	}

	public boolean isEmpty() 
	//Determina si la lista est� vac�a
	{ return last == null;};
	
	public int size() 
	//Determina el n�mero de elementos de la lista
	{
		Iterator<T>itr = this.iterator();
		Node<T> n = null;
		count = 0;
		while(itr.hasNext()){
			count++;
		}
		return count;};
	
	/** Return an iterator to the stack that iterates through the items . */ 
	   public Iterator<T> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> {
		   @Override
		   public boolean hasNext() {
			   return false;
		   }

		   @Override
		   public T next() {
			   return null;
		   }

		   @Override
		   public void remove() {

		   }

		   @Override
		   public void forEachRemaining(Consumer<? super T> consumer) {

		   }


		   // COMPLETAR EL CODIGO Y CALCULAR EL COSTE



	   } // private class
		
		
         public void visualizarNodos() {
			System.out.println(this.toString());
		}

		@Override
		public String toString() {
			String result = new String();
			Iterator<T> it = iterator();
			while (it.hasNext()) {
				T elem = it.next();
				result = result + "[" + elem.toString() + "] \n";
			}	
			return "SimpleLinkedList " + result + "]";
		}

}
