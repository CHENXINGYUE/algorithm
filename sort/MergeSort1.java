package sort;

import java.util.Arrays;

//MergeSort非递归
public class MergeSort1 {

    public void mergeSort(int[] nums) {
//   range等于1,2,4,8...
        int range = 1;
        while (range < nums.length) {
            int start = 0;
            while (start + range <= nums.length) {
                merge(nums, start, range);
                start = start + range*2;
            }
            range = range * 2;
        }
    }

    public void merge(int[] nums, int start, int range) {
        int i = start;
        int j = start + range;

        if(j>=nums.length)
            return;

        int len1 = range;
        int len2 = start + range*2- nums.length > 0 ? Math.min(range, start + range*2- nums.length) : range;

        int max1 = start + range;
        int max2 = Math.min(nums.length, start + range + len2);

        int[] temp = new int[len1 + len2];

        int k = 0;
        while (i < max1 && j < max2) {
            if (nums[i] < nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }
        while (i < max1){
            temp[k++] = nums[i++];
        }
        while (j < max2){
            temp[k++] = nums[j++];
        }

        for (int m = start; m < start + temp.length; m++) {
            nums[m] = temp[m - start];
        }

    }

    public static void main(String[] args) {
        int[] nums = {6,5,4,3,2,1};
        MergeSort1 mergeSort = new MergeSort1();
         mergeSort.mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
