//Attempt #1 - 30mins (lost the will to do so, boring day)
//Link: https://leetcode.com/problems/fruit-into-baskets/description/

class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length==1 || fruits.length==2)
            return fruits.length;
    
        int count = 0;
        int counter = 0;
        for(int i=0; i<fruits.length-1; i++)
        {
            counter = 0;
            System.out.print(fruits[i]+" "+fruits[i+1]+" --- ");
            if(fruits[i]==fruits[i+1])
            {
                int x = i+2;
                counter+=1;
                for(int j=i+3; j<fruits.length; j++)
                {
                    if(fruits[j]==x)
                        counter++;
                    else
                        break;
                }
            }
            for(int j=i+2; j<fruits.length; j++)
            {
                System.out.print(fruits[j]);
                if(fruits[j]==fruits[i] || fruits[j]==fruits[i+1])
                {
                    counter++;
                }
                else
                    break;
            }
            System.out.print("---> "+counter);
            System.out.println();
            count = Math.max(count,counter);
        }
        return count+2;
    }
}

/*
51 / 91
 */

//Optimal Soln
class Solution {
    public int totalFruit(int[] fruits) {
        int[] counts = new int[fruits.length];
        int max = 0;
        int currMax = 0;
        int typeCount = 0;
        int start = 0;
        
        for(int i = 0; i < fruits.length; i++) {
            if(counts[fruits[i]] == 0) typeCount++;
            counts[fruits[i]]++;
            currMax++;
            
            while(typeCount > 2 && start < i) {
                counts[fruits[start]]--;
                if(counts[fruits[start]] == 0) typeCount--;
                start++;
                currMax--;
            }
            
            max = Math.max(max, currMax);
        }
        
        return max;
    }
}

/*
Runtime
8 ms
Beats
90.74%
Memory
50.5 MB
Beats
88.15%
 */