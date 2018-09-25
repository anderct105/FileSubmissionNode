package eus.ehu.ikasle.eda;

import java.util.*;

public class Webs {

    public HashMap<Integer, Web> getWebs() {
        return webs;
    }

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

    public void getWebsOrdenadas() {
        /*ArrayList<Web> lista = new ArrayList<Web>();
        for(Web w : webs.values()){
            lista.add(w);
        }*/
        List<Web> lista = (List<Web>)this.webs.values();
        int pivote = lista.size()/2;
        int inicio = 0;
        int fin = lista.size()-1;
        while (0 < fin && inicio < lista.size()-1) {
            while (inicio <= fin) {
                while (lista.get(inicio).getNombre().compareTo(lista.get(pivote).getNombre()) < 0) {
                    inicio++;
                }
                while (lista.get(fin).getNombre().compareTo(lista.get(pivote).getNombre()) > 0) {
                    fin--;
                }
                if (inicio <= fin) {
                    Web temp = lista.get(inicio);
                    lista.set(inicio, lista.get(fin));
                    lista.set(fin, temp);
                }
            }
        }
    }

}
