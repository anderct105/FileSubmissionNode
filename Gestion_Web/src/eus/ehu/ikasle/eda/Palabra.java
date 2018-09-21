package eus.ehu.ikasle.eda;

import java.util.ArrayList;

public class Palabra {

    private String palabra;
    private ArrayList<Web> webs; // webs que contienen dicha palabra

    public Palabra(String palabra){
        this.palabra = palabra;
    }

    public ArrayList<Web> getWebsRelacionadas(){
        return this.webs;
    }

}
