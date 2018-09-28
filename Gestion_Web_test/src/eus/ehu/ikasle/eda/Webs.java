package eus.ehu.ikasle.eda;

import java.util.*;

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
            if (web.contains(palabra)){
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
        List<Web> lista = new ArrayList<>();
        this.webs.values().forEach(web -> lista.add(web));
        quickSort(lista,0,lista.size()-1);
        return lista;
    }

    private void quickSort(List<Web> webs ,int menor, int mayor) {
        int i = menor;
        int j = mayor-1;
        Web temp;
        Web valor = webs.get(mayor);
        do {
            for (;i < mayor && webs.get(i).getWeb().compareToIgnoreCase(valor.getWeb()) < 0 ; i++);
            for (; j > i && webs.get(j).getWeb().compareToIgnoreCase(valor.getWeb()) > 0;j--);
            if (i < j ){
                temp = webs.get(i);
                webs.set(i,webs.get(j));
                webs.set(j,temp);
                i++;
                j--;
            }
        }while(i < j);
        temp = webs.get(i);
        webs.set(i,valor);
        webs.set(mayor,temp);
        if (menor < i-1){
            quickSort(webs,menor,i-1);
        }
        if (i+1 < mayor){
            quickSort(webs,i+1,mayor);
        }
    }
}
