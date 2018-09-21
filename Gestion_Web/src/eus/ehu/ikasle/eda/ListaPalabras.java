package eus.ehu.ikasle.eda;

import java.util.ArrayList;
import java.util.List;

public class ListaPalabras {
    private static ListaPalabras ourInstance = new ListaPalabras();
    private ArrayList<Palabra> palabras;


    public static ListaPalabras getInstance() {
        return ourInstance;
    }

    private ListaPalabras() {
        this.palabras = new ArrayList<>();
    }


    public void anadirPalabra(Palabra palabra){

    }

}
