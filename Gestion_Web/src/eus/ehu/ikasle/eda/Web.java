package eus.ehu.ikasle.eda;

public class Web {

    private String nombre;
    private ListaWebs webRelacionadas;

    public Web(String nombre){
        this.nombre = nombre;
    }

    public void anadirEnlaces(){

    }

    public ListaWebs getWebRelacionadas(){
        return this.webRelacionadas;
    }

}
