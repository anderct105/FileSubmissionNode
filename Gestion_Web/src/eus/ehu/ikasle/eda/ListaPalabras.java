package eus.ehu.ikasle.eda;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ListaPalabras {

    private HashSet<Palabra> palabras;


    public ListaPalabras(){
        this.palabras = new HashSet<>();
    }

    public void anadirPalabra(Palabra palabra){
        this.palabras.add(palabra);
    }


    public void anadirWebAPalabras(Web web) {
        Iterator<Palabra> it = palabras.iterator();
        while(it.hasNext()){
            it.next().anadirWebRelacionada(web);
        }
    }

    public ListaPalabras getPalabras(Web web) {
        ListaPalabras lp = new ListaPalabras();
        Iterator<Palabra> it = palabras.iterator();
        while(it.hasNext()){
            Palabra p = it.next();
            if (web.contains(p)){
                lp.anadirPalabra(p);
                p.anadirWebRelacionada(web);
            }
        }
        return lp;
    }
}
