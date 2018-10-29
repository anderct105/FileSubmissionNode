package eus.ehu.ikasle.eda.segundaFase;

import sun.util.resources.cldr.fa.CalendarData_fa_IR;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        testUnorderedCircularLinkedList();
        testOrderedCircularLinkedList();

    }

    private static void testOrderedCircularLinkedList() {
        //TODO mirar si realmente está bien puesto el enlace con los demas nodos
        UnorderedCircularLinkedList<Integer> basicTypeList = new UnorderedCircularLinkedList<Integer>();
        System.out.println("Testing integers UnorderedCircularLinkedList:");
        System.out.println("\t| addToRear test O(1):");
        //addToRear
        //1 to <>
        System.out.println("\t\t"+basicTypeList.toString());
        System.out.print("\t\t-Adding 1 to empty list <>:");
        basicTypeList.addToRear(1);
        System.out.println(basicTypeList.contains(1));
        System.out.println("\t\t"+basicTypeList.toString());
        //2 to < 1 >;
        System.out.print("\t\t-Adding 2 to 1 element list  1 <--> 1 :");
        basicTypeList.addToRear(2);
        System.out.println(basicTypeList.contains(2) &&
                basicTypeList.size() == 2);
        System.out.println("\t\t"+basicTypeList.toString());
        //7 to < 1 2 >
        System.out.print("\t\t-Adding 7 to 2 elements list < 1 2 > :");
        basicTypeList.addToRear(7);
        System.out.println(basicTypeList.contains(7)
                && basicTypeList.size() == 3);
        System.out.println("\t\t"+basicTypeList.toString());

        //addToFront
        basicTypeList = new UnorderedCircularLinkedList<>();
        //1 to <>
        System.out.println("\t| addToFront test O(1)");
        System.out.println("\t\t"+basicTypeList.toString());
        System.out.print("\t\t-Adding 1 to empty list <>:");
        basicTypeList.addToFront(1);
        System.out.println(basicTypeList.contains(1) &&
                basicTypeList.size() == 1);
        System.out.println("\t\t"+basicTypeList.toString());

        //2 to < 1 >;
        System.out.print("\t\t-Adding 2 to 1 element list  1 <--> 1 :");
        basicTypeList.addToFront(2);
        System.out.println(basicTypeList.contains(2) &&
                basicTypeList.size() == 2);
        System.out.println("\t\t"+basicTypeList.toString());
        //7 to < 1 2 >
        System.out.print("\t\t-Adding 7 to 2 elements list < 1 2 > :");
        basicTypeList.addToFront(   7);
        System.out.println(basicTypeList.contains(7)
                && basicTypeList.size() == 3);
        System.out.println("\t\t"+basicTypeList.toString());

        //addAfter
        basicTypeList = new UnorderedCircularLinkedList<>();
        //1 to <>
        System.out.println("\t| addAfter test O(n)");
        System.out.println("\t\tPre: Target se encuentra en la lista");
        basicTypeList.addToFront(0);
        System.out.println("\t\t"+basicTypeList.toString());
        System.out.print("\t\t-Adding 1 after first element (0) to 1 element list: ");
        basicTypeList.addAfter(1,0);
        System.out.println(basicTypeList.contains(1) &&
                basicTypeList.size() == 2);
        System.out.println("\t\t"+basicTypeList.toString());

        //2 to < 1 >;
        System.out.print("\t\t-Adding 2 after last element (1) to 2 elements list: ");
        basicTypeList.addToFront(2);
        System.out.println(basicTypeList.contains(2) &&
                basicTypeList.size() == 3);
        System.out.println("\t\t"+basicTypeList.toString());
        //7 to < 1 2 >
        System.out.print("\t\t-Adding 7 to 2 elements list < 1 2 > :");
        basicTypeList.addToFront(   7);
        System.out.println(basicTypeList.contains(7)
                && basicTypeList.size() == 3);
        System.out.println("\t\t"+basicTypeList.toString());


        UnorderedCircularLinkedList<Persona> objectsList = new UnorderedCircularLinkedList<>();

    }

    private static void testUnorderedCircularLinkedList() {
    }


}
