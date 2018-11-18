package eus.ehu.ikasle.eda;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class ListaWebs implements Iterable<Web> {

    private HashMap<Integer,Web> webs;

    public ListaWebs(){
        this.webs = new HashMap<>();
    }

    public void add(Web web){
        this.webs.put(web.getId(),web);
    }

    public Iterator<Web> iterator(){
        return this.webs.values().iterator();
    }

    public int size(){
        return this.webs.size();
    }

    public void addRelacion(Integer id, Integer relacion) {
        this.webs.get(id).addWebRelacionada(relacion);
    }
}
