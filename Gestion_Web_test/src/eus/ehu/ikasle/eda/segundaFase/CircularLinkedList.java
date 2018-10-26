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

	public T removeFirst() {  //O(1)
	// Elimina el primer elemento de la lista
        // Precondici�n: la lista tiene al menos un elemento
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		T n= null;
		if(this.last.next != last) {
			n = this.last.next.data;
			this.last.next = this.last.next.next;
		}
		else{
			this.last = null;
		}
		return n;
	}

	public T removeLast() {  //O(n) -> n = el número de elementos de la lista
		// Elimina el �ltimo elemento de la lista
        // Precondici�n: la lista tiene al menos un elemento
			// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
			Iterator<T> itr = this.iterator();
			Node<T> n = null;
			T last_aux = last.data;
			if(!last.next.equals(last)) {
				while (!itr.next().equals(last)) {
					n = (Node<T>) itr.next(); //es necesario esta instruccion? como es circular el siguiente nunca es null
				}
				n.next = last.next;
			}
			else{
				last=null;
			}
			return last_aux;
		   }

	public T remove(T elem) {  //O(n) -> n = el número de elementos de la lista
	//Elimina un elemento concreto de la lista
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> actual = this.last;
		Node<T> removed = null;
		boolean encontrado = false;
		do {
		    if (actual.next.data.equals(elem)){
		        encontrado = true;
		        removed = actual.next;
            }else{
                actual = actual.next;
            }
        }while(actual != last && !encontrado);
		if (encontrado){
            actual.next = actual.next.next;
        }

		return removed.data;
	}

	public T first() {  //O(1)
	//Da acceso al primer elemento de la lista
	      if (isEmpty())
	          return null;
	      else return last.next.data;
	}

	public T last() {  //O(1)
	//Da acceso al �ltimo elemento de la lista
	      if (isEmpty())
	          return null;
	      else return last.data;
	}

	public boolean contains(T elem) { //coste O(n) y n = al numero de elementos de la lista
		/*Iterator<T> itr = this.iterator();
		Node<T> n = last;
		boolean esta = true;
		while(!n.equals(elem) && esta){
			n = (Node<T>) itr.next();
			if(itr.hasNext()){ //si ha dado una vuelta para
				esta = false;
			}
		}*/
		boolean esta = false;
		Node actual = this.last.next;
		do{
		    if(actual.data.equals(elem)){
		        esta = true;
            }
            actual = actual.next;
        }while(!esta && actual != last.next );
		return esta;
	}

	public T find(T elem) {  //coste O(n) y n = al numero de elementos de la lista
	//Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no est�
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
        Node<T> actual= last.next, result = null;
        /*boolean esta = false;
        do{
            if(actual.data.equals(elem)){
                esta = true;
                result = actual;
            }
            actual = actual.next;
        }while(actual != last.next && !esta);
        if(!esta){
            actual = null;
        }
		return result.data;
        */
        while((actual = actual.next) != this.last && !actual.data.equals(elem));
        if (!actual.data.equals(elem)){
            actual = null;
        }

        return (actual != null)?actual.data:null;

	}

	public boolean isEmpty() 
	//Determina si la lista est� vac�a
	{ return last == null;};
	
	public int size() {
        //Determina el n�mero de elementos de la lista
        return this.count;
    }

	
	/** Return an iterator to the stack that iterates through the items . */ 
	   public Iterator<T> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> {

	       private Node<T> actualNode;
	       private int count;
	       public ListIterator(){
	           actualNode = CircularLinkedList.this.last.next;
	           this.count = 0;
           }

		   @Override
		   public boolean hasNext() { // O(1)
		       return this.count < CircularLinkedList.this.count;
		   }

		   @Override
		   public T next() { //O(1)
	           T result = this.actualNode.data;

	           this.actualNode = actualNode.next;
	           count++;

	           return result;
		   }
	   } // private class
		
		
         public void visualizarNodos() {
			System.out.println(this.toString());
		}

		@Override
		public String toString() {  //coste O(n) y n = al numero de elementos de la lista
			String result = new String();
			Iterator<T> it = iterator();
			while (it.hasNext()) {
				T elem = it.next();
				result = result + "[" + elem.toString() + "] \n";
			}	
			return "SimpleLinkedList " + result + "]";
		}

}
