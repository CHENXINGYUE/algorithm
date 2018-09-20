package sort;

import java.util.Arrays;

public class QuickSort {

    public void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int part = partition(nums, low, high);
            quickSort(nums, low, part - 1);
            quickSort(nums, part+1, high);
        }
    }

    public int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low + 1;
        int j = high;
        while (i <= j) {
            if(nums[i]<pivot){
                i++;
            }else {
                swap(nums, i, j);
                j--;
            }
        }
        swap(nums, low, i-1);
        return i-1;

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {6, 5, 4, 3, 2, 1};
        QuickSort quickSort = new QuickSort();
         quickSort.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
