//Attempt #1 - 5mins
class Solution {
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++)
            // calling function without passing the number of rotations
            rotateArrayByOne(nums, nums.length);
    }

    public static void rotateArrayByOne(int array[], int n) {
        int i, temp;
        // temporary array to store the newly created array
        temp = array[n - 1];
        for (i = n - 1; i > 0; i--)
            // shifts array element to the left by 1
            array[i] = array[i - 1];
        array[0] = temp;
    }
}
/*
 * Time Limit Exceeded: 37 / 38 test cases passed.
 * Time Complexity: O(n^2)
 */

// Attempt #2 - 16 mins
class Solution2 {
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1)
            return;
        int ans[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i + k > nums.length - 1) {
                ans[(i + k) % nums.length] = nums[i];
            } else {
                ans[i + k] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }
        // stem.out.println(Arrays.toString(ans));
    }
}
/*
 * 38 / 38 test cases passed.
 * Status: Accepted
 * Runtime: 3 ms
 * Memory Usage: 64.5 MB
 */

// Optimal Solution
class Solution3 {
    public void rotate(int[] nums, int k) {

        if (nums == null || nums.length < 2) {
            return;
        }

        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

    }

    private void reverse(int[] nums, int i, int j) {
        int tmp = 0;
        while (i < j) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
/*
38 / 38 test cases passed.
Status: Accepted
Runtime: 2 ms
Memory Usage: 63.7 MB
 */

/*
The basic idea is that, for example, nums = [1,2,3,4,5,6,7] and k = 3, first we reverse [1,2,3,4], 
it becomes[4,3,2,1]; then we reverse[5,6,7], it becomes[7,6,5], finally we reverse the array as a 
whole, it becomes[4,3,2,1,7,6,5] ---> [5,6,7,1,2,3,4].

Reverse is done by using two pointers, one point at the head and the other point at the tail, after
 switch these two, these two pointers move one position towards the middle.
 */