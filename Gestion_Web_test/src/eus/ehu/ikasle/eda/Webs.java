package eus.ehu.ikasle.eda;

import java.util.*;

public class Webs {

    private LinkedHashMap<Integer,Web> webs;
    private List<Web> listaAnadidas;
    private static int lastId;
    
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

    /**
     * @para*m  web
     * Añade la web (con el ultimo id disponible) solo si no se encuentra ya en la lista
     * */
    public void addWebNueva(Web web){
        if (!this.webs.containsValue(web)){
            web.setId(++lastId);
            web.fillPalabras();
            this.addWeb(web);
            this.listaAnadidas.add(web);
        }
    }

    /**
     * @param id
     * id de la web a buscar
     * @return
     * la web o null si no se ha encontrado
     * */
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

    /**
     * Realiza una ordenacion mediante Collections.sort
     * @return
     * List de webs ordenadas alfabeticamente
     * */
    public List<Web> getWebsOrdenadas() {
        Collection<Web> webs =  this.webs.values();
        List<Web> websList = new ArrayList<>(webs);
        Collections.sort(websList, Web::compareTo);
        return websList;
    }

    public List<Web> getListaAnadidas(){
        return this.listaAnadidas;
    }

    /**
     * Realiza un randomized quick sort para ordenar alfabeticamente las webs
     * @return
     * List de webs ordenadas alfabeticamente
     * */
    public List<Web> getWebsOrdenadasQuickSort() {
        List<Web> lista = new ArrayList<>(this.webs.values());
        quicksort((ArrayList<Web>) lista,0,lista.size()-1);
        return lista;
    }

    private static void swap(ArrayList<Web> elements, int i, int j){
        //Method to swap 2 elements in an arraylist
        Web temp= elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }

    private static int partition(ArrayList<Web> elements, int beg, int end){

        //Get a random pivot between beg and end
        int random=beg + ((int)Math.random()*(elements.size()))/(end-beg+1);

        //New position of pivot element
        int last=end;

        //Move the pivot element to right edge of the array
        swap(elements, random, end);
        end--;

        while(beg<=end){
            if(elements.get(beg).compareTo(elements.get(last)) < 0) beg++; //Accumulate smaller elements to the left
            else {
                swap(elements, beg, end);
                end--;
            }
        }

        //Move pivot element to its correct position
        swap(elements, beg, last);

        return beg;
    }

    private static void quicksort(ArrayList<Web> elements, int beg, int end){
        if(beg>=end) return;
        if(beg<0) return;
        if(end>elements.size()-1) return;

        int pivot = partition(elements, beg, end);
        quicksort(elements, beg, pivot-1);
        quicksort(elements, pivot+1, end);
    }

    public List<Web> ordenarQuicksort(ArrayList<Web> webs) {
        quicksort(webs,0,webs.size()-1);
        return webs;
    }

    public void loadLastId() {
        int max = -1;
        for (int id :
                this.webs.keySet()) {
            if (id > max){
                max = id;
            }
        }
        Webs.lastId = max;
    }
}
