package eus.ehu.ikasle.eda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ListaWebs {

    private HashSet<Web> webs;


    public ListaWebs(){
        this.webs = new HashSet<>();
    }

    public void anadirWeb(Web web){
        this.webs.add(web);
    }


    public boolean isEmpty() {
        return this.webs.isEmpty();
    }
}
