package eus.ehu.ikasle.eda;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GestionWeb {
    private static GestionWeb ourInstance = new GestionWeb();

    public static final String INDEX_TEST_FILE_PATH = System.getProperty("user.dir")
            + File.separator + "index_prueba";
    public static final String RELATIONS_TEST_FILE_PATH = System.getProperty("user.dir")
            + File.separator + "relaciones_prueba";

    public static final String INDEX_FILE_PATH = System.getProperty("user.dir")
            + File.separator + "index_grande";
    public static final String RELATIONS_FILE_PATH = System.getProperty("user.dir")
            + File.separator + "pld-arcs-1-N_grande";

    public static final String SMALL_INDEX_FILE_PATH = System.getProperty("user.dir")
            + File.separator + "smallindex";
    public static final String SMALL_RELATIONS_FILE_PATH = System.getProperty("user.dir")
            + File.separator + "smallpld-arcs-1-N";

    public static final String WORDS_FILE_PATH = System.getProperty("user.dir")
            + File.separator + "words.txt";

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

    public Web getWebPorURL(String name) {
        return Webs.getInstance().getWebByFullName(name);
    }

    /**
     * @return List de webs que contienen las palabras
     * si una palabra no existe devolvera la lista vacia
     */
    public List<Web> buscarWebsPorPalabras(List<String> palabras) {
        List<Web> resultado = new ArrayList<>();
        if (palabras.size() > 0) { // si la lista tiene palabras
            Diccionario dic = Diccionario.getInstance();
            Palabra tmp1;
            // rellena la lista con las palabras que se han encontrado o si no con null
            List<Palabra> palabrasList = dic.getPalabrasDelDiccionario(palabras);
            // si tienen el mismo tamaño significa que se han encontrado todas la palabras
            if (palabras.size() == palabrasList.size()) {
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


    public List<Web> getWebsOrdenadasMergeSort() {
        return Webs.getInstance().getWebsOrdenadasMergeSort();
    }

    /**
     * Añade las nuevas webs al archivo sin sobreescribir el fichero
     */
    public void guardarWebsAnadidas() {
        Fichero.getInstance().escribirWebs(GestionWeb.INDEX_FILE_PATH);
    }

    public Web getWebById(int id2) {
        return Webs.getInstance().getWebById(id2);
    }
}
