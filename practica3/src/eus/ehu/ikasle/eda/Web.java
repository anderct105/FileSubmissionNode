package eus.ehu.ikasle.eda;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Web implements Comparable<Web> {
/*
*
*
* for x € 1..NP
*
*   origen = random(nodos)
*   destino = random(nodos)
*   if origen != destino
*       b = conectados(origen,destino)
*
* */
    private int id;
    private String web;
    private ArrayList<Integer> websEnlazadas;


    public Web(int id, String web) {
        this.id = id;
        this.web = web;
        this.websEnlazadas = new ArrayList<>();
    }

    public Web(String web) {
        this.web = web;
        this.websEnlazadas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getWeb() {
        return web;
    }

    public List<Integer> getWebsEnlazadas() {
        return websEnlazadas;
    }


    /**
     * Añade la web dada por el parametro a la lista de webs relacionadas a dicha web
     */
    public void addWebRelacionada(Integer webRelacionada) {
        this.websEnlazadas.add(webRelacionada);
    }

    /**
     * Rellena la lista de palabras que tiene la web
     * y añade la web a la listas de webs de cada palabra que coincida
     */

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
