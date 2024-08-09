package Merge_Sort;

// Time complexity : O (N LOG N)
// Space complexity : O (N)
public class MergeSort {
    static void merge(int[] arr, int left, int middle, int right) {
        int[] leftTempArray = new int[middle - left + 2];
        // 2 is added to avoid the out of range error
        int[] rightTempArray = new int[right - middle + 1];

        for (int i =0; i<= middle-left; i++) {
            leftTempArray[i] = arr[left+i];
        }

        for(int i=0; i<right-middle; i++) {
            rightTempArray[i] = arr[middle+1+i];
        }

        leftTempArray[middle-left+1] = Integer.MAX_VALUE;
        rightTempArray[right-middle] = Integer.MAX_VALUE;

        int i =0;
        int j=0;

        for (int k = left; k<=right; k++) {
            if (leftTempArray[i] < rightTempArray[j]) {
                arr[k] = leftTempArray[i];
                i++;
            }
            else {
                arr[k] = rightTempArray[j];
                j++;
            }
        }
    }

    public static void mergeSort(int[] Array, int left, int right) {
        if (right > left) {
            int middle = ( left + right ) / 2;
            mergeSort(Array, left, middle);
            mergeSort(Array, middle+1, right);
            merge(Array, left, middle, right);
        }
    }

    public static void printArray(int[] array) {
        for (int i=0; i< array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }
}
