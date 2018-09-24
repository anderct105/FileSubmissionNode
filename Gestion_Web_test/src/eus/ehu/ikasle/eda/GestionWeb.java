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


    public void cargarDatos(){
        Fichero f = Fichero.getInstance();
        f.cargarWebs();
        f.cargarRelaciones();
        f.cargarDiccionario();
        f.cargarPalabrasRelacionadasConWebs();
    }

    public Web getWebByFullName(String name){
        return Webs.getInstance().getWebByFullName(name);
    }

    public List<Web> buscarWebsByPalabras(String[] palabras){
        List<Web> resultado = new ArrayList<>();
        Diccionario dic = Diccionario.getInstance();
        Palabra primera = dic.getPalabraByString(palabras[0]);
        Palabra tmp;
        if (primera != null){
            if (palabras.length != 1){
                boolean contenidas;
                for (Web web: primera.getWebs()) {
                    contenidas = true;
                    for (int i = 1 ; i < palabras.length && contenidas; i++){
                        tmp = dic.getPalabraByString(palabras[i]);
                        if (tmp != null){
                            if (!web.estaEnListaPalabras(tmp)){
                                contenidas = false;
                            }
                        }else{
                            System.out.println("Error palabra no existente, se sigue la busqueda");
                            contenidas = false;
                        }
                    }
                    if (contenidas){
                        resultado.add(web);
                    }
                }
            }else{
                resultado = primera.getWebs();
            }
        }else{
            System.out.println("Palabra no encontrada");
        }
        return resultado;
    }

    public List<Web> buscarWebsByPalabrasRetainAll(String[] palabras){
        List<Web> resultado = new ArrayList<>();
        Diccionario dic = Diccionario.getInstance();
        if (palabras.length > 0){
            Palabra tmp = dic.getPalabraByString(palabras[0]);
            if (tmp != null){
                resultado = tmp.getWebs();
                if (palabras.length > 1){
                    for (int i = 1 ; i < palabras.length && !resultado.isEmpty();i++){
                        tmp = dic.getPalabraByString(palabras[i]);
                        resultado.retainAll(tmp.getWebs());
                    }
                }
            }else{
                System.out.println("Error palabra no encontrada, se devolvera la lista vacia");
            }

        }

        return resultado;
    }

}
