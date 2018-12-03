package eda;

import eda.GestionWeb;
import eda.Webs;
import eda.utils.Stopwatch;

import java.util.ArrayList;
import java.util.HashMap;

public class Main4 {
    
    private static GestionWeb gestionWeb = GestionWeb.getInstance();
    
    public static void main(String[] args){
        Stopwatch s = new Stopwatch();
        Fichero.getInstance().cargarWebsPruebas();
        Fichero.getInstance().cargarRelacionesPruebas();
        Fichero.getInstance().cargarDiccionario(GestionWeb.WORDS_FILE_PATH);
        //gestionWeb.cargarDatos();
        System.out.println("Carga de datos "+s.elapsedTime()+"s");
        s = new Stopwatch();
        HashMap<String,Double> a = gestionWeb.pageRank();
        System.out.println("Carga de pageRank "+s.elapsedTime()+"s");
        a.toString();
        ArrayList<Web> l = Webs.getInstance().buscar("hola");
        for(Web w : l ){
            System.out.println(w.getWeb());
        }
    }
    
    
    
}
