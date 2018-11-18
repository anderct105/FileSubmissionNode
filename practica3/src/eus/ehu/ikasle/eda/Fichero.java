package eus.ehu.ikasle.eda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Fichero {
    private static Fichero ourInstance = new Fichero();

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

    public static Fichero getInstance() {
        return ourInstance;
    }


    private HashMap<Integer,Web> webs;

    public ListaWebs cargarWebs() {
        ListaWebs webs = new ListaWebs();

        try {
            BufferedReader in = new BufferedReader(new FileReader(INDEX_FILE_PATH));
            String line;
            Web web;
            while ((line = in.readLine()) != null) {
                if (!line.isEmpty()) {
                    try {
                        // entrada ej:  0-3ani.ro 0 -> Web(0,"0-3ani.ro")
                        web = new Web(Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1)),
                                line.substring(0, line.lastIndexOf(" ")));
                        webs.add(web); // añadir al hashmap de webs la web de la linea correspondiente
                    } catch (NumberFormatException ex) {
                        System.out.println("Formato del archivo incorrecto, se seguirá comprobando");
                    }
                }
            }
            in.close();
            line = "";
            in = new BufferedReader(new FileReader(RELATIONS_TEST_FILE_PATH));
            String[] entradas;
            while ((line = in.readLine()) != null) {
                if (!line.isEmpty()) {
                    line = line.replaceAll("\\D+", " ");
                    entradas = line.split(" "); // devuelve todos lo digitos como un array de strings
                    for (int i = 1; i < entradas.length; i++){
                        webs.addRelacion(Integer.parseInt(entradas[0]), Integer.parseInt(entradas[i]));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return webs;
    }

}