package eda;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
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


    public static GestionWeb getInstance() {
        return ourInstance;
    }

    private GestionWeb() {
    }

    public HashMap<String, Double> pageRank() {
        return Webs.getInstance().pageRank();
    }
}
