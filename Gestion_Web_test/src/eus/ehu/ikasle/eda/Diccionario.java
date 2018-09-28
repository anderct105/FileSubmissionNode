package eus.ehu.ikasle.eda;

import java.util.*;
import java.util.function.Consumer;

public class Diccionario {

    private LinkedList<Palabra> diccionario; //A grandes tamaños sale mas rentable hashset por ser de O(1)
    //List<Palabra> diccionario;
    private static Diccionario ourInstance = new Diccionario();

    public static Diccionario getInstance() {
        return ourInstance;
    }

    private Diccionario() {
        this.diccionario = new LinkedList<>();
      //  this.diccionario = new ArrayList<>();
    }

    public  void cargarWebsRelacionadas(List<Palabra> palabras) {
        final Webs webs = Webs.getInstance();
        List<Palabra> tmp = new ArrayList<>();
        for (Palabra palabra: palabras
             ) {
            if (this.diccionario.contains(palabra)){
                tmp.add(palabra);
            }
        }
        palabras.parallelStream().forEach(palabra -> {
            webs.websQueContienen(palabra);
        } );
    }

    public  void cargarWebsRelacionadas(Palabra palabra) {
        if (!palabra.isRelacionado()){
            Webs.getInstance().websQueContienen(palabra);
            palabra.setRelacionado(true);
        }
    }

    public void addPalabra(Palabra palabra){
        this.diccionario.add(palabra);
    }

    public void limpiar() {
        this.diccionario.clear();
    }

    public Palabra getPalabraByString(String palabra) {
        Palabra p = null;

        Iterator<Palabra> palabraIterator = this.diccionario.iterator();
        Palabra tmp = null;

        while(palabraIterator.hasNext() &&
                !(tmp = palabraIterator.next()).toString().equalsIgnoreCase(palabra));

        if (tmp.toString().equalsIgnoreCase(palabra)){
            p = tmp;
        }

        return p;
    }

    public void fillPalabrasDeWeb(Web web) {
        this.diccionario.forEach(palabra -> {
            if (web.contains(palabra)){
                web.addPalabra(palabra);
                palabra.addWebConPalabra(web);
            }
        });
    }
}
