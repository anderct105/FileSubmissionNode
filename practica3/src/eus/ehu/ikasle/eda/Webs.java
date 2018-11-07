package eus.ehu.ikasle.eda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Webs {
    private HashMap<String, Integer> th;
    private String[] keys;
    private ArrayList<Integer>[] adjList;

    public Webs(){
        this.th = new HashMap<>();
    }

    public boolean estanConectados(String a1, String a2){
        LinkedList<Integer> porExaminar = new LinkedList<Integer>();
        int pos1 = th.get(a1);
        int pos2 = th.get(a2);
        boolean enc = false;
        boolean[] examinados = new boolean[th.size()];
        porExaminar.add(pos1);
        examinados[0] = true;
        while (!enc && !porExaminar.isEmpty()){
            int act = porExaminar.removeFirst();
            if (act == pos2){
                enc = true;
            }
            else {
                
            }
        }


        return enc;
    }
}
