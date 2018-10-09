package eus.ehu.ikasle.eda;

import java.util.*;

public class Webs {

    private LinkedHashMap<Integer,Web> webs;//Se manteniene el orden de insercion
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
     * Realiza un merge-sort para ordenar alfabeticamente las webs
     * @return
     * List de webs ordenadas alfabeticamente
     * */
    public List<Web> getWebsOrdenadasMergeSort() {
        List<Web> lista = new ArrayList<>(this.webs.values());
        mergeSort((ArrayList<Web>) lista);
        return lista;
    }

    private ArrayList<Web> mergeSort(ArrayList<Web> whole) {
        ArrayList<Web> left = new ArrayList<>();
        ArrayList<Web> right = new ArrayList<>();
        int center;

        if (whole.size() == 1) {
            return whole;
        } else {
            center = whole.size()/2;
            // copy the left half of whole into the left.
            for (int i=0; i<center; i++) {
                left.add(whole.get(i));
            }

            //copy the right half of whole into the new arraylist.
            for (int i=center; i<whole.size(); i++) {
                right.add(whole.get(i));
            }

            // Sort the left and right halves of the arraylist.
            left  = mergeSort(left);
            right = mergeSort(right);

            // Merge the results back together.
            merge(left, right, whole);
        }
        return whole;
    }

    private void merge(ArrayList<Web> left, ArrayList<Web> right, ArrayList<Web> whole) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;

        // As long as neither the left nor the right ArrayList has
        // been used up, keep taking the smaller of left.get(leftIndex)
        // or right.get(rightIndex) and adding it at both.get(bothIndex).
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ( (left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
                whole.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }

        ArrayList<Web> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            // The left ArrayList has been use up...
            rest = right;
            restIndex = rightIndex;
        } else {
            // The right ArrayList has been used up...
            rest = left;
            restIndex = leftIndex;
        }

        // Copy the rest of whichever ArrayList (left or right) was not used up.
        for (int i=restIndex; i<rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
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

    public int getCantidad(){
        int cant = webs.size();
        return cant;
    }
}
