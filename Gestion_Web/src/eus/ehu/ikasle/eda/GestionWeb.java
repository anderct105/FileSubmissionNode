package eus.ehu.ikasle.eda;

import java.util.List;

public class GestionWeb {
    private static GestionWeb ourInstance = new GestionWeb();

    public static GestionWeb getInstance() {
        return ourInstance;
    }

    private GestionWeb() {
    }

    public void cargarDatos(){
        Fichero f = Fichero.getInstance();
        f.cargarDiccionario();
        f.cargarWebs();
        f.cargarRelaciones();
    }

    private Web buscarWebById(int id){
        return null;
    }

    private Web buscarWebByPalabras(List<Palabra> palabras){
        return null;
    }

    private ListaWebs getWebsEnlazadas(Web web){
        return web.getWebRelacionadas();
    }

    private boolean insertarWeb(Web web){
        return false;
    }

    private void guardarCambios(){

    }

    private List<Web> getWebsOrdenadas(){
        return null;
    }

}