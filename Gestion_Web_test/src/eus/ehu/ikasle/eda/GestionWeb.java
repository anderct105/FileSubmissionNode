package eus.ehu.ikasle.eda;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GestionWeb {
    private static GestionWeb ourInstance = new GestionWeb();

    public static final String INDEX_TEST_FILE_PATH = System.getProperty("user.dir") + File.separator + "index_prueba";
    public static final String RELATIONS_TEST_FILE_PATH = System.getProperty("user.dir") + File.separator + "relaciones_prueba";

    public static final String INDEX_FILE_PATH = System.getProperty("user.dir") + File.separator + "index_grande";
    public static final String RELATIONS_FILE_PATH = System.getProperty("user.dir") + File.separator + "pld-arcs-1-N_grande";

    public static final String SMALL_INDEX_FILE_PATH = System.getProperty("user.dir") + File.separator + "smallindex";
    public static final String SMALL_RELATIONS_FILE_PATH = System.getProperty("user.dir") + File.separator + "smallpld-arcs-1-N";

    public static final String WORDS_FILE_PATH = System.getProperty("user.dir") + File.separator + "words.txt";

    public static GestionWeb getInstance() {
        return ourInstance;
    }

    private GestionWeb() {
    }

    public static void nuevaWeb(String nombre) {
        Webs.getInstance().addWebNueva(new Web(nombre));
    }

    public void cargarDatos() {
        Fichero f = Fichero.getInstance();
        f.cargarWebs(GestionWeb.INDEX_FILE_PATH);
        f.cargarRelaciones(GestionWeb.RELATIONS_FILE_PATH);
        f.cargarDiccionario(GestionWeb.WORDS_FILE_PATH);
    }

    public Web getWebByFullName(String name) {

        return Webs.getInstance().getWebByFullName(name);
    }

    /**
     * @return List de webs que contienen las palabras
     * si una palabra no existe devolvera la lista vacia
     */
    public List<Web> buscarWebsByPalabras(List<String> palabras) {
        List<Web> resultado = new ArrayList<>();
        if (palabras.size() > 0) { // si la lista tiene palabras
            Diccionario dic = Diccionario.getInstance();
            Palabra tmp1;
            List<Palabra> palabrasList = getPalabrasDelDiccionario(palabras); // rellena la lista con las palabras que se han encontrado o si no con null
            if (palabras.size() == palabrasList.size()) { // si tienen el mismo tamaño significa que se han encontrado todas la palabras
                //solo devolvera el resultado si se han encontrado todas las palabras
                Palabra primera = palabrasList.get(0);
                Palabra tmp;
                if (primera != null) {
                    if (palabrasList.size() > 1) { // Si tiene mas palabras
                        boolean contenidas;
                        for (Web web : primera.getWebs()) {
                            contenidas = true;
                            for (int i = 1; i < palabrasList.size() && contenidas; i++) {
                                tmp = palabrasList.get(i);
                                if (!web.estaEnListaPalabras(tmp)) {
                                    contenidas = false;
                                }
                            }
                            if (contenidas) {
                                resultado.add(web);
                            }
                        }
                    } else {
                        resultado = primera.getWebs();
                    }
                } else {
                    System.out.println("Palabra no encontrada");
                }
            }
        }
        return resultado;
    }

    /**
     * Devuelve la lista de palabras que contienen la web y carga las webs de esa palabra
     *
     * @return List de palabras que coinciden con el string.
     * Si no la encuentra no se añade a la lista
     */
    private List<Palabra> getPalabrasDelDiccionario(List<String> palabras) {
        List<Palabra> palabraList = new ArrayList<>();
        Palabra tmp1;
        Diccionario dic = Diccionario.getInstance();
        for (String pStr : palabras) {
            tmp1 = dic.getPalabraByString(pStr);
            if (tmp1 != null) { // si existe la palabra añadirá las webs de la palabra y viceversa
                dic.cargarWebsRelacionadas(tmp1);
                palabraList.add(tmp1);
            }
        }
        return palabraList;
    }

    /*public List<Web> buscarWebsByPalabrasRetainAll(List<String> palabras) {
        // Devuelve una lista vacia si cualquiera de las palabras no estan en el diccionario
        List<Web> resultado = new ArrayList<>();
        Diccionario dic = Diccionario.getInstance();
        if (palabras.size() > 0) {
            Palabra tmp1;
            List<Palabra> palabrasList = getPalabrasDelDiccionario(palabras);
            Palabra tmp = palabrasList.get(0);
            if (tmp != null) {
                resultado = tmp.getWebs();
                if (palabrasList.size() > 1) {
                    for (int i = 1; i < palabrasList.size() && !resultado.isEmpty(); i++) {
                        tmp = palabrasList.get(i);
                        //Si no encuentra alguna de las palabras la busqueda se cancela devolviendo un array vacio
                        if (tmp != null) {
                            resultado.retainAll(tmp.getWebs());
                        } else {
                            resultado = new ArrayList<>();
                        }
                    }
                }
            } else {
                System.out.println("Error palabra no encontrada, se devolvera la lista vacia");
            }

        }

        return resultado;
    }*/

    public List<Web> getWebsOrdenadas() {
        return Webs.getInstance().getWebsOrdenadas();
    }

    public List<Web> getWebsOrdenadasQuickSort() {
        return Webs.getInstance().getWebsOrdenadasQuickSort();
    }
    public List<Web> getWebsOrdenadasMergeSort() {
        return Webs.getInstance().getWebsOrdenadasMergeSort();
    }

    /**
     * Añade las nuevas webs al archivo sin sobreescribir el fichero
     * */
    public void guardarWebsAnadidas() {
        Fichero.getInstance().escribirWebs(GestionWeb.INDEX_FILE_PATH);
    }

    public Web getWebById(int id2) {
        return Webs.getInstance().getWebById(id2);
    }
}
