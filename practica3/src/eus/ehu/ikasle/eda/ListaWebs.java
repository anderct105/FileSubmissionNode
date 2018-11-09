package eus.ehu.ikasle.eda;

import java.util.Iterator;
import java.util.LinkedList;

public class ListaWebs implements Iterable<String>{

    private LinkedList<String> webs;

    public ListaWebs(){
        this.webs = new LinkedList<>();
    }

    public void add(String web){
        this.webs.add(web);
    }

    public Iterator<String> iterator(){
        return this.webs.iterator();
    }

    public int size(){
        return this.webs.size();
    }

}
