package Interface;



import java.util.Arrays;
import java.util.List;

public class SortSearch {
    public static  String[] arr = {"Quebradilla","Tejar", "Cartago", "Paraiso","Turrialba", "Ochomogo", "Tres Rios", "Curridabat", "Desamparados", "San Pedro", "San Jose", "Santa Ana","Ciudad Colon", "Alajuela", "Heredia"};
    public static final List<String> cities = Arrays.asList("Quebradilla","Tejar", "Cartago", "Paraiso","Turrialba", "Ochomogo", "Tres Rios", "Curridabat", "Desamparados", "San Pedro", "San Jose", "Santa Ana","Ciudad Colon", "Alajuela", "Heredia");
    // A utility function to swap two elements
    static void swap(String[] arr, int i, int j)
    {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    static int partition(String [] arr, int low, int high) {

        // pivot
        String pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller
            // than the pivot
            if (arr[j].charAt(0) < pivot.charAt(0)) {
                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }else if (arr[j].charAt(0) == pivot.charAt(0)){
                for(int k = 1; k < pivot.length(); k++){
                    if (arr[j].charAt(k) < pivot.charAt(k)) {
                        i++;
                        swap(arr, i, j);
                        break;
                    }
                    break;
                }
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    static void quickSort(String[] arr, int low, int high)
    {
        if (low < high)
        {

            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

   // return sorted array
    static String[] getSortedList(){
        quickSort(arr,0,arr.length-1);
        printArray(arr,arr.length);
        return arr;
    }
    // Function to print an array
    static void printArray(String[] arr, int size)
    {
        for(int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();

    }
    public static String linelSearch( String target){
        for(int i = 0; i < cities.size(); i++) {
            if(cities.get(i) .equals(target) ){
                return "found";

            }
        }
        return "notfound";
    }
}
