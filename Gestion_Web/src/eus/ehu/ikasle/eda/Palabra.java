package eus.ehu.ikasle.eda;

import java.util.ArrayList;

public class Palabra {

    private String palabra;
    private ListaWebs webs; // webs que contienen dicha palabra

    public Palabra(String palabra){
        this.palabra = palabra;
        this.webs = new ListaWebs();
    }

    public ListaWebs getWebsRelacionadas(){
        return this.webs;
    }

    public void anadirWebRelacionada(Web web){
        this.webs.anadirWeb(web);
    }

    public void setWebsRelacionadas(ListaWebs webs){
        this.webs = webs;
    }

    public String getPalabraString() {
        return this.palabra;
    }

    @Override
    public boolean equals(Object p) {
        return p instanceof Palabra && this.palabra.equals(((Palabra) p).getPalabraString());
    }
}
