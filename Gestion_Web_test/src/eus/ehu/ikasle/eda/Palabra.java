package eus.ehu.ikasle.eda;


import java.util.ArrayList;
import java.util.List;

public class Palabra {

    private String palabra;
    private List<Web> webs; // webs que tienen dicha palabra
    private boolean relacionado;

    public Palabra(String palabra) {
        this.palabra = palabra;
        this.webs = new ArrayList<>();
        this.relacionado = false;
    }

    public void addWebConPalabra(Web web) {
        this.webs.add(web);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Palabra palabra1 = (Palabra) o;
        return this.palabra.equalsIgnoreCase(palabra1.palabra);
    }

    @Override
    public String toString() {
        return this.palabra;
    }

    public List<Web> getWebs() {
        return webs;
    }

    public boolean isRelacionado() {
        return relacionado;
    }

    public void setRelacionado(boolean relacionado) {
        this.relacionado = relacionado;
    }
}
