package eda;

import eus.ehu.ikasle.eda.segundaFase.UnorderedCircularLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Web implements Comparable<Web> {

    private int id;
    private String web;
    private List<Web> websEnlazadas;
    private UnorderedCircularLinkedList<Palabra> palabras;


    public Web(int id, String web) {
        this.id = id;
        this.web = web;
         this.websEnlazadas = new ArrayList<>();
        this.palabras = new UnorderedCircularLinkedList<>();
    }

    public Web(String web) {
        this.web = web;
        this.websEnlazadas = new ArrayList<>();
        this.palabras = new UnorderedCircularLinkedList<>();
    }

    public int getId() {
        return id;
    }

    public String getWeb() {
        return web;
    }

    public List<Web> getWebsEnlazadas() {
        return websEnlazadas;
    }

    public UnorderedCircularLinkedList<Palabra> getPalabras() {
        return palabras;
    }

    /**
     * Añade la web dada por el parametro a la lista de webs relacionadas a dicha web
     */
    public void addWebRelacionada(Web webRelacionada) {
        this.websEnlazadas.add(webRelacionada);
    }

    public boolean contains(Palabra palabra) {
        return this.web.contains(palabra.toString());
    }

    public void addPalabra(Palabra palabra) {
        this.palabras.addToRear(palabra);
    }

    public boolean estaEnListaPalabras(Palabra palabra) {
        return this.palabras.contains(palabra);
    }

    /**
     * Rellena la lista de palabras que tiene la web
     * y añade la web a la listas de webs de cada palabra que coincida
     */
    public void fillPalabras() {
        Diccionario.getInstance().fillPalabrasDeWeb(this);
    }

    @Override
    public String toString() {
        return this.web;
    }


    public int compareTo(Web web) {
        return this.web.compareTo(web.web);
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Web web1 = (Web) o;
        return web.equalsIgnoreCase(web1.web);
    }

    @Override
    public int hashCode() {
        return Objects.hash(web);
    }
}
