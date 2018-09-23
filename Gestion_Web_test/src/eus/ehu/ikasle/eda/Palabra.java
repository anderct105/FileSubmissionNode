package eus.ehu.ikasle.eda;

import java.util.ArrayList;
import java.util.List;

public class Palabra {

    private String palabra;
    private List<Web> webs; // webs que tienen dicha palabra

    public Palabra(String palabra){
        this.palabra = palabra;
        this.webs = new ArrayList<>();
    }

    public void addWebConPalabra(Web web){
        this.webs.add(web);
    }

    @Override
    public String toString() {
        return this.palabra;
    }
}
