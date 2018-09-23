package eus.ehu.ikasle.eda;

import java.util.HashMap;
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
        webs.forEach(new BiConsumer<Integer, Web>() {
            @Override
            public void accept(Integer integer, Web web) {
                if (web.constains(palabra)){
                    web.addPalabra(palabra);
                    palabra.addWebConPalabra(web);
                }
            }
        });
    }
}
