package com.epam.mjc.stage0;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {

        String[] seasons = {"Winter","Spring","Summer","Autumn"};
        return seasons;
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] arr= new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i+1;
        }
        return arr;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        return sum;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==number)
                return i;

        }
        return -1;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        String[] reverse = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reverse[i]=arr[arr.length-i-1];
        }
        return reverse;

    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr ) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                count++;
            }
        }

        int[] positive = new int[count];
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                positive[j] = arr[i];
                j++;
            }
        }

        return positive;

    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public static int[][] sortRaggedArray(int[][] arr) {

        int[][] sorted = new int[arr.length][];
        int prev,cur;
        int[] save;

        for (int i = 0; i < arr.length; i++) {
            sorted[i] = new int[arr[i].length];
            for (int k = 1; k <= arr.length; k++) {

                for (int j = 0; j < arr[i].length-k; j++) {
                /*if(j== arr[i].length){
                    continue;
                }*/

                    if(k==1) {
                        prev = arr[i][j];
                        cur = arr[i][j + 1];
                    }
                    else
                    {
                        prev = sorted[i][j];
                        cur = sorted[i][j + 1];
                    }
                    if(prev<=cur)
                    {
                        sorted[i][j]=prev;
                        sorted[i][j+1]=cur;
                    }
                    else {
                        sorted[i][j]=cur;
                        sorted[i][j+1]=prev;
                    }
                 }

              /*  for (int k = 0; k < sorted[i].length-1; k++) {
                    if(sorted[i][k]>sorted[i][k+1])
                    {    save = sorted[i][k];
                        sorted[i][k]=sorted[i][k+1];
                        sorted[i][k+1] =save;
                    }

                }*/


               }
          }
        for (int z = 0; z < arr.length-1; z++) {
                if(sorted[z].length>sorted[z+1].length)
                {
                    save = sorted[z];
                    sorted[z]=sorted[z+1];
                    sorted[z] =save;

                }
            }

        return sorted;
    }
    public static void main(String[] args) {
        int [][] arr = {{3,2323 ,1, 2,123,2323},{3,1}};
        int[][] sortedArray = sortRaggedArray(arr);

        // Print the sorted array
        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = 0; j < sortedArray[i].length; j++) {
                System.out.print(sortedArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}


