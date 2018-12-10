package eda;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class Webs {

    private LinkedHashMap<Integer, Web> webs;//Se manteniene el orden de insercion
    private List<Web> listaAnadidas;
    private static int lastId;
    private static double d = 0.85;
    private static double dif = 0.001;

    private static Webs ourInstance = new Webs();

    public static Webs getInstance() {
        return ourInstance;
    }

    private Webs() {
        this.webs = new LinkedHashMap<>();
        this.listaAnadidas = new ArrayList<>();
    }


    public void addWeb(Web web) {
        this.webs.put(web.getId(), web);
    }

    /**
     * @para*m web
     * Añade la web (con el ultimo id disponible) solo si no se encuentra ya en la lista
     */
    public boolean addWebNueva(Web web) {
        boolean insertado = false;
        if (!this.webs.containsValue(web)) {
            web.setId(++lastId);
            web.fillPalabras();
            this.addWeb(web);
            this.listaAnadidas.add(web);
            insertado = true;
        }
        return insertado;
    }

    /**
     * @param id id de la web a buscar
     * @return la web o null si no se ha encontrado
     */
    public Web getWebById(int id) {
        return this.webs.get(id);
    }

    public void limpiar() {
        this.webs.clear();
    }

    public void websQueContienen(Palabra palabra) {
        webs.forEach((integer, web) -> {
            if (web.contains(palabra)) {
                web.addPalabra(palabra);
                palabra.addWebConPalabra(web);
            }
        });
    }

    public Web getWebByFullName(String name) {
        Web result = null;
        Iterator<Web> itr = this.webs.values().iterator();
        Web tmp = null;
        // mientras tenga siguiente y ese no tenga el mismo nombre que estoy buscando , sigue
        while (itr.hasNext() && !(tmp = itr.next()).getWeb().equalsIgnoreCase(name)) ;
        if (tmp != null && tmp.getWeb().equalsIgnoreCase(name)) {
            result = tmp;
        }
        return result;
    }

    public List<Web> getListaAnadidas() {
        return this.listaAnadidas;
    }

    /**
     * Realiza un merge-sort para ordenar alfabeticamente las webs
     *
     * @return List de webs ordenadas alfabeticamente
     */
    public List<Web> getWebsOrdenadasMergeSort() {
        List<Web> lista = new ArrayList<>(this.webs.values());
        mergeSort((ArrayList<Web>) lista);
        return lista;
    }

    private ArrayList<Web> mergeSort(ArrayList<Web> lista) {
        ArrayList<Web> listaIzquierda = new ArrayList<>();
        ArrayList<Web> listaDerecha = new ArrayList<>();
        int center;

        if (lista.size() == 1) {
            return lista;
        } else {
            center = lista.size() / 2;

            for (int i = 0; i < center; i++) {
                listaIzquierda.add(lista.get(i));
            }


            for (int i = center; i < lista.size(); i++) {
                listaDerecha.add(lista.get(i));
            }


            listaIzquierda = mergeSort(listaIzquierda);
            listaDerecha = mergeSort(listaDerecha);


            merge(listaIzquierda, listaDerecha, lista);
        }
        return lista;
    }

    private void merge(ArrayList<Web> listaIzquierda, ArrayList<Web> listaDerecha, ArrayList<Web> lista) {
        int izqIndex = 0;
        int drchIndex = 0;
        int listaIndex = 0;


        while (izqIndex < listaIzquierda.size() && drchIndex < listaDerecha.size()) {
            if ((listaIzquierda.get(izqIndex).compareTo(listaDerecha.get(drchIndex))) < 0) {
                lista.set(listaIndex, listaIzquierda.get(izqIndex));
                izqIndex++;
            } else {
                lista.set(listaIndex, listaDerecha.get(drchIndex));
                drchIndex++;
            }
            listaIndex++;
        }

        ArrayList<Web> rest;
        int restIndex;
        if (izqIndex >= listaIzquierda.size()) {
            rest = listaDerecha;
            restIndex = drchIndex;
        } else {
            rest = listaIzquierda;
            restIndex = izqIndex;
        }

        for (int i = restIndex; i < rest.size(); i++) {
            lista.set(listaIndex, rest.get(i));
            listaIndex++;
        }
    }

    public void loadLastId() {
        int max = -1;
        for (int id :
                this.webs.keySet()) {
            if (id > max) {
                max = id;
            }
        }
        Webs.lastId = max;
    }

    public int getCantidad() {
        int cant = webs.size();
        return cant;
    }

    public void limparAnadidas() {
        this.listaAnadidas.clear();
    }


    public HashMap<String,Double> pageRank(){
        HashMap<String,Double> l = new HashMap();
        int N = webs.size();
        double tmp =  (double)1/N;
        webs.forEach((v,k)->l.put(k.getWeb(),tmp));
        String inicial = "A";
        double actualPageRank = 0d;
        double previousPageRank = 0d;
        double sumPageRank =0d;
        do{
            previousPageRank = actualPageRank;
            actualPageRank = 0;
           for (Web w1 : webs.values()) {
               sumPageRank = 0.0;
               for (Web w2 : w1.getWebsEntrantes()){
                   sumPageRank += (double) l.get(w2.getWeb()) / (w2.getWebsEnlazadas().size());
               }
               w1.setpR((1-d)/N+d*sumPageRank);
               l.replace(w1.getWeb(), w1.getpR());
               actualPageRank +=Math.abs(tmp - w1.getpR());
           }
       }while(Math.abs(actualPageRank-previousPageRank) > Webs.dif);
        return l;
    }

    public ArrayList<Web> buscar (String palabraClave){
        ArrayList<String> ls = new ArrayList<String>();
        ls.add(palabraClave);
        List<Web> l = GestionWeb.getInstance().buscarWebsPorPalabras((List<String>)ls);
        return this.mergeSort((ArrayList<Web>) l);
    }

    public ArrayList<Web> buscar (String palabra1, String palabra2){ // n² log n
        ArrayList<Web> resultado = new ArrayList<>();

        for (Web web : Webs.getInstance().getWebsOrdenadasMergeSort() ){ // n log n
            if (web.estaEnListaPalabras(new Palabra(palabra1)) && web.estaEnListaPalabras(new Palabra(palabra2))){
                resultado.add(web);
            }
        }

        return resultado;
    }

}
