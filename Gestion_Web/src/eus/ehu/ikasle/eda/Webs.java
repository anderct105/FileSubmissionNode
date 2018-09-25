package eus.ehu.ikasle.eda;

import java.util.*;

public class Webs {

    public HashMap<Integer, Web> getWebs() {
        return webs;
    }

    private HashMap<Integer,Web> webs;

    private ArrayList<Integer> listaAnadidas;

    private static Webs ourInstance = new Webs();

    public static Webs getInstance() {
        return ourInstance;
    }

    private Webs() {
        this.webs = new HashMap<>();
        this.listaAnadidas=new ArrayList<>();
    }

    public ArrayList<Integer> getListaAnadidas(){
        return this.listaAnadidas;
    }

    public void addWeb(int id, Web web){
        this.webs.put(id,web);
    }

    public void anadirIdNuevo (int id, Web web){
        if (!this.webs.containsKey(id)) {
            this.addWeb(id, web);
            this.listaAnadidas.add(id);
        }
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

    public List<Web> getWebsOrdenadas() {
    }

}
