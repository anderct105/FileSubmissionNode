package eus.ehu.ikasle.eda;

import java.util.ArrayList;
import java.util.HashSet;
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
        this.diccionario.forEach(new Consumer<Palabra>() {
            @Override
            public void accept(Palabra palabra) {
                webs.websQueContienen(palabra);
            }
        });
    }

    public void addPalabra(Palabra palabra){
        this.diccionario.add(palabra);
    }

    public void limpiar() {
        this.diccionario.clear();
    }
}
