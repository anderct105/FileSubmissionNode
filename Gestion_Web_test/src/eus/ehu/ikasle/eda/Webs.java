package eus.ehu.ikasle.eda;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.function.BiConsumer;

public class Webs {

    private HashMap<Integer,Web> webs;

    private static Webs ourInstance = new Webs();

    public static Webs getInstance() {
        return ourInstance;
    }

    private Webs() {
        this.webs = new HashMap<>();
    }


    public void addWeb(Web web){
        this.webs.put(web.getId(),web);
    }

    public Web getWebById(int id){
        return this.webs.get(id);
    }

    public void limpiar(){
        this.webs.clear();
    }

    public void websQueContienen(Palabra palabra) {
        webs.entrySet().forEach((entry) -> {
            Web web = entry.getValue();
            if (web.constains(palabra)){
                web.addPalabra(palabra);
                palabra.addWebConPalabra(web);
            }
        });
        /*webs.forEach((integer, web) -> {
            if (web.constains(palabra)){
                web.addPalabra(palabra);
                palabra.addWebConPalabra(web);
            }
        });*/
    }

    public Web getWebByFullName(String name) {
        Web result = null;

        Collection<Web> websCollection = this.webs.values();
        //busqueda desordenada ¿?¿?¿??¿
        Iterator<Web> itr = this.webs.values().iterator();
        Web tmp = null;
        // mientras tenga siguiente y ese no tenga el mismo nombre que estoy buscando , sigue
        while(itr.hasNext() && !(tmp = itr.next()).getWeb().equalsIgnoreCase(name));
        if (tmp != null && tmp.getWeb().equalsIgnoreCase(name)){
            result = tmp;
        }
        return result;
    }
}
