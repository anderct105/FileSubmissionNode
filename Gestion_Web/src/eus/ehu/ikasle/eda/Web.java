package eus.ehu.ikasle.eda;

import java.util.List;

public class Web {

    private int id;
    private String nombre;
    private ListaWebs webRelacionadas;
    private ListaPalabras palabras;

    public Web(int id,String nombre){
        this.nombre = nombre;
        this.id = id;
        this.webRelacionadas = new ListaWebs();
    }

    public void addWebRelacionada(Web web){
        this.webRelacionadas.anadirWeb(web);
    }

    public ListaWebs getWebRelacionadas(){
        return this.webRelacionadas;
    }

    public boolean contains(Palabra palabra) {
        return this.nombre.contains(palabra.getPalabraString());
    }

    public void setPalabras(ListaPalabras palabras) {
        this.palabras = palabras;
    }

    public ListaPalabras getListaPalabras(){
        return this.palabras;
    }

    public boolean contienePalabras(List<Palabra> palabras) {
        return this.palabras.contienePalabras(palabras);
    }
}
