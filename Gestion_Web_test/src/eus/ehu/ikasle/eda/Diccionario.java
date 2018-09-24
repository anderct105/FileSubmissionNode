package eus.ehu.ikasle.eda;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Diccionario {

    private HashSet<Palabra> diccionario; //A grandes tamaños sale mas rentable hashset por ser de O(1)
    //List<Palabra> diccionario;
    private static Diccionario ourInstance = new Diccionario();

    public static Diccionario getInstance() {
        return ourInstance;
    }

    private Diccionario() {
        this.diccionario = new HashSet<>();
      //  this.diccionario = new ArrayList<>();
    }

    public  void cargarWebsRelacionadas() {
        final Webs webs = Webs.getInstance();
        this.diccionario.parallelStream().forEach(palabra -> webs.websQueContienen(palabra));
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
}
