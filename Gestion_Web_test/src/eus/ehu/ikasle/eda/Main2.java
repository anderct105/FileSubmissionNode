package eus.ehu.ikasle.eda;

import eus.ehu.ikasle.eda.utils.Stopwatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main2 {


    private static GestionWeb gestionWeb = GestionWeb.getInstance();

    public static void menu() {
        System.out.println("--------------MENÚ--------------");
        System.out.println("1.Buscar una página web");
        System.out.println("2.Insetar una nueva página web");
        System.out.println("3.Página enlazadas a una web");
        System.out.println("4.Paginas ordenadas alfabeticamente");
        System.out.println("0.Salir");
        System.out.println("Selecciona una: ");
    }


    public static void main(String[] args) {
        System.out.println("Cargando datos");
        Stopwatch stopwatch = new Stopwatch();
        gestionWeb.cargarDatos();
        System.out.println("Tiempo : " + stopwatch.elapsedTime() + "s");
        boolean visto = false;
        boolean terminado = false;
        do {
            if (!visto) {
                visto = true;
                menu();
            }
            Scanner sc = new Scanner(System.in);
            int tmp = sc.nextInt();
            switch (tmp) {
                case 1:
                    menuBusqueda(sc);
                    visto = false;
                    break;
                case 2:
                    menuInsercion(sc);
                    visto = false;
                    break;
                case 3:
                    menuBusquedaWebsEnlazadas(sc);
                    visto = false;
                    break;
                case 4:
                    menuOrdenacion(sc);
                    visto = false;
                    break;
                case 0:
                    gestionWeb.guardarWebsAnadidas();
                    terminado = true;
                    break;
                default:
                    System.out.println("Numero no valido introduce otra vez: ");
            }
        } while (!terminado);
    }

    private static void menuOrdenacion(Scanner sc) {
        Stopwatch stopwatch;
        System.out.println("Ordenando Webs");
        stopwatch = new Stopwatch();
        List<Web> l = gestionWeb.getWebsOrdenadasMergeSort();
        System.out.println("Tiempo : " + stopwatch.elapsedTime() + "s");
        System.out.println("Lista ordenada exitosamente");
        System.out.println("¿Quieres ver la lista de webs ordenada?(Y/N) ");
        String opcion = sc.next();
        if (opcion.equalsIgnoreCase("y")) {
            for (Web web : l) {
                System.out.println(web.getWeb());
            }
        } else {
            System.out.println("OK");
        }
    }

    private static void menuBusquedaWebsEnlazadas(Scanner sc) {
        String input;
        while ((input = sc.nextLine()).isEmpty()) {
            System.out.println("Inserte el id o el nombre entero de la web (example.com)");
        }
        Web w;
        try {
            int id2 = Integer.parseInt(input);
            w = gestionWeb.getWebById(id2);
        } catch (NumberFormatException ex) {
            w = gestionWeb.getWebPorURL(input);
        }
        if (w != null) {
            List<Web> ls = w.getWebsEnlazadas();
            if (ls.size() != 0) {
                for (Web wb : ls) {
                    System.out.println(wb.getWeb());
                }
            } else {
                System.out.println("No hay ninguna web enlazada");
            }
        } else {
            System.out.println("La web que busca no se encuetra");
        }
    }

    private static void menuInsercion(Scanner sc) {
        System.out.println("Introduce el nombre de la web: ");
        boolean match;
        String nombre;
        String patterRegex = "[a-z0-9]+([\\-\\.]+[a-z0-9]+)*\\.[a-z]+";
        do {
            nombre = sc.next();
            if (!nombre.matches(patterRegex)) {
                System.out.println("Inserte una web correcta (example.com)");
                match = false;
            } else {
                match = true;
            }
        } while (!match);
        GestionWeb.nuevaWeb(nombre);
        System.out.println("Web añadida exitosamente!");
    }

    private static void menuBusqueda(Scanner sc) {
        List<String> lista = new ArrayList<>();
        boolean vacio = true;
        System.out.println("Haz tu busqueda:  (credit card com)");
        while (vacio) {
            String busqueda = sc.nextLine();
            StringTokenizer st = new StringTokenizer(busqueda);
            while (st.hasMoreTokens()) {
                vacio = false;
                lista.add(st.nextToken());
            }
        }
        Stopwatch sw = new Stopwatch();
        List<Web> lw = gestionWeb.buscarWebsPorPalabras(lista);
        System.out.println("Resultado de la busqueda" + "(" + sw.elapsedTime() + "s)" + ": ");
        if (lw.size() != 0) {
            for (Web w : lw) {
                System.out.println(w.getWeb());
            }
        } else {
            System.out.println("ERROR 404 NOT FOUND");
        }
    }

}
