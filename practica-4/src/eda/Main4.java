package eda;

import eda.GestionWeb;
import eda.Webs;
import eda.utils.Stopwatch;

public class Main4 {
    
    private static GestionWeb gestionWeb = GestionWeb.getInstance();
    
    public static void main(String[] args){
        Stopwatch s = new Stopwatch();
        gestionWeb.cargarDatos();
        System.out.println("Carga de datos "+s.elapsedTime()+"s");
        s = new Stopwatch();
        gestionWeb.pageRank();
        System.out.println("Carga de pageRank "+s.elapsedTime()+"s");
    }
    
    
    
}
