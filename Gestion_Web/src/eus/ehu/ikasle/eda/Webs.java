package eus.ehu.ikasle.eda;

import java.util.HashMap;

public class Webs {

    private HashMap<Integer,Web> webs;

    private static Webs ourInstance = new Webs();

    public static Webs getInstance() {
        return ourInstance;
    }

    private Webs() {
        this.webs = new HashMap<>();
    }

    public void addWeb(int id, Web web){
        this.webs.put(id,web);
    }

    public Web getWebById(int id){
        return this.webs.get(id);
    }

    public ListaWebs getWebsRelacionadas(Palabra palabra) {
        ListaWebs websRelacionadas = new ListaWebs();
        for (Web web :
                this.webs.values()) {
            if (web.contains(palabra)) {
                palabra.anadirWebRelacionada(web);
            }
        }
        return websRelacionadas;
    }

    public void cargarPalabras() {
        for (Web web: this.webs.values()){
            ListaPalabras palabras = Diccionario.getInstance().getPalabrasRelacionadas(web);
            palabras.anadirWebAPalabras(web);
            web.setPalabras(palabras);
        }
    }
}
