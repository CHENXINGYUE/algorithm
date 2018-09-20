package sort;
import java.util.Arrays;

//MergeSort 递归版
public class MergeSort {

    public void mergeSort(int[] nums, int low, int high) {
        if (nums == null || nums.length == 0) {
            return;
        }
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    public void merge(int[] nums, int low, int mid, int high) {
        System.out.println(Arrays.toString(nums));
        if (low >= high)
            return;
        int[] temp = new int[high - low + 1];
        int index = 0;
        int i = low;//左指针
        int j = mid + 1;//右指针
//        1.
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[index++] = nums[i++];
            } else {
                temp[index++] = nums[j++];
            }
        }
//2.
        while (i <= mid) {
            temp[index++] = nums[i++];
        }
//3.
        while (j <= high) {
            temp[index++] = nums[j++];
        }

        for (int k = 0; k < temp.length; k++) {
            nums[low + k] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] nums = {6, 5, 4, 3, 2, 1};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }
}
