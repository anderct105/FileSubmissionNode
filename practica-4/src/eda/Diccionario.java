package eda;

import java.util.ArrayList;
import java.util.List;


public class Diccionario {

    private List<Palabra> diccionario; //Se manteniene el orden de insercion

    private static Diccionario ourInstance = new Diccionario();

    public static Diccionario getInstance() {
        return ourInstance;
    }

    private Diccionario() {
        this.diccionario = new ArrayList<>();
    }


    public void addPalabra(Palabra palabra) {
        this.diccionario.add(palabra);
    }

    public void limpiar() {
        this.diccionario.clear();
    }

    public Palabra getPalabraByString(String palabra) {
        Palabra p = null;
        int index = this.diccionario.indexOf(new Palabra(palabra));
        if (index != -1) {
            p = this.diccionario.get(index);
        }

        return p;
    }


    /**
     * Asigna a cada palabra que contenga esa web a su lista de palabras y añade la web a la listas de webs de la palabra
     */
    public void fillPalabrasDeWeb(Web web) {
        this.diccionario.forEach(palabra -> {
            if (web.contains(palabra)) {
                web.addPalabra(palabra);
            }
        });
    }

}
