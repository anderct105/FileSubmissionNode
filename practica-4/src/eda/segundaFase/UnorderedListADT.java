package eda.segundaFase;

public interface UnorderedListADT<T> extends ListADT<T> {

    public void addToFront(T elem);
    // anade un elemento al comienzo

    public void addToRear(T elem);
    // anade un elemento al final

    public void addAfter(T elem, T target);
    // Anade elem detras de otro elemento concreto, target,  que ya se encuentra en la lista

}
