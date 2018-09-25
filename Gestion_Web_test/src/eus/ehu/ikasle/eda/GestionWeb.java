package eus.ehu.ikasle.eda;

import java.util.ArrayList;
import java.util.List;

public class GestionWeb {
    private static GestionWeb ourInstance = new GestionWeb();

    public static GestionWeb getInstance() {
        return ourInstance;
    }

    private GestionWeb() {
    }


    public void cargarDatos() {
        Fichero f = Fichero.getInstance();
        f.cargarWebs();
        f.cargarRelaciones();
        f.cargarDiccionario();
        f.cargarPalabrasRelacionadasConWebs();
    }

    public Web getWebByFullName(String name) {

        return Webs.getInstance().getWebByFullName(name);
    }

    public List<Web> buscarWebsByPalabras(List<String> palabras) {
        List<Web> resultado = new ArrayList<>();
        if (palabras.size() > 0) {
            Diccionario dic = Diccionario.getInstance();
            Palabra primera = dic.getPalabraByString(palabras.get(0));
            Palabra tmp;
            if (primera != null) {
                if (palabras.size() != 1) {
                    boolean contenidas;
                    for (Web web : primera.getWebs()) {
                        contenidas = true;
                        for (int i = 1; i < palabras.size() && contenidas; i++) {
                            tmp = dic.getPalabraByString(palabras.get(i));
                            if (tmp != null) {
                                if (!web.estaEnListaPalabras(tmp)) {
                                    contenidas = false;
                                }
                            } else {
                                System.out.println("Error palabra no existente, se sigue la busqueda");
                                contenidas = false;
                                palabras.remove(i);
                            }
                        }
                        if (contenidas) {
                            resultado.add(web);
                        }
                    }
                } else {
                    resultado = primera.getWebs();
                }
            } else {
                System.out.println("Palabra no encontrada");
            }
        }

        return resultado;
    }

    public List<Web> buscarWebsByPalabrasRetainAll(List<String> palabras) {
        List<Web> resultado = new ArrayList<>();
        Diccionario dic = Diccionario.getInstance();
        if (palabras.size() > 0) {
            Palabra tmp = dic.getPalabraByString(palabras.get(0));
            if (tmp != null) {
                resultado = tmp.getWebs();
                if (palabras.size() > 1) {
                    for (int i = 1; i < palabras.size() && !resultado.isEmpty(); i++) {
                        tmp = dic.getPalabraByString(palabras.get(i));
                        //Si no encuentra alguna de las palabras la busqueda se cancela devolviendo un array vacio
                        if (tmp != null){
                            resultado.retainAll(tmp.getWebs());
                        }else{
                            resultado = new ArrayList<>();
                        }
                    }
                }
            } else {
                System.out.println("Error palabra no encontrada, se devolvera la lista vacia");
            }

        }

        return resultado;
    }

    public List<Web> getWebOrdenada(){
        return Webs.getInstance().getWebsOrdenadas();
    }
    public List<Web> getWebsOrdenadasQuickSort(){
        return Webs.getInstance().getWebsOrdenadasQuickSort();
    }
}
