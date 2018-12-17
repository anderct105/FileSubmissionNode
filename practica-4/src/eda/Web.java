package eda;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Web implements Comparable<Web> {

    private int id;
    private String web;
    private List<Web> websEnlazadas; // arcos salientes
    private List<Web> arcosEntrantes; // arcos entrantes
    private HashSet palabras;
    private Double pR;


    public Web(int id, String web) {
        this.id = id;
        this.web = web;
        this.websEnlazadas = new ArrayList<>();
        this.arcosEntrantes = new ArrayList<>();
        this.palabras = new HashSet();
    }

    public Web(String web) {
        this.web = web;
        this.websEnlazadas = new ArrayList<>();
        this.arcosEntrantes = new ArrayList<>();
        this.palabras = new HashSet();
    }

    public double getpR() {
        return pR;
    }

    public void setpR(double pR) {
        this.pR = pR;
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

    /**
     * Añade la web dada por el parametro a la lista de webs relacionadas a dicha web
     */
    public void addWebRelacionada(Web webRelacionada) {
        this.websEnlazadas.add(webRelacionada);
    }

    public void addWebEntrante(Web webRelacionada) {
        this.arcosEntrantes.add(webRelacionada);
    }

    public boolean contains(Palabra palabra) {
        return this.web.contains(palabra.toString());
    }

    public void addPalabra(Palabra palabra) {
        this.palabras.add(palabra);
    }

    public boolean estaEnListaPalabras(Palabra palabra) {
        return this.palabras.contains(palabra); //O(1)
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
        return web.pR.compareTo(this.pR);
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

    public List<Web> getWebsEntrantes() {
        return this.arcosEntrantes;
    }
}
