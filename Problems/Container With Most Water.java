//Attempt #1 - 22mins

class Solution {
    public int maxArea(int[] height) {
        int great = -1;
        int grInd = -1;
        int maxVol = -1;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > great) {
                great = height[i];
                grInd = i;
            }
        }

        for (int i = 0; i < height.length; i++) {
            maxVol = Math.max(maxVol, getWater(i, grInd, height));
        }

        return maxVol;
    }

    public int getWater(int x, int y, int[] z) {
        int a = Math.abs(x - y);
        if (z[x] > z[y]) {
            return a * z[y];
        } else {
            return a * z[x];
        }
    }
}

/*
27 / 60 test cases passed.
 */

//Optimal Solution - Two pointer apporach attempt - 25 mins WITH HINT

class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int maxVol = 0;
        //System.out.println(l+" "+r);
        while(l<r)
        {
            //System.out.println(l+" "+r);
            maxVol = Math.max(maxVol, Math.min(height[l],height[r])*(r-l));
            if(height[l]<height[r])
            {
                l++;
            }
            else{
                r--;
            }
            
        }
        return maxVol;
    }
}