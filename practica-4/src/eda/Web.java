package eda;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Web implements Comparable<Web> {

    private int id;
    private String web;
    private List<Web> websAdjuntas; // arcos salientes
    private List<Web> websEntrantes; // arcos entrantes
    private Double pR; // Page Rank


    public Web(int id, String web) {
        this.id = id;
        this.web = web;
        this.websAdjuntas = new ArrayList<>();
        this.websEntrantes = new ArrayList<>();
    }

    public Web(String web) {
        this.web = web;
        this.websAdjuntas = new ArrayList<>();
        this.websEntrantes = new ArrayList<>();
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

    public List<Web> getWebsAdjuntas() {
        return websAdjuntas;
    }

    /**
     * Añade la web dada por el parametro a la lista de webs relacionadas a dicha web
     */
    public void addWebRelacionada(Web webRelacionada) {
        this.websAdjuntas.add(webRelacionada);
    }

    public void addWebEntrante(Web webRelacionada) {
        this.websEntrantes.add(webRelacionada);
    }


    @Override
    public String toString() {
        return this.web;
    }


    public int compareTo(Web web) {
        return web.pR.compareTo(this.pR);
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
        return this.websEntrantes;
    }
}
