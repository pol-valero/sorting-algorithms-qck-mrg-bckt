package src;

import java.util.LinkedList;

public class SortingAlgorithms {




    public static void quickSortAge(LinkedList<Vessel> vessels) {
        quickSortAge(vessels, 0, vessels.size() - 1);
    }

    private static void quickSortAge(LinkedList<Vessel> vessels, int i, int j) {
        int p;
        if (i >= j) {
            return;
        } else {
            p = partition(vessels, i, j);
            quickSortAge(vessels, i, p);
            quickSortAge(vessels, p + 1, j);

        }
    }

    private static int partition(LinkedList<Vessel> vessels, int i, int j) {

        Vessel auxVessel;

        int l, r;
        int middle;
        int pivot;

        l = i;
        r = j;

        middle = (i + j) / 2;

        pivot = vessels.get(middle).id;

        while (true) {

            while(vessels.get(l).id < pivot) {
                l++;
            }
            while(vessels.get(r).id > pivot) {
                r--;
            }

            if (l >= r) {
                return r;
            }

            auxVessel = vessels.get(l);
            vessels.set(l, vessels.get(r));
            vessels.set(r, auxVessel);

            l++;
            r--;

        }

    }

    //Function screen
    public static void mergeSortName(LinkedList<Vessel> vessels) {
        mergeSortName(vessels, 0, vessels.size() - 1);
    }


        /*This function split de linkedList until we have a linked-list with only one item */

    public static void mergeSortName(LinkedList<Vessel> vessels, int left, int right) {
        if (left < right) {
            //Find the middle of the linked-list.
            int middle = (left + right) / 2;

            //Call the function mergeSortName to split the two half
            mergeSortName(vessels, left, middle);
            mergeSortName(vessels, middle + 1, right);

            //mergesort the linked-list
            merge(vessels, left, middle, right);
        }
    }

    /* this function compare two letters and if is smaller they swap the element.*/

    private static void merge(LinkedList<Vessel> vessels, int left, int middle, int right) {

        int i, j, k;
        LinkedList<Vessel> B = null;


        B = (LinkedList<Vessel>) vessels.clone(); //clone the linked-list to the auxiliary one

        i = left;
        j = middle + 1;
        k = left;


        while (i <= middle && j <= right) //Swap the elements
            if (B.get(i).name.charAt(0) <= B.get(j).name.charAt(0))
                vessels.set(k++, B.get(i++));
            else
                vessels.set(k++, B.get(j++));

        while (i <= middle)                 //Copy the elements of the first half (if there is)
            vessels.set(k++, B.get(i++));
    }


        public static void bucketSortCapabilities (LinkedList <Vessel> vessels) {
            //Per ordenar vaixells per prestacions, primer hem de ponderar els seus
            //atributs (pes, eslora, capacitat, velocitat max) amb un pes diferent
            //cadascun. Un cop això estigui fet, per cada vaixell tindrem un resultat
            //de la suma ponderada de les seves prestacions. Aquest resultat es el que
            //utilitzarem per a ordenar els vaixells

        }
}






