package eus.ehu.ikasle.eda;

import java.util.*;
import java.util.function.Consumer;

public class Diccionario {

    private List<Palabra> diccionario; //A grandes tamaños sale mas rentable hashset por ser de O(1)
    //List<Palabra> diccionario;
    private static Diccionario ourInstance = new Diccionario();

    public static Diccionario getInstance() {
        return ourInstance;
    }

    private Diccionario() {
        this.diccionario = new ArrayList<>();
      //  this.diccionario = new ArrayList<>();
    }

    /*public  void cargarWebsRelacionadas(List<Palabra> palabras) {
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
    }*/
    /**
    *
     * Carga las webs que contienen la palabra y añade esa palabra a la webs
     *
     * */
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
        int index = this.diccionario.indexOf(new Palabra(palabra));
        if (index != -1){
            p = this.diccionario.get(index);
        }

        return p;
    }

    /**
     * Asigna a cada palabra que contenga esa web a su lista de palabras y añade la web a la listas de webs de la palabra
     * */
    public void fillPalabrasDeWeb(Web web) {
        this.diccionario.forEach(palabra -> {
            if (web.contains(palabra)){
                web.addPalabra(palabra);
                palabra.addWebConPalabra(web);
            }
        });
    }

    public int getCantidad (){
        return this.diccionario.size();
    }
}
