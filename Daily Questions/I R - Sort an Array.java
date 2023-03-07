//Attempt #1 - 22mins
//Link: https://leetcode.com/problems/sort-an-array/description/

// class Solution {
//     public int[] sortArray(int[] nums) { //Basically Quick Sort
//         int size = nums.length;
//         Quicksort.quickSort(nums, 0, size - 1);
//         return nums;
//     }
// }

// class Quicksort {
//   static int partition(int array[], int low, int high) {
//     int pivot = array[high];
//     int i = (low - 1);
//     for (int j = low; j < high; j++) {
//       if (array[j] <= pivot) {
//         i++;
//         int temp = array[i];
//         array[i] = array[j];
//         array[j] = temp;
//       }

//     }
//     int temp = array[i + 1];
//     array[i + 1] = array[high];
//     array[high] = temp;
//     return (i + 1);
//   }

//   static void quickSort(int array[], int low, int high) {
//     if (low < high) {
//       int pi = partition(array, low, high);
//       quickSort(array, low, pi - 1);
//       quickSort(array, pi + 1, high);
//     }
//   }
// } 
/*
TLE -> 15/19 Test Cases Passed
 */


public class Solution {
    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for (int p = 0; p < k; p++) {
            nums[left + p] = temp[p];
        }
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
}

/*
Runtime
34 ms
Beats
62.37%
Memory
53.3 MB
Beats
46.30%
 */