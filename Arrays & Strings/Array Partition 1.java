import java.util.ArrayList;
import java.util.Collections;

//Attempt #1
class Solution {
    public int arrayPairSum(int[] nums) {
        if(nums.length%2 != 0)
            return 0;
        ArrayList<Integer> ans = new ArrayList<Integer>(nums.length - 1);
        
        func(nums, ans);
        
        for(int i=0; i<nums.length; i++)
        {
            for(int j=i+1; j<nums.length-1; j++)
            {
                if(nums[i]>nums[j])
                {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        //System.out.println(Arrays.toString(nums));
        
        func(nums, ans);
        
        for(int i=0; i<nums.length; i++)
        {
            for(int j=i+1; j<nums.length-1; j++)
            {
                if(nums[i]<nums[j])
                {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        
        func(nums, ans);
        //System.out.println(ans);
        
        return (Collections.max(ans));
    }
    
    public static void func(int nums[], ArrayList<Integer> x) {
        for(int i=0; i<nums.length; i++)//Rotate Array by one each time loop
        {
            int sum = 0;
            for(int j=0; j<nums.length-1; j+=2) 
            {
                //System.out.println(nums[j]+" "+nums[j+1]);
                sum+=((nums[j] < nums[j+1]) ? nums[j] : nums[j+1]);
                //System.out.println(sum);
            }
            //System.out.println(Arrays.toString(nums));
            x.add(sum);
            rotate(nums,nums.length);
        }
    }
    
    public static void rotate(int array[], int n) {
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
35 Test Cases out of 83
Good Time Complexity tho
 */

//Solution: