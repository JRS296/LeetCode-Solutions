import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        ArrayList<Integer> a2 = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]%2==0)
            {
                a1.add(nums[i]);
            }
            else if(nums[i]%2!=0)
            {
                a2.add(nums[i]);
            }
        }
        
        a1.addAll(a2);
        System.out.println(a1);
        for (int i = 0; i < a1.size(); i++)
            nums[i] = a1.get(i);
        return nums;
    }
}

/*
Runtime: 8 ms (above 6.42% so poor)
Memory Usage: 43.3 MB (above 91% - pretty good)
Work on time complexity
 */

class Solution2 {
    public int[] sortArrayByParity(int[] nums) {
        //ArrayList<Integer> a1 = new ArrayList<Integer>(nums.length);
        ArrayList<Integer> a1 = new ArrayList<Integer>(Collections.nCopies(nums.length, 0));
        System.out.println(a1);
        int j = nums.length - 1;
        int k = 0;
        for(int x: nums)
        {
            if(x%2==0)
            {
                a1.set(k, x);
                k++;
                //System.out.println(a1+" "+k);
            }
            if(x%2!=0)
            {
                a1.set(j, x);
                j--;
                //System.out.println(a1);
            }
        }
        for (int i = 0; i < a1.size(); i++)
            nums[i] = a1.get(i);
        return nums;
    }
}

/*
Runtime: 16 ms (above 5% so poor)
Memory Usage: 50 MB (very poor)
Work on time complexity
 */

 //Optimal Solution: (using within 1 array)
 class SolutionOp1 {
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }

        return A;
    }
}

/*
Runtime: 1 ms (perfect))
Memory Usage: 48 MB (above 22%)
O(N) - Time, O(1) - Space
 */

class SolutionOp2 {
    public int[] sortArrayByParity(int[] A) {
        int[] ans = new int[A.length];
        int t = 0;

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 0)
                ans[t++] = A[i];

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 1)
                ans[t++] = A[i];

        return ans;
    }
}
// Runtime: 2 ms (above 50%)
// Memory Usage: 48 MB (above 38%)
// O(N) - Time, O(N) - Space