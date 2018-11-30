package eda.segundaFase;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        testCircularLinkedList();
        testUnorderedCircularLinkedList();
        System.out.println();
        testOrderedCircularLinkedList();

    }

    private static void testCircularLinkedList() {
        UnorderedCircularLinkedList<Integer> testing = new UnorderedCircularLinkedList<Integer>();
        UnorderedCircularLinkedList<Integer> testing1Element = new UnorderedCircularLinkedList<Integer>() {{
            addToRear(0);
        }};
        UnorderedCircularLinkedList<Integer> testing2Elements = new UnorderedCircularLinkedList<Integer>() {
            {
                addToRear(0);
                addToRear(1);
            }
        };
        for (int i = 0; i < 10; i++) {
            testing.addToRear(i);
        }
        System.out.println("Testing CircularLinkedList methods");
        //first
        System.out.println("\t| first test O(1)");
        System.out.println("\t\t- empty list :" + (new UnorderedCircularLinkedList<>()).first());
        System.out.println("\t\t- 1 element list < 0 >:" +
                testing1Element.first());
        System.out.println("\t\t- 1+ elements list < 0 1 2 3 4 5 6 7 8 9>:" + testing.first());

        //last
        System.out.println("\t| last test O(1)");
        System.out.println("\t\t- empty list :" + (new UnorderedCircularLinkedList<>()).last());
        System.out.println("\t\t- 1 element list < 0 > :" +
                testing1Element.last());
        System.out.println("\t\t- 1+ elements list < 0 1 2 3 4 5 6 7 8 9>:" + testing.last());

        //contains
        System.out.println("\t| contains test O(n)");
        System.out.println("\t\t- empty list constains 1:" + (new UnorderedCircularLinkedList<Integer>()).contains(1));
        System.out.println("\t\t- 1 element list contains 0 < 0 >:" +
                testing1Element.contains(0));
        System.out.println("\t\t- 1 element list contains 1 < 0 >:" +
                testing1Element.contains(1));
        System.out.println("\t\t- 2 elements list contains 1 < 0 1>:" +
                testing2Elements.contains(1));
        System.out.println("\t\t- 2 elements list contains 0 < 0 1>:" +
                testing2Elements.contains(0));
        System.out.println("\t\t- 2 elements list contains 2 < 0 1>:" +
                testing2Elements.contains(2));
        System.out.println("\t\t- 2+ elements list contains 0 < 0 1 2 3 4 5 6 7 8 9 >:" +
                testing.contains(0));
        System.out.println("\t\t- 2+ elements list contains 9 < 0 1 2 3 4 5 6 7 8 9 >:" +
                testing.contains(9));
        System.out.println("\t\t- 2+ elements list contains 5 < 1 2 3 4 5 6 7 8 9 >:" +
                testing.contains(5));
        System.out.println("\t\t- 2+ elements list contains 10 < 1 2 3 4 5 6 7 8 9 >:" +
                testing.contains(10));
        //find
        System.out.println("\t| find test O(n)");
        System.out.println("\t\t- 1 element list contains 0 < 0 >:" +
                testing1Element.find(0));
        System.out.println("\t\t- 1 element list contains 1 < 0 >:" +
                testing1Element.find(1));
        System.out.println("\t\t- 2 elements list contains 1 < 0 1>:" +
                testing2Elements.find(1));
        System.out.println("\t\t- 2 elements list contains 0 < 0 1>:" +
                testing2Elements.find(0));
        System.out.println("\t\t- 2 elements list contains 2 < 0 1>:" +
                testing2Elements.find(2));
        System.out.println("\t\t- 2+ elements list contains 0 < 0 1 2 3 4 5 6 7 8 9 >:" +
                testing.find(0));
        System.out.println("\t\t- 2+ elements list contains 9 < 0 1 2 3 4 5 6 7 8 9 >:" +
                testing.find(9));
        System.out.println("\t\t- 2+ elements list contains 5 < 1 2 3 4 5 6 7 8 9 >:" +
                testing.find(5));
        System.out.println("\t\t- 2+ elements list contains 10 < 1 2 3 4 5 6 7 8 9 >:" +
                testing.find(10));
        //isEmpty
        System.out.println("\t| isEmpty test O(1)");
        System.out.println("\t\t empty list:" + new UnorderedCircularLinkedList<>().isEmpty());
        System.out.println("\t\t non-empty list:" + testing.isEmpty());
        //iterator testing
        System.out.println("\t| Iterator testing");
        System.out.println("\t\t hasNext O(1)");
        System.out.println("\t\t\t empty list: " + new UnorderedCircularLinkedList<>().iterator().hasNext());
        System.out.println("\t\t\t non-empty list: " + testing1Element.iterator().hasNext());
        System.out.println("\t\t next O(1)");
        System.out.println("\t\t\t empty list: " + new UnorderedCircularLinkedList<>().iterator().next());
        System.out.println("\t\t\t non-empty list: " + testing1Element.iterator().next());
        String result = " ";
        Iterator<Integer> itr = testing.iterator();
        while (itr.hasNext()) {
            result += itr.next().toString() + " ";
        }
        System.out.println("\t\t\t loop test (while hasNext):" + "[" + result + "]");
        //removeFirst
        System.out.println("\t| removeFirst test O(1)");
        System.out.println("\t\t- empty list :" + (new UnorderedCircularLinkedList<>()).removeFirst());
        System.out.println("\t\t- 1 element list < 0 >:" +
                testing1Element.removeFirst());
        System.out.println("\t\t\tFinal list:  " + testing1Element.toString());
        System.out.println("\t\t- 2 elements list < 0 1 >:" + testing2Elements.removeFirst());
        System.out.println("\t\t\tFinal list: " + testing2Elements.toString());
        System.out.println("\t\t- 1+ elements list < 0 1 2 3 4 5 6 7 8 9>:" + testing.removeFirst());
        System.out.println("\t\t\tFinal list:" + testing.toString());
        //removeLast
        testing = new UnorderedCircularLinkedList<Integer>();
        testing1Element = new UnorderedCircularLinkedList<Integer>() {{
            addToRear(0);
        }};
        testing2Elements = new UnorderedCircularLinkedList<Integer>() {
            {
                addToRear(0);
                addToRear(1);
            }
        };
        for (int i = 0; i < 10; i++) {
            testing.addToRear(i);
        }
        System.out.println("\t| removeLast test O(n)");
        System.out.println("\t\t- empty list :" + (new UnorderedCircularLinkedList<>()).removeLast());
        System.out.println("\t\t- 1 element list < 0 >:" +
                testing1Element.removeLast());
        System.out.println("\t\t\tFinal list:  " + testing1Element.toString());
        System.out.println("\t\t- 2 elements list < 0 1 >:" + testing2Elements.removeLast());
        System.out.println("\t\t\tFinal list: " + testing2Elements.toString());
        System.out.println("\t\t- 1+ elements list < 0 1 2 3 4 5 6 7 8 9>:" + testing.removeLast());
        System.out.println("\t\t\tFinal list:" + testing.toString());
        //remove
        testing = new UnorderedCircularLinkedList<Integer>();
        testing1Element = new UnorderedCircularLinkedList<Integer>() {{
            addToRear(0);
        }};
        testing2Elements = new UnorderedCircularLinkedList<Integer>() {
            {
                addToRear(0);
                addToRear(1);
            }
        };
        for (int i = 0; i < 10; i++) {
            testing.addToRear(i);
        }
        System.out.println("\t| remove test O(n)");
        System.out.println("\t\t- empty list :" + (new UnorderedCircularLinkedList<Integer>()).remove(0));
        System.out.println("\t\t- 1 element list (remove 1) < 0 >:" +
                testing1Element.remove(1));
        System.out.println("\t\t- 1 element list (remove 0) < 0 >:" +
                testing1Element.remove(0));
        System.out.println("\t\t\tFinal list:  " + testing1Element.toString());
        System.out.println("\t\t- 2 elements list (remove 2) < 0 1 >:" + testing2Elements.remove(2));
        System.out.println("\t\t\tFinal list: " + testing2Elements.toString());
        System.out.println("\t\t- 2 elements list (remove 1) < 0 1 >:" + testing2Elements.remove(1));
        System.out.println("\t\t\tFinal list: " + testing2Elements.toString());
        testing2Elements = new UnorderedCircularLinkedList<Integer>() {
            {
                addToRear(0);
                addToRear(1);
            }
        };
        System.out.println("\t\t- 2 elements list (remove 0) < 0 1 >:" + testing2Elements.remove(0));
        System.out.println("\t\t\tFinal list: " + testing2Elements.toString());
        System.out.println("\t\t- 2+ elements list (remove 0) < 0 1 2 3 4 5 6 7 8 9 >:" +
                testing.remove(0));
        System.out.println("\t\t\tFinal list: " + testing.toString());
        testing.addToFront(0);
        System.out.println("\t\t- 2+ elements list (remove 9) < 0 1 2 3 4 5 6 7 8 9 >:" +
                testing.remove(9));
        System.out.println("\t\t\tFinal list: " + testing.toString());
        testing.addToRear(9);
        System.out.println("\t\t- 2+ elements list (remove 5)< 1 2 3 4 5 6 7 8 9 >:" +
                testing.remove(5));
        System.out.println("\t\t\tFinal list: " + testing.toString());
        testing.addAfter(5, 4);
        System.out.println("\t\t- 2+ elements list (remove 10) < 1 2 3 4 5 6 7 8 9 >:" +
                testing.remove(10));
        System.out.println("\t\t\tFinal list: " + testing.toString());
    }

    private static void testOrderedCircularLinkedList() {
        OrderedCircularLinkedList<Integer> list = new OrderedCircularLinkedList<>();
        System.out.println("Testing integers OrderedCircularLinkedList:");
        System.out.println("\t| add test O(n):");
        //add
        // 1 to <>
        System.out.println("\t\t" + list.toString());
        System.out.print("\t\t-Adding 1 to empty list <>:");
        list.add(1);
        System.out.println(list.contains(1));
        System.out.println("\t\t" + list.toString());
        //2 to < 1 >;
        System.out.print("\t\t-Adding 2 to 1 element list  1 <--> 1 :");
        list.add(2);
        System.out.println(list.contains(2) &&
                list.size() == 2);
        System.out.println("\t\t" + list.toString());
        //7 to < 1 2 >
        System.out.print("\t\t-Adding 7 to 2 elements list < 1 2 > :");
        list.add(7);
        System.out.println(list.contains(7)
                && list.size() == 3);
        System.out.println("\t\t" + list.toString());
        //------------------------------------------------------
        System.out.println();
        OrderedCircularLinkedList<Persona> list1 = new OrderedCircularLinkedList<>();
        System.out.println("Testing objects OrderedCircularLinkedList:");
        System.out.println("\t| add test O(n):");
        //add
        //1 to <>
        System.out.println("\t\t" + list1.toString());
        System.out.print("\t\t-Adding [pedro, 1111]: ");
        list1.add(new Persona("pedro", "1111"));
        System.out.println(list1.contains(new Persona("pedro", "1111")));
        System.out.println("\t\t" + list1.toString());
        //2 to < 1 >;
        System.out.print("\t\t-Adding [amaia , 2222]: ");
        list1.add(new Persona("amaia", "2222"));
        System.out.println(list1.contains(new Persona("amaia", "2222")) &&
                list1.size() == 2);
        System.out.println("\t\t" + list1.toString());
        //7 to < 1 2 >
        System.out.print("\t\t-Adding [ana 3333]: ");
        list1.add(new Persona("ana", "3333"));
        System.out.println(list1.contains(new Persona("ana", "3333"))
                && list1.size() == 3);
        System.out.println("\t\t" + list1.toString());
    }


    private static void testUnorderedCircularLinkedList() {
        UnorderedCircularLinkedList<Integer> basicTypeList = new UnorderedCircularLinkedList<Integer>();
        System.out.println("Testing integers UnorderedCircularLinkedList:");
        System.out.println("\t| addToRear test O(1):");
        //addToRear
        //1 to <>
        System.out.println("\t\t" + basicTypeList.toString());
        System.out.print("\t\t-Adding 1 to empty list <>:");
        basicTypeList.addToRear(1);
        System.out.println(basicTypeList.contains(1));
        System.out.println("\t\t" + basicTypeList.toString());
        //2 to < 1 >;
        System.out.print("\t\t-Adding 2 to 1 element list  1 <--> 1 :");
        basicTypeList.addToRear(2);
        System.out.println(basicTypeList.contains(2) &&
                basicTypeList.size() == 2);
        System.out.println("\t\t" + basicTypeList.toString());
        //7 to < 1 2 >
        System.out.print("\t\t-Adding 7 to 2 elements list < 1 2 > :");
        basicTypeList.addToRear(7);
        System.out.println(basicTypeList.contains(7)
                && basicTypeList.size() == 3);
        System.out.println("\t\t" + basicTypeList.toString());

        //addToFront
        basicTypeList = new UnorderedCircularLinkedList<>();
        //1 to <>
        System.out.println("\t| addToFront test O(1)");
        System.out.println("\t\t" + basicTypeList.toString());
        System.out.print("\t\t-Adding 1 to empty list <>:");
        basicTypeList.addToFront(1);
        System.out.println(basicTypeList.contains(1) &&
                basicTypeList.size() == 1);
        System.out.println("\t\t" + basicTypeList.toString());

        //2 to < 1 >;
        System.out.print("\t\t-Adding 2 to 1 element list  1 <--> 1 :");
        basicTypeList.addToFront(2);
        System.out.println(basicTypeList.contains(2) &&
                basicTypeList.size() == 2);
        System.out.println("\t\t" + basicTypeList.toString());
        //7 to < 1 2 >
        System.out.print("\t\t-Adding 7 to 2 elements list < 1 2 > :");
        basicTypeList.addToFront(7);
        System.out.println(basicTypeList.contains(7)
                && basicTypeList.size() == 3);
        System.out.println("\t\t" + basicTypeList.toString());

        //addAfter
        basicTypeList = new UnorderedCircularLinkedList<>();
        //1 to <>
        System.out.println("\t| addAfter test O(n)");
        System.out.println("\t\tPre: Target se encuentra en la lista");
        basicTypeList.addToFront(0);
        System.out.println("\t\t" + basicTypeList.toString());
        System.out.print("\t\t-Adding 1 after first element (0) to 1 element list: ");
        basicTypeList.addAfter(1, 0);
        System.out.println(basicTypeList.contains(1) &&
                basicTypeList.size() == 2);
        System.out.println("\t\t" + basicTypeList.toString());

        //2 to < 1 >;
        System.out.print("\t\t-Adding 2 after last element (1) to 2 elements list: ");
        basicTypeList.addAfter(2, 1);
        System.out.println(basicTypeList.contains(2) &&
                basicTypeList.size() == 3);
        System.out.println("\t\t" + basicTypeList.toString());
        //7 to < 1 2 >
        System.out.print("\t\t-Adding 7 between <0 1 2 > :");
        basicTypeList.addAfter(7, 1);
        System.out.println(basicTypeList.contains(7)
                && basicTypeList.size() == 4);
        System.out.println("\t\t" + basicTypeList.toString());
        //------------------------------------------------------
        System.out.println();
        UnorderedCircularLinkedList<Persona> objectsList = new UnorderedCircularLinkedList<>();
        System.out.println("Testing objects UnorderedCircularLinkedList:");
        System.out.println("\t| addToRear test O(1):");
        //addToRear
        //1 to <>
        System.out.println("\t\t" + objectsList.toString());
        System.out.print("\t\t-Adding [pedro, 1111]: ");
        objectsList.addToRear(new Persona("pedro", "1111"));
        System.out.println(objectsList.contains(new Persona("pedro", "1111")));
        System.out.println("\t\t" + objectsList.toString());
        //2 to < 1 >;
        System.out.print("\t\t-Adding [amaia , 2222]: ");
        objectsList.addToRear(new Persona("amaia", "2222"));
        System.out.println(objectsList.contains(new Persona("amaia", "2222")) &&
                objectsList.size() == 2);
        System.out.println("\t\t" + objectsList.toString());
        //7 to < 1 2 >
        System.out.print("\t\t-Adding [ana 3333]: ");
        objectsList.addToRear(new Persona("ana", "3333"));
        System.out.println(objectsList.contains(new Persona("ana", "3333"))
                && objectsList.size() == 3);
        System.out.println("\t\t" + objectsList.toString());

        //addToFront
        objectsList = new UnorderedCircularLinkedList<>();
        //1 to <>
        System.out.println("\t| addToFront test O(1)");
        System.out.println("\t\t" + objectsList.toString());
        System.out.print("\t\t-Adding [pedro, 1111]: ");
        objectsList.addToFront(new Persona("pedro", "1111"));
        System.out.println(objectsList.contains(new Persona("pedro", "1111")));
        System.out.println("\t\t" + objectsList.toString());
        //2 to < 1 >;
        System.out.print("\t\t-Adding [amaia , 2222]: ");
        objectsList.addToFront(new Persona("amaia", "2222"));
        System.out.println(objectsList.contains(new Persona("amaia", "2222")) &&
                objectsList.size() == 2);
        System.out.println("\t\t" + objectsList.toString());
        //7 to < 1 2 >
        System.out.print("\t\t-Adding [ana 3333]: ");
        objectsList.addToFront(new Persona("ana", "3333"));
        System.out.println(objectsList.contains(new Persona("ana", "3333"))
                && objectsList.size() == 3);
        System.out.println("\t\t" + objectsList.toString());

        //addAfter
        objectsList = new UnorderedCircularLinkedList<>();
        //1 to <>
        System.out.println("\t| addAfter test O(n)");
        System.out.println("\t\tPre: Target se encuentra en la lista");
        objectsList.addToFront(new Persona("juan", "0000"));
        System.out.println("\t\t" + objectsList.toString());
        System.out.print("\t\t-Adding [pedro, 1111]: ");
        objectsList.addAfter(new Persona("pedro", "1111"), new Persona("juan", "0000"));
        System.out.println(objectsList.contains(new Persona("pedro", "1111")));
        System.out.println("\t\t" + objectsList.toString());
        //2 to < 1 >;
        System.out.print("\t\t-Adding [amaia , 2222]: ");
        objectsList.addAfter(new Persona("amaia", "2222"), new Persona("pedro", "1111"));
        System.out.println(objectsList.contains(new Persona("amaia", "2222")) &&
                objectsList.size() == 3);
        System.out.println("\t\t" + objectsList.toString());
        //7 to < 1 2 >
        System.out.print("\t\t-Adding [ana 3333]: ");
        objectsList.addAfter(new Persona("ana", "3333"), new Persona("pedro", "1111"));
        System.out.println(objectsList.contains(new Persona("ana", "3333"))
                && objectsList.size() == 4);
        System.out.println("\t\t" + objectsList.toString());


    }


}
