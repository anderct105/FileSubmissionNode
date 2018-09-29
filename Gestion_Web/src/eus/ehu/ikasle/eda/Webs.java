package eus.ehu.ikasle.eda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Webs {


    private HashMap<Integer,Web> webs;

    private ArrayList<Integer> anadidos; //comentar

    private static Webs ourInstance = new Webs();

    public HashMap<Integer, Web> getWebs() {
        return webs;
    }

    public static Webs getInstance() {
        return ourInstance;
    }

    private Webs() {
        this.webs = new HashMap<>();
        this.anadidos=new ArrayList<>();
    }

    public void addWeb(int id, Web web){
        this.webs.put(id,web);
        this.anadidos.add(id);
    }

    public Web devolverElemento(int id){  //comentar
        return this.webs.get(id);
    }

    public ArrayList<Integer> getAnadidos(){  //comentar
        return this.anadidos;
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

    public Web buscarWebByPalabras(List<Palabra> palabras) {
        Web w_aux=null;
        ListaPalabras lista_aux;
        for (Web w: webs.values()){
                if(w.contienePalabras(palabras)){
                    w_aux=w;
                }
        }
        return w_aux;
    }

}
