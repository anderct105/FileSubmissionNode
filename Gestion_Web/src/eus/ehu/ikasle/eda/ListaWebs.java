package eus.ehu.ikasle.eda;

import java.util.HashMap;
import java.util.List;

public class ListaWebs {

    private HashMap<Integer,Web> webs;


    public ListaWebs(){
        this.webs = new HashMap<>();
    }

    public void anadirWeb(Web web, int id){
        this.webs.put(id,web);
    }

    public Web getWebById(int id){
        return null;
    }

    public List<Web> getWebOrdenadas(){
        return null;
    }

}
