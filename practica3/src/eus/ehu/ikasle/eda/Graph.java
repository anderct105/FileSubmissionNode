package eus.ehu.ikasle.eda;

import java.util.*;

public class Graph {
    private HashMap<String, Integer> th;
    private String[] keys;
    private ArrayList<Integer>[] adjList;

    public void crearGrafo(ListaWebs lista) {
        if (lista != null && lista.size() != 0) {
            th = new HashMap<>();
            keys = new String[lista.size()];
            int count = 0;
            for (Web web : lista) {
                th.put(web.toString(), count++);
            }
            keys = new String[th.size()];
            for (String k : th.keySet()) keys[th.get(k)] = k;
            adjList = new ArrayList[lista.size()];
            for (Web web : lista) {
                adjList[th.get(web.getWeb())] = new ArrayList<>();
                for (Integer relacion : web.getWebsEnlazadas()) {
                    adjList[th.get(web.getWeb())].add(th.get(keys[relacion]));
                }
            }
        }

    }

    public void print() {
        if (th != null) {
            for (int i = 0; i < adjList.length; i++) {
                System.out.print("Element: " + i + " " + keys[i] + " --> ");
                for (int k : adjList[i]) System.out.print(keys[k] + " ### ");

                System.out.println();
            }
        }
    }

    public boolean estanConectados(String a1, String a2) {
        boolean enc = false;
        if (th != null) { // Grafo no creado
            int pos1 = th.get(a1);
            int pos2 = th.get(a2);
            LinkedList<Integer> porExaminar = new LinkedList<Integer>();
            if (a1 != null && a2 != null) {
                int act;
                boolean[] examinados = new boolean[th.size()];
                porExaminar.add(pos1);
                examinados[pos1] = true;
                while (!enc && !porExaminar.isEmpty()) {
                    act = porExaminar.removeFirst();
                    if (act == pos2) {
                        enc = true;
                    } else {
                        for (int k = 0; k < adjList[act].size(); k++) {
                            int relacion = adjList[act].get(k);
                            if (!examinados[relacion]) {
                                porExaminar.add(relacion);
                                examinados[relacion] = true;
                            }
                        }
                    }
                }
            }
        }
        return enc;
    }

    public ArrayList<String> backPointer(String a1, String a2) {
        ArrayList<String> result = new ArrayList<>();
        if (th != null) {
            LinkedList<Integer> porExaminar = new LinkedList<Integer>();
            int pos1 = th.get(a1);
            int pos2 = th.get(a2);
            boolean enc = false;
            int act;
            int relacion;
            boolean[] examinados = new boolean[th.size()];
            int[] bp = new int[th.size()];
            bp[pos1] = -1;
            porExaminar.add(pos1);
            examinados[pos1] = true;
            if (a1 != null && a2 != null) {
                while (!enc && !porExaminar.isEmpty()) {
                    act = porExaminar.removeFirst();
                    if (act == pos2) {
                        enc = true;
                    } else {
                        for (int k = 0; k < adjList[act].size(); k++) {
                            relacion = adjList[act].get(k);
                            if (!examinados[relacion]) {
                                porExaminar.add(relacion);
                                examinados[relacion] = true;
                                bp[relacion] = act;
                            }
                        }
                    }
                }
            }
            if (enc) {
                Stack<Integer> caminoPila = new Stack<Integer>();
                int valor = pos2;
                while (bp[valor] != -1) {
                    caminoPila.push(valor);
                    valor = bp[valor];
                }
                caminoPila.push(valor);
                int stackSize = caminoPila.size();
                for (int i = 0; i < stackSize; i++) {
                    result.add(this.keys[caminoPila.pop()]);
                }
            }
        }
        return result;
    }

    public String getRandomNode() {
        return this.keys[(int)(Math.random()*this.keys.length)];
    }
}

