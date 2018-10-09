package eus.ehu.ikasle.eda;

import java.util.*;
import java.util.function.Consumer;

public class Diccionario {

    private List<Palabra> diccionario; //Se manteniene el orden de insercion
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
     * Devuelve la lista de palabras que contienen la web y carga las webs de esa palabra
     *
     * @return List de palabras que coinciden con el string.
     * Si no la encuentra no se añade a la lista
     */
    public List<Palabra> getPalabrasDelDiccionario(List<String> palabras) {
        List<Palabra> palabraList = new ArrayList<>();
        Palabra tmp1;
        for (String pStr : palabras) {
            tmp1 = this.getPalabraByString(pStr);
            if (tmp1 != null) { // si existe la palabra añadirá las webs de la palabra y viceversa
                this.cargarWebsRelacionadas(tmp1);
                palabraList.add(tmp1);
            }
        }
        return palabraList;
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

    public int getCantidad () {
        int cant = diccionario.size();
        return cant;
    }
}
