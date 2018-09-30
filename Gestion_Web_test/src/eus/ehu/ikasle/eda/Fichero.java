package eus.ehu.ikasle.eda;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fichero {
    private static Fichero ourInstance = new Fichero();

    public static Fichero getInstance() {
        return ourInstance;
    }

    private Fichero() {
    }

    public void cargarRelacionesPruebas(){
        try {
            //BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir")
            //      + File.separator + "pld-arcs-1-N_grande"));
            BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir")
                    + File.separator + "relaciones_prueba"));
            String line;
            String[] entradas;
            Web web,webRelacionada;
            Webs webs = Webs.getInstance();
            while((line = in.readLine()) != null){
                // entrada ej: 0 --> 283 870 450 277 357 277 65 616 510 169 882
                // la web de id 0 esta relacionada con esas
                line = line.replaceAll("\\D+"," ");
                entradas = line.split(" ");
                web = webs.getWebById(Integer.parseInt(entradas[0]));
                if (web != null){
                    if (entradas.length > 1 ){
                        for (int i = 1 ; i < entradas.length; i++){
                            webRelacionada = webs.getWebById(Integer.parseInt(entradas[i]));
                            if (webRelacionada != null){
                                web.addWebRelacionada(webRelacionada);
                            }else{
                                System.out.println("Error en la carga de las relaciones , web relacionada no encontrada");
                            }
                        }
                    }
                }else{
                    System.out.println("Error en la carga de las relaciones no se encuentra el id");
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarWebsPruebas(){
        try {
            //BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir") + File.separator + "index_grande"));
            BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir")
                    + File.separator + "index_prueba"));
            String line;
            Web web;
            Webs webs = Webs.getInstance();
            while((line = in.readLine()) != null){
                // entrada ej:  0-3ani.ro 0 , Web(0,"0-3ani.ro")
                web = new Web(Integer.parseInt(line.substring(line.lastIndexOf(" ")+1)),
                        line.substring(0,line.lastIndexOf(" ")));
                webs.addWeb(web); // añadir al hashmap de webs la web de la linea correspondiente
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarRelaciones(String path){
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String line;
            String[] entradas;
            Web web,webRelacionada;
            Webs webs = Webs.getInstance();
            while((line = in.readLine()) != null){
                // entrada ej: 0 --> 283 870 450 277 357 277 65 616 510 169 882
                // la web de id 0 esta relacionada con esas
                if(!line.isEmpty()){
                    line = line.replaceAll("\\D+"," "); // cambia todos los caracteres que no sean digitos por un espacio
                    entradas = line.split(" "); // devuelve todos lo digitos como un array de strings
                    web = webs.getWebById(Integer.parseInt(entradas[0])); // El primer elemento es el id de la pagina
                    if (web != null){ // Si existe la pagina
                        for (int i = 1 ; i < entradas.length; i++){ // Por cada entrada comprueba que existe dicha web
                            webRelacionada = webs.getWebById(Integer.parseInt(entradas[i]));
                            if (webRelacionada != null){ // Si existe la web a relacionar
                                web.addWebRelacionada(webRelacionada); // añade a la lista de relaciones la web
                            }else{
                                System.out.println("Error en la carga de las relaciones , web relacionada no encontrada");
                            }
                        }
                    }else{
                        System.out.println("Error en la carga de las relaciones no se encuentra el id");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarWebs(String path){
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String line;
            Web web;
            Webs webs = Webs.getInstance();
            while((line = in.readLine()) != null){
                if (!line.isEmpty()) {
                    // entrada ej:  0-3ani.ro 0 -> Web(0,"0-3ani.ro")
                    web = new Web(Integer.parseInt(line.substring(line.lastIndexOf(" ")+1)),
                            line.substring(0,line.lastIndexOf(" ")));
                    webs.addWeb(web); // añadir al hashmap de webs la web de la linea correspondiente
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Webs.getInstance().loadLastId();
    }

    public void cargarDiccionario(String path){
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String line;
            Diccionario dic = Diccionario.getInstance();
            Palabra palabra;
            while((line = in.readLine()) != null){
                if (!line.isEmpty()){
                    dic.addPalabra(new Palabra(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Añade cada lista
     * */
    public void escribirWebs(String path){
        try {
            BufferedWriter bw= new BufferedWriter(new FileWriter(path,true));
            List<Web> lista=Webs.getInstance().getListaAnadidas();
            for(Web w : lista){
                bw.newLine();
                bw.write(w.toString() +" "+w.getId());
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}