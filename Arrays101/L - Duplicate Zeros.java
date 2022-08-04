//Learn how to shift arrays without using arraylist

import java.util.*;

class Solution {
    public void duplicateZeros(int[] arr) {
        
        int zerCount = 0;
        for(int i=0; i<arr.length; i++)
        {
            if (arr[i]==0)
            {
                zerCount++;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>(arr.length+zerCount);
        
        for(int i=0; i<arr.length; i++)
        {
            ans.add(arr[i]);
            if(arr[i]==0)
            {
                ans.add(0);
            }
        }
        
        for(int i=ans.size()-1; i>=arr.length; i--)
        {
            ans.remove(i);
        }
        

        //System.out.println(ans);
        
        for(int i=0; i<arr.length; i++)
        {
            arr[i]=ans.get(i);
        }
    }
}