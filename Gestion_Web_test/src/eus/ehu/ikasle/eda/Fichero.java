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

    public void cargarRelaciones(){
        try {
            //BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir")
            //        + File.separator + "pld-arcs-1-N_grande"));
            BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir")
            + File.separator + "smallpld-arcs-1-N"));
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
                        for (int i = 1 ; i < entradas.length; i++){
                            webRelacionada = webs.getWebById(Integer.parseInt(entradas[i]));
                            if (webRelacionada != null){
                                web.addWebRelacionada(webRelacionada);
                            }else{
                                System.out.println("Error en la carga de las relaciones , web relacionada no encontrada");
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

    public void cargarWebs(){
        try {
            //BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir")
             //       + File.separator + "index_grande"));
            BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir")
                   + File.separator + "smallindex"));
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

    public void cargarDiccionario(){
        try {
            BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir")
                    + File.separator + "words.txt"));
            String line;
            Diccionario dic = Diccionario.getInstance();
            Palabra palabra;
            while((line = in.readLine()) != null){
                dic.addPalabra(new Palabra(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarPalabrasRelacionadasConWebs(){
        Diccionario diccionario  = Diccionario.getInstance();
        diccionario.cargarWebsRelacionadas();
    }

    public void escribirWebs(){
        try {
            BufferedWriter bw= new BufferedWriter(new FileWriter(System.getProperty("user.dir") + File.separator
                    + "smallindex",true));
            List<Integer> lista=Webs.getInstance().getListaAnadidas();
            for(Integer i : lista){
                bw.newLine();
                bw.write(Webs.getInstance().getWebById(i).getWeb()+" "+i);
            }
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}