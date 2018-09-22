package eus.ehu.ikasle.eda;

import eus.ehu.ikasle.eda.utils.Stopwatch;

import java.io.*;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.logging.Logger;

public class Fichero {
    private static Fichero ourInstance = new Fichero();

    public static Fichero getInstance() {
        return ourInstance;
    }

    private Fichero() {
    }

    public void cargarDiccionario(){
        try {
            BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir")
                    + File.separator + "words.txt"));
            String line;
            Palabra palabra;
            Diccionario dic = Diccionario.getInstance();
            Webs webs = Webs.getInstance();
            while((line = in.readLine()) != null){
                palabra = new Palabra(line);
                dic.anadirPalabra(palabra);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarWebs(){
        try {
            BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir") + File.separator
                    + "smallindex"));
            String line;
            Webs webs = Webs.getInstance();
            int id;
            Web web;
            while ((line = in.readLine()) != null){
                id = Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1));
                web = new Web(id,line.substring(0, line.indexOf(" ")));
                webs.addWeb(id,web);
                ListaPalabras palabras = Diccionario.getInstance().getPalabrasRelacionadas(web);
                web.setPalabras(palabras);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarRelaciones(){
        try {
            BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir") + File.separator
                    + "smallpld-arcs-1-N"));
            String line;
            Webs webs = Webs.getInstance();
            int id;
            Web web,tmp;
            while ((line = in.readLine()) != null){
                //TODO Capturar NumberFormatException
                id = Integer.parseInt(line.substring(0,line.indexOf(" "))); // coger id de la posicion 0 hasta el primer espacio
                web = webs.getWebById(id); // encuentra la web con el id indicado
                if (web != null){
                  String[] idsRelacionados = line.substring(line.indexOf(">")+2).split("\\s");
                    for (String idStr: idsRelacionados) {
                        tmp = webs.getWebById(Integer.parseInt(idStr));
                        if (tmp != null){
                            web.addWebRelacionada(tmp);
                        }else{
                            System.out.println("ERROR: la pagina que quiere relacionar no se encuentra o no esta cargada");
                        }
                    }
                }else{
                    System.out.println("ERROR : pagina no encontrada en el sistema");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void escribirWebs(){
        
    }

}
