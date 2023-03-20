//Attempt #1 - 15mins
//Link: https://leetcode.com/problems/can-place-flowers/description/

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int x = (flowerbed.length + 1)/2;
        int count = 0;
        for(int i=0; i<flowerbed.length; i++) 
        {
            if(flowerbed[i]==1)
                count++;

            // int lb = i-1;
            // int hb = i+1;
            //if((lb==0 || flowerbed[lb]==0) && (hb=flowerbed.length-1 || flowerbed[hb]==0) )
        }
        
        if(count+n>x)
            return false;

        return true;
    }
}

/*
 * 114/125 TC passed
 */

//Attempt #2 - checking all conditions for viable 0 + (required) frontend[i]=1;

    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            if(n==0) return true;

            for(int i=0; i<flowerbed.length; i++) 
            {

                if (flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length-1 || flowerbed[i+1] == 0)) { //All conditions for free 0 is satisfied;
                    flowerbed[i] = 1; //Very Important
                    n--;
                    if(n==0) return true;
                }
            }

            return false;
        }
    }

/*
TC - O(n)
SC - O(1)
*/
   