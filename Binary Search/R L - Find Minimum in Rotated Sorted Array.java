//Attempt #1 - 
//Link: https://leetcode.com/explore/learn/card/binary-search/126/template-ii/949/

/*
All the elements to the left of inflection point > first element of the array.
All the elements to the right of inflection point < first element of the array.
 */

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int l = 0, r = nums.length - 1;

        if (nums[l] < nums[r])
            return nums[l];
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];

            if (nums[mid] < nums[mid - 1])
                return nums[mid];

            if (nums[mid] > nums[0]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }
}

/*
150 / 150 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 43 MB
 */

// Optimal Solution:
class Solution2 {
    public int findMin(int[] nums) {
        // If the list has just one element then return that element.
        if (nums.length == 1) {
            return nums[0];
        }

        // initializing left and right pointers.
        int left = 0, right = nums.length - 1;

        // if the last element is greater than the first element then there is no
        // rotation.
        // e.g. 1 < 2 < 3 < 4 < 5 < 7. Already sorted array.
        // Hence the smallest element is first element. A[0]
        if (nums[right] > nums[0]) {
            return nums[0];
        }

        // Binary search way
        while (right >= left) {
            // Find the mid element
            int mid = left + (right - left) / 2;

            // if the mid element is greater than its next element then mid+1 element is the
            // smallest
            // This point would be the point of change. From higher to lower value.
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // if the mid element is lesser than its previous element then mid element is
            // the smallest
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            // if the mid elements value is greater than the 0th element this means
            // the least value is still somewhere to the right as we are still dealing with
            // elements
            // greater than nums[0]
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                // if nums[0] is greater than the mid value then this means the smallest value
                // is somewhere to
                // the left
                right = mid - 1;
            }
        }
        return Integer.MAX_VALUE;
    }
}

//Understand Case scenario, and the 4 possible breakpoints (the 4 if conditions)