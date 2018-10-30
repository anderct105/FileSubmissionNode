package eus.ehu.ikasle.eda.segundaFase;

import sun.util.resources.cldr.fa.CalendarData_fa_IR;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        testUnorderedCircularLinkedList();
        testOrderedCircularLinkedList();

    }

    private static void testOrderedCircularLinkedList() {

    }



    private static void testUnorderedCircularLinkedList() {
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
        basicTypeList.addAfter(2,1);
        System.out.println(basicTypeList.contains(2) &&
                basicTypeList.size() == 3);
        System.out.println("\t\t"+basicTypeList.toString());
        //7 to < 1 2 >
        System.out.print("\t\t-Adding 7 between <0 1 2 > :");
        basicTypeList.addAfter(   7,1);
        System.out.println(basicTypeList.contains(7)
                && basicTypeList.size() == 4);
        System.out.println("\t\t"+basicTypeList.toString());
        //------------------------------------------------------
        System.out.println();
        UnorderedCircularLinkedList<Persona> objectsList = new UnorderedCircularLinkedList<>();
        System.out.println("Testing objects UnorderedCircularLinkedList:");
        System.out.println("\t| addToRear test O(1):");
        //addToRear
        //1 to <>
        System.out.println("\t\t"+objectsList.toString());
        System.out.print("\t\t-Adding [pedro, 1111]: ");
        objectsList.addToRear(new Persona("pedro","1111"));
        System.out.println(objectsList.contains(new Persona("pedro","1111")));
        System.out.println("\t\t"+objectsList.toString());
        //2 to < 1 >;
        System.out.print("\t\t-Adding [amaia , 2222]: ");
        objectsList.addToRear(new Persona("amaia","2222"));
        System.out.println(objectsList.contains(new Persona("amaia","2222")) &&
                objectsList.size() == 2);
        System.out.println("\t\t"+objectsList.toString());
        //7 to < 1 2 >
        System.out.print("\t\t-Adding [ana 3333]: ");
        objectsList.addToRear(new Persona("ana","3333"));
        System.out.println(objectsList.contains(new Persona("ana","3333"))
                && objectsList.size() == 3);
        System.out.println("\t\t"+objectsList.toString());

        //addToFront
        objectsList = new UnorderedCircularLinkedList<>();
        //1 to <>
        System.out.println("\t| addToFront test O(1)");
        System.out.println("\t\t"+objectsList.toString());
        System.out.print("\t\t-Adding [pedro, 1111]: ");
        objectsList.addToFront(new Persona("pedro","1111"));
        System.out.println(objectsList.contains(new Persona("pedro","1111")));
        System.out.println("\t\t"+objectsList.toString());
        //2 to < 1 >;
        System.out.print("\t\t-Adding [amaia , 2222]: ");
        objectsList.addToFront(new Persona("amaia","2222"));
        System.out.println(objectsList.contains(new Persona("amaia","2222")) &&
                objectsList.size() == 2);
        System.out.println("\t\t"+objectsList.toString());
        //7 to < 1 2 >
        System.out.print("\t\t-Adding [ana 3333]: ");
        objectsList.addToFront(new Persona("ana","3333"));
        System.out.println(objectsList.contains(new Persona("ana","3333"))
                && objectsList.size() == 3);
        System.out.println("\t\t"+objectsList.toString());

        //addAfter
        objectsList = new UnorderedCircularLinkedList<>();
        //1 to <>
        System.out.println("\t| addAfter test O(n)");
        System.out.println("\t\tPre: Target se encuentra en la lista");
        objectsList.addToFront(new Persona("juan","0000"));
        System.out.println("\t\t"+objectsList.toString());
        System.out.print("\t\t-Adding [pedro, 1111]: ");
        objectsList.addAfter(new Persona("pedro","1111"),new Persona("juan","0000"));
        System.out.println(objectsList.contains(new Persona("pedro","1111")));
        System.out.println("\t\t"+objectsList.toString());
        //2 to < 1 >;
        System.out.print("\t\t-Adding [amaia , 2222]: ");
        objectsList.addAfter(new Persona("amaia","2222"),new Persona("pedro","1111"));
        System.out.println(objectsList.contains(new Persona("amaia","2222")) &&
                objectsList.size() == 3);
        System.out.println("\t\t"+objectsList.toString());
        //7 to < 1 2 >
        System.out.print("\t\t-Adding [ana 3333]: ");
        objectsList.addAfter(new Persona("ana","3333"),new Persona("pedro","1111"));
        System.out.println(objectsList.contains(new Persona("ana","3333"))
                && objectsList.size() == 4);
        System.out.println("\t\t"+objectsList.toString());


    }


}
