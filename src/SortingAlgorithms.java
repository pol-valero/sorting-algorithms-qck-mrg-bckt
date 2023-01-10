package src;

import java.util.LinkedList;

public class SortingAlgorithms {

    //This function is used so that we only have to pass a list as a function argument to sort the list
    public static void quickSortAge(LinkedList<Vessel> vessels) {
        quickSort(vessels, 0, vessels.size() - 1, true);   //We pass "true" as a 3rd argument because we want to sort by age
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

    //Each time this function is called, the array is divided in two parts (with the help of the pointers l, r)
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

            //The following "if" is used so that the quickSort algorithm can sort by age or by capabilities
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

            //We swap the values
            auxVessel = vessels.get(l);
            vessels.set(l, vessels.get(r));
            vessels.set(r, auxVessel);

            l++;
            r--;

        }

    }

    //This function is used so that we only have to pass a list as a function argument to sort the list
    public static void mergeSortName(LinkedList<Vessel> vessels) {
        mergeSortName(vessels, 0, vessels.size() - 1);
    }

    //This function splits the linkedList until we have a linked-list with only one item
    public static void mergeSortName(LinkedList<Vessel> vessels, int left, int right) {
        if (left < right) {
            //Find the middle of the linked-list.
            int middle = (left + right) / 2;

            //Call the function mergeSortName to split the two halves
            mergeSortName(vessels, left, middle);
            mergeSortName(vessels, middle + 1, right);

            //mergesort the linked-list
            merge(vessels, left, middle, right);
        }
    }

    //This function compare two letters and if is smaller they swap the element.
    private static void merge(LinkedList<Vessel> vessels, int left, int middle, int right) {

        int i, j, k;
        LinkedList<Vessel> B = null;


        B = (LinkedList<Vessel>) vessels.clone(); //clone the linked-list to the auxiliary one

        i = left;
        j = middle + 1;
        k = left;


        while (i <= middle && j <= right) //Swap the elements

            if (B.get(i).name.compareToIgnoreCase(B.get(j).name) < 0)
                vessels.set(k++, B.get(i++));
            else
                vessels.set(k++, B.get(j++));

        while (i <= middle)                 //Copy the elements of the first half (if there is)
            vessels.set(k++, B.get(i++));

    }

    private static double maxPriorityValue (LinkedList <Vessel> vessels) {

        double maxValue = vessels.get(0).getCapabilitiesRating();

        for (int i = 1; i < vessels.size(); i++) {
            if (vessels.get(i).getCapabilitiesRating() > maxValue) {
                maxValue = vessels.get(i).getCapabilitiesRating();
            }
        }
        //System.out.println("MAX VALUE: " + maxValue);
        return maxValue;
    }

    //This function is used so that we only have to pass a list as a function argument to sort the list
    public static void bucketSortCapabilities (LinkedList <Vessel> vessels) {
        bucketSortCapabilities(vessels, vessels.size());                              //If we change the number of buckets we may see different results
    }

    public static void bucketSortCapabilities (LinkedList <Vessel> vessels, int bucketsNumber) {
        int i;
        int j;

        int index;
        double maxPriorityValue = maxPriorityValue(vessels);

        //We create and initialize buckets
        LinkedList<LinkedList<Vessel>> buckets = new LinkedList<>();
        for (i = 0; i <= bucketsNumber; i++) {
            buckets.add(new LinkedList<>());
        }

        //We put the different elements of the vessel list in different buckets
        for (i = 0; i < vessels.size(); i++) {
            index = (int) ((vessels.get(i).getCapabilitiesRating() / maxPriorityValue) * (bucketsNumber - 1));
            //System.out.println ("INDEX: " + index);
            buckets.get(index).add(vessels.get(i));
        }

        index = 0;

        //We sort each individual bucket
        for (i = 0; i < bucketsNumber; i++) {
            quickSort(buckets.get(i), 0, buckets.get(i).size() - 1, false);
            buckets.set(i, buckets.get(i));
        }


        //We put all the buckets back together into the vessels list, creating a sorted arraylist
        for (i = 0; i < bucketsNumber; i++) {
            for (j = 0; j < buckets.get(i).size(); j++) {
                vessels.set(index, buckets.get(i).get(j));
                index++;
            }
        }

    }

    public static void bucketSortCapabilitiesMerge (LinkedList <Vessel> vessels) {
        bucketSortCapabilities(vessels, vessels.size());                              //If we change the number of buckets we may see different results
    }

    public static void bucketSortCapabilitiesMerge (LinkedList <Vessel> vessels, int bucketsNumber) {
        int i;
        int j;

        int index;
        double maxPriorityValue = maxPriorityValue(vessels);

        //We create and initialize buckets
        LinkedList<LinkedList<Vessel>> buckets = new LinkedList<>();
        for (i = 0; i <= bucketsNumber; i++) {
            buckets.add(new LinkedList<>());
        }

        //We put the different elements of the vessel list in different buckets
        for (i = 0; i < vessels.size(); i++) {
            index = (int) ((vessels.get(i).getCapabilitiesRating() / maxPriorityValue) * (bucketsNumber - 1));
            //System.out.println ("INDEX: " + index);
            buckets.get(index).add(vessels.get(i));
        }

        index = 0;

        //We sort each individual bucket
        for (i = 0; i < bucketsNumber; i++) {
            mergeSortName(buckets.get(i));
            buckets.set(i, buckets.get(i));
        }


        //We put all the buckets back together into the vessels list, creating a sorted arraylist
        for (i = 0; i < bucketsNumber; i++) {
            for (j = 0; j < buckets.get(i).size(); j++) {
                vessels.set(index, buckets.get(i).get(j));
                index++;
            }
        }

    }
}






