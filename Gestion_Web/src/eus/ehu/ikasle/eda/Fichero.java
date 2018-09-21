package eus.ehu.ikasle.eda;

import eus.ehu.ikasle.eda.utils.Stopwatch;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Fichero {
    private static Fichero ourInstance = new Fichero();

    public static Fichero getInstance() {
        return ourInstance;
    }

    private Fichero() {
    }

    public void cargarDiccionario(){

    }

    public void cargarWebs(){
        HashMap<Integer,Web> webs = new HashMap<>();

        try {
            BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir") + File.separator + "smallindex"));
            String line;
            //StringTokenizer stk = new StringTokenizer(line, " ");
            while ((line = in.readLine()) != null){
                webs.put(Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1)),new Web(line.substring(0, line.indexOf(" "))));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarRelaciones(){

    }

    public void escribirWebs(){
        
    }

}
