package src;

import java.util.LinkedList;

public class SortingAlgorithms {




    public static void quickSortAge(LinkedList<Vessel> vessels) {
        quickSort(vessels, 0, vessels.size() - 1, true);
    }

    private static void quickSort(LinkedList<Vessel> vessels, int i, int j, boolean sortingAge) {
        int p;
        if (i >= j) {
            return;
        } else {
            p = partition(vessels, i, j, sortingAge);
            quickSort(vessels, i, p, sortingAge);
            quickSort(vessels, p + 1, j, sortingAge);

        }
    }

    private static int partition(LinkedList<Vessel> vessels, int i, int j, boolean sortingAge) {

        Vessel auxVessel;

        int l, r;
        int middle;
        int pivotInt = 0;
        double pivotDouble = 0;

        l = i;
        r = j;

        middle = (i + j) / 2;

        if (sortingAge) {
            pivotInt = vessels.get(middle).id;
        } else {
            pivotDouble = vessels.get(middle).getCapabilitiesRating();
        }

        while (true) {

            if (sortingAge) {
                while (vessels.get(l).id < pivotInt) {
                    l++;
                }
                while (vessels.get(r).id > pivotInt) {
                    r--;
                }
            } else {
                while (vessels.get(l).getCapabilitiesRating() < pivotDouble) {
                    l++;
                }
                while (vessels.get(r).getCapabilitiesRating() > pivotDouble) {
                    r--;
                }
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

    //Funcion pantalla
    public static void mergeSortName(LinkedList<Vessel> vessels) {
        mergeSortName(vessels, 0, vessels.size() - 1);
    }


        /*Esta funcion divide la linked list en varias funciones, donde tambien llama a si mismo para seguir dividiendose hasta quedar 1 */

    public static void mergeSortName(LinkedList<Vessel> vessels, int left, int right) {
        if (left < right) {
            //Encuentra el punto medio del vector.
            int middle = (left + right) / 2;

            //Divide la primera y segunda mitad (llamada recursiva).
            mergeSortName(vessels, left, middle);
            mergeSortName(vessels, middle + 1, right);

            //Une las mitades.
            merge(vessels, left, middle, right);
        }
    }

    /* Esta funcion compara si la letra es mayor que el de la derecha, si es asi hace un swap dels dos objectes */

    private static void merge(LinkedList<Vessel> vessels, int left, int middle, int right) {

        int i, j, k;
        LinkedList<Vessel> B = null;

        for (i = left; i <= right; i++)      //copia ambas mitades en el array auxiliar
            B = (LinkedList<Vessel>) vessels.clone();

        i = left;
        j = middle + 1;
        k = left;


        while (i <= middle && j <= right) //copia el siguiente elemento más grande
            if (B.get(i).name.charAt(0) <= B.get(j).name.charAt(0))
                vessels.set(k++, B.get(i++));
            else
                vessels.set(k++, B.get(j++));

        while (i <= middle)                 //copia los elementos que quedan de la
            vessels.set(k++, B.get(i++));          //primera mitad (si los hay)
    }


        public static void bucketSortCapabilities (LinkedList <Vessel> vessels) {

            bucketSortCapabilities(vessels, vessels.size());
        }

        public static void bucketSortCapabilities (LinkedList <Vessel> vessels, int bucketsNumber) {
            int i;
            int j;

            int index;


            LinkedList<LinkedList<Vessel>> bucket = new LinkedList<>();

            for (i = 0; i < vessels.size(); i++) {
                bucket.add(new LinkedList<>());
            }

            for (i = 0; i < vessels.size(); i++) {
                index = (int) vessels.get(i).getCapabilitiesRating() * bucketsNumber;
                bucket.get(index).add(vessels.get(i));
            }

            for (i = 0; i < bucketsNumber; i++) {
                quickSort(bucket.get(i), 0, bucket.get(i).size() - 1, false);
                bucket.set(i, bucket.get(i));
            }
            index = 0;
            for (i = 0; i < bucketsNumber; i++) {
                for (j = 0; j < bucket.get(i).size(); j++) {
                    vessels.set(index, bucket.get(i).get(j));
                    index++;
                }
            }

        }
    }






