package Interface;


import java.util.Arrays;
import java.util.List;

/* This class has sort and search algorithms */
 public class SortSearch {
    public static  String[] arr = {"Quebradilla","Tejar", "Cartago", "Paraiso","Turrialba", "Ochomogo", "Tres Rios", "Curridabat", "Desamparados", "San Pedro", "San Jose", "Santa Ana","Ciudad Colon", "Alajuela", "Heredia"};
    public static final List<String> cities = Arrays.asList("Quebradilla","Tejar", "Cartago", "Paraiso","Turrialba", "Ochomogo", "Tres Rios", "Curridabat", "Desamparados", "San Pedro", "San Jose", "Santa Ana","Ciudad Colon", "Alajuela", "Heredia");


    static void swap(String[] arr, int i, int j)
    {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(String [] arr, int low, int high) {
        String pivot = arr[high];
        int i = (low - 1);
        // To create the alphabetic order, it uses character
        for (int j = low; j <= high - 1; j++) {
            if (arr[j].charAt(0) < pivot.charAt(0)) {
                i++;
                swap(arr, i, j);
            }else if (arr[j].charAt(0) == pivot.charAt(0)){
                for(int k = 1; k < pivot.length(); k++){
                    if (arr[j].charAt(k) < pivot.charAt(k)) {
                        i++;
                        swap(arr, i, j);
                        break;
                    }else if (arr[j].charAt(k) == pivot.charAt(k)){
                         continue;
                    }else {
                        break; // if the second char is no lower it has to break the cycle
                    }

                }
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    /*
    Quick sort the String array
     */
    static void quickSort(String[] arr, int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);

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
    //Simple searching method
    public static String linelSearch( String target){
        for(int i = 0; i < cities.size(); i++) {
            if(cities.get(i) .equals(target) ){
                return "found";
            }
        }
        return "notfound";
    }
}
