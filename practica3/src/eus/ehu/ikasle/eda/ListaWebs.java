package eus.ehu.ikasle.eda;

import java.util.Iterator;
import java.util.LinkedList;

public class ListaWebs implements Iterable<Web> {

    private LinkedList<Web> webs;

    public ListaWebs(){
        this.webs = new LinkedList<>();
    }

    public void add(Web web){
        this.webs.add(web);
    }

    public Iterator<Web> iterator(){
        return this.webs.iterator();
    }

    public int size(){
        return this.webs.size();
    }

}
