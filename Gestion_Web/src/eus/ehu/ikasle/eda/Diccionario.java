package eus.ehu.ikasle.eda;

import java.util.ArrayList;

public class Diccionario {
    private static Diccionario ourInstance = new Diccionario();
    private ListaPalabras palabras;


    public static Diccionario getInstance() {
        return ourInstance;
    }

    private Diccionario() {
        this.palabras = new ListaPalabras();
    }


    public void anadirPalabra(Palabra palabra){
        palabras.anadirPalabra(palabra);
    }

    public ListaPalabras getPalabrasRelacionadas(Web web) {
        return palabras.getPalabras(web);
    }

    public void cargarRelacionesPalabras(){

    }
}
