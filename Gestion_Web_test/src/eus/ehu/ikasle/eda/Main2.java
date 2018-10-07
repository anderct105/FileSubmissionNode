package eus.ehu.ikasle.eda;

import eus.ehu.ikasle.eda.utils.Stopwatch;

import java.util.*;

public class Main2 {
    public static void menu(){
        System.out.println("--------------MENÚ--------------");
        System.out.println("1.Buscar una página web");
        System.out.println("2.Insetar una nueva página web");
        System.out.println("3.Página enlazadas a una web");
        System.out.println("4.Paginas ordenadas alfabeticamente");
        System.out.println("0.Salir");
        System.out.println("Selecciona una: ");
    }
    public static void main(String[] args) {
        GestionWeb.getInstance().cargarDatos();
        boolean visto = false;
        boolean terminado = false;
        do {
            try {
                if (!visto) {
                    visto = true;
                    menu();
                }
                Scanner sc = new Scanner(System.in);
                int tmp = sc.nextInt();
                if (tmp < 0 || tmp > 4) {
                    throw new Exception();
                }
                visto = false;
                switch (tmp) {
                    case 1:
                        List<String> lista = new ArrayList<String>();
                        boolean vacio = true;
                        System.out.println("Haz tu busqueda: ");
                        while(vacio) {
                            String busqueda = sc.nextLine();
                            StringTokenizer st = new StringTokenizer(busqueda);
                            while (st.hasMoreTokens()) {
                                vacio = false;
                                lista.add(st.nextToken());
                            }
                        }
                        Stopwatch sw = new Stopwatch();
                        List<Web> lw = GestionWeb.getInstance().buscarWebsByPalabras(lista);
                        double time = sw.elapsedTime();
                        System.out.println("Resultado de la busqueda" + "(" + time + "s)"+": ");
                        if(lw.size() != 0) {
                            for (Web w : lw) {
                                System.out.println(w.getWeb());
                            }
                        }
                        else{
                            System.out.println("ERROR 404 NOT FOUND");
                        }
                        break;
                    case 2:
                        Scanner sp = new Scanner(System.in);
                        System.out.println("Introduce el nombre de la web: ");
                        boolean empty = true;
                        String nombre = " ";
                        while(empty) {
                            nombre = sp.nextLine();
                            if(!nombre.isEmpty()){
                                empty = false;
                            }
                            else{
                                System.out.println("Vuelve a introducir");
                            }
                        }
                        System.out.println("Introduce un id: ");
                        int id = sc.nextInt();
                        Webs.getInstance().addWebNueva(new Web(id,nombre));
                        System.out.println("Web annadida exitosamente!");
                        break;
                    case 3:
                        Scanner sb = new Scanner(System.in);
                        System.out.println("Mete el id de la web");
                        int id2 = sb.nextInt();
                        Web w = Webs.getInstance().getWebById(id2);
                        List<Web> ls = w.getWebsEnlazadas();
                        if(ls.size() != 0) {
                            for (Web wb : ls) {
                                System.out.println(wb.getWeb());
                            }
                        }
                        else{
                            System.out.println("No hay ninguna web enlazada");
                        }
                        break;
                    case 4:
                        Scanner sr = new Scanner(System.in);
                        List<Web> l = GestionWeb.getInstance().getWebsOrdenadas();
                        System.out.println("Lista ordenada exitosamente");
                        System.out.println("quieres ver la lista de webs ordenada?(Y/N) ");
                        String opcion = sr.nextLine();
                        if(opcion.equalsIgnoreCase("Y")){
                            for(Web web : l){
                                System.out.println(web.getWeb());
                            }
                        }
                        else{
                            System.out.println("OK");
                        }
                        break;
                    case 0:
                        terminado = true;
                }
            } catch (Exception e) {
                System.out.println("Numero no valido introduce otra vez: ");
            }
        }while(!terminado);
    }

}
