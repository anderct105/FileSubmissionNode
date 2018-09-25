package eus.ehu.ikasle.eda;

import java.util.*;
import java.util.function.BiConsumer;

public class Webs {

    private LinkedHashMap<Integer,Web> webs;
    private List<Integer> listaAnadidas;

    private static Webs ourInstance = new Webs();

    public static Webs getInstance() {
        return ourInstance;
    }

    private Webs() {
        this.webs = new LinkedHashMap<>();
        this.listaAnadidas = new ArrayList<>();
    }


    public void addWeb(Web web){
        this.webs.put(web.getId(),web);
    }

    public void anadirIdNuevo (Web web){
        if (!this.webs.containsKey(web.getId())) {
            this.addWeb(web);
            this.listaAnadidas.add(web.getId());
        }
    }

    public Web getWebById(int id){
        return this.webs.get(id);
    }

    public void limpiar(){
        this.webs.clear();
    }

    public void websQueContienen(Palabra palabra) {
        webs.forEach((integer, web) -> {
            if (web.constains(palabra)){
                web.addPalabra(palabra);
                palabra.addWebConPalabra(web);
            }
        });
    }

    public Web getWebByFullName(String name) {
        Web result = null;

        Collection<Web> websCollection = this.webs.values();
        //busqueda desordenada ¿?¿?¿??¿
        Iterator<Web> itr = this.webs.values().iterator();
        Web tmp = null;
        // mientras tenga siguiente y ese no tenga el mismo nombre que estoy buscando , sigue
        while(itr.hasNext() && !(tmp = itr.next()).getWeb().equalsIgnoreCase(name));
        if (tmp != null && tmp.getWeb().equalsIgnoreCase(name)){
            result = tmp;
        }
        return result;
    }

    public List<Web> getWebsOrdenadas() {
        Collection<Web> webs =  this.webs.values();
        List<Web> websList = new ArrayList<>(webs);
        Collections.sort(websList, (web, t1) -> web.getWeb().compareToIgnoreCase(t1.getWeb()));
        return  websList;
    }

    public List<Integer> getListaAnadidas(){
        return this.listaAnadidas;
    }

    public List<Web> getWebsOrdenadasQuickSort() {
        //List<Web> lista = new ArrayList<>();
        //this.webs.values().forEach(web -> lista.add(web));
        ArrayList<Web> lista = new ArrayList<Web>(){{
            add(new Web(1,"a"));
            add(new Web(1,"c"));
            add(new Web(1,"d"));
            add(new Web(1,"b"));
            add(new Web(1,"e"));
        }};
        int fin=lista.size()-1;
        int inicio=0;
        int pivote=fin;
        boolean primero=false;
        boolean cambio=false;
        while(pivote!=(lista.size()-1)||!primero) {
            primero=true;
            while (fin >= inicio) {
                while (lista.get(inicio).getWeb().compareTo(lista.get(pivote).getWeb()) < 0) {
                    inicio++;
                }
                while (lista.get(fin).getWeb().compareTo(lista.get(pivote).getWeb()) > 0) {
                    fin--;
                }
                //if (inicio != fin) {
                    Web tmp;
                    tmp = lista.get(inicio);
                    lista.set(inicio, lista.get(fin));
                    lista.set(fin, tmp);

                if(fin>1&&!cambio) {
                    pivote = --fin;
                    inicio = 0;

                }
                else{
                    pivote=lista.size()-1;      //salgo
                    fin=(lista.size()-1);
                    inicio++;
                    cambio=true;
                }
            }
        }
        return lista;
    }
}
