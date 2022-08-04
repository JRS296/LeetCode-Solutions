import java.util.*;
import java.lang.*;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        // for(int i=0; i<nums.length; i++)
        // {
        //     int count = 0;
        //     for(int j=i; j<nums.length; j++)
        //     {
        //         if(nums[j]==0)
        //         {
        //             i=j;
        //             break;
        //         }
        //         else if(nums[j]==1)
        //         {
        //             count++;
        //         }
        //         System.out.println(count + " " + j);
        //     }
        //     if (count>ans)
        //     {
        //         ans = count;
        //     }
        // }
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++)
        {
            
            if (nums[i]==0)
            {
                a.add(ans);
                ans = 0;
            }
            else if(nums[i]==1)
            {
                ans+=1;
                if(i==nums.length-1)
                {
                    a.add(ans);
                }
            }
            // else if(i==nums.length-1 && nums[i]==1)
            // {
            //     ans+=1;
            //     a.add(ans);
            // }
            System.out.println(nums[i] + " " + ans);
        }
        System.out.println(a);
        int finAns = 0;
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
            if (finAns < a.get(i))
                finAns = a.get(i);
        }
        return finAns;
    }
}