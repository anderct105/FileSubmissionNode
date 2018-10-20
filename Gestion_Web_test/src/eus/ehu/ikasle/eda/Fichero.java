package eus.ehu.ikasle.eda;

import java.io.*;
import java.util.List;

public class Fichero {
    private static Fichero ourInstance = new Fichero();

    public static Fichero getInstance() {
        return ourInstance;
    }

    private Fichero() {
    }

    public void cargarRelacionesPruebas() {
        this.cargarRelaciones(GestionWeb.RELATIONS_TEST_FILE_PATH);
    }

    public void cargarWebsPruebas() {
        this.cargarWebs(GestionWeb.INDEX_TEST_FILE_PATH);
    }

    public void cargarRelaciones(String path) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String line;
            String[] entradas;
            Web web, webRelacionada;
            Webs webs = Webs.getInstance();
            while ((line = in.readLine()) != null) {
                // entrada ej: 0 --> 283 870 450 277 357 277 65 616 510 169 882
                // la web de id 0 esta relacionada con esas
                if (!line.isEmpty()) {
                    // cambia todos los caracteres que no sean digitos por un espacio
                    line = line.replaceAll("\\D+", " ");
                    entradas = line.split(" "); // devuelve todos lo digitos como un array de strings
                    // El primer elemento es el id de la pagina
                    web = webs.getWebById(Integer.parseInt(entradas[0]));
                    if (web != null) { // Si existe la pagina
                        // Por cada entrada comprueba que existe dicha web
                        for (int i = 1; i < entradas.length; i++) {
                            webRelacionada = webs.getWebById(Integer.parseInt(entradas[i]));
                            if (webRelacionada != null) { // Si existe la web a relacionar
                                web.addWebRelacionada(webRelacionada); // añade a la lista de relaciones la web
                            } else {
                                System.out.println("Error en la carga de las relaciones ," +
                                        " web relacionada no encontrada");
                            }
                        }
                    } else {
                        System.out.println("Error en la carga de las relaciones no se encuentra el id");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarWebs(String path) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String line;
            Web web;
            Webs webs = Webs.getInstance();
            while ((line = in.readLine()) != null) {
                if (!line.isEmpty()) {
                    try {
                        // entrada ej:  0-3ani.ro 0 -> Web(0,"0-3ani.ro")
                        web = new Web(Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1)),
                                line.substring(0, line.lastIndexOf(" ")));
                        webs.addWeb(web); // añadir al hashmap de webs la web de la linea correspondiente
                    } catch (NumberFormatException ex) {
                        System.out.println("Formato del archivo incorrecto, se seguirá comprobando");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Webs.getInstance().loadLastId();
    }

    public void cargarDiccionario(String path) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String line;
            Diccionario dic = Diccionario.getInstance();
            dic.limpiar();
            Palabra palabra;
            while ((line = in.readLine()) != null) {
                if (!line.isEmpty()) {
                    dic.addPalabra(new Palabra(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Añade cada lista
     */
    public void escribirWebs(String path) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
            List<Web> lista = Webs.getInstance().getListaAnadidas();
            for (Web w : lista) {
                bw.newLine();
                bw.write(w.toString() + " " + w.getId());
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}