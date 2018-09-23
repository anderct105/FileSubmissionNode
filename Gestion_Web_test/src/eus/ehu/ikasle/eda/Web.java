package eus.ehu.ikasle.eda;

import java.util.ArrayList;
import java.util.List;

public class Web {

    private int id;
    private String web;
    private List<Web> websEnlazadas;
    private List<Palabra> palabras;


    public Web(int id, String web){
        this.id = id;
        this.web = web;
        this.websEnlazadas = new ArrayList<>();
        this.palabras = new ArrayList<>();
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

    public List<Palabra> getPalabras() {
        return palabras;
    }

    public void addWebRelacionada(Web webRelacionada) {
        this.websEnlazadas.add(webRelacionada);
    }

    public boolean constains(Palabra palabra) {
        return this.web.contains(palabra.toString());
    }

    public void addPalabra(Palabra palabra) {
        this.palabras.add(palabra);
    }

    public boolean estaEnListaPalabras(Palabra palabra){
        return this.palabras.contains(palabra);
    }

    @Override
    public String toString() {
        return "Web{" +
                "id=" + id +
                ", web='" + web + '\'' +
                '}';
    }
}
