//Attempt #1 - 1hr
//Link: https://leetcode.com/problems/max-points-on-a-line/

class Solution {
    public int maxPoints(int[][] points) {
        int finans = 0;
        int counter = 0;
        if(points.length == 1)
            return 1;
        else if(points.length == 2)
            return 2;
        for(int i=0; i<points.length; i++)
        {    int x1=points[i][0],y1=points[i][1];
            for(int j=i+1; j<points.length; j++)
            {
                int x2=points[j][0],y2=points[j][1];
                // System.out.println(x1 + " " + y1);
                // System.out.println(x2 + "*" + y2);
                if((x2-x1)!=0)
                {
                    double m = (y2-y1)/(x2-x1);
                    double c = y1 - (m*x1);
                    counter = 0;
                    for(int k=0; k<points.length; k++)
                    {
                        int x3=points[k][0],y3=points[k][1];
                        if(y3-(m*x3) == c)
                        {
                            counter++;
                        }
                    }
                }
                else
                {
                    counter = 0;
                    for(int k=0; k<points.length; k++)
                    {
                        int x3=points[k][0],y3=points[k][1];
                        if(x3==x1)
                        {
                            counter++;
                        }
                    }
                }
                
                System.out.println(counter);
                finans = Math.max(counter, finans);
            }
            //System.out.println();
        }

        return finans;
    }

    // public int dist(int x1, int y1, int x2, int y2)
    // {
    //     return (Math.sqrt((x1-x2)));
    // }
}

/*
Test Cases Passed: 26/35
 */

//Attempt #2 - 25mins 

class Solution {
    public int maxPoints(int[][] points) {
        int finans = 0;
        int counter = 0;
        if (points.length == 1) return 1;

        for(int i=0; i<points.length; i++)
        {    int x1=points[i][0],y1=points[i][1];
            for(int j=i+1; j<points.length; j++)
            {
                int x2=points[j][0],y2=points[j][1];
                
                if((x2-x1)!=0)
                {
                    double m = (y2-y1)/(double)(x2-x1); //Double goes a looooong way
                    double c = y1 - (m*x1);
                    // System.out.println("M: "+m+ " C:"+c);
                    counter = 0;
                    for(int k=0; k<points.length; k++)
                    {
                        int x3=points[k][0],y3=points[k][1];
                        // System.out.println(x3 + " " + y3);
                        //System.out.println(y3-(m*x3) + " " + c);

                        double a = Math.round((y3-(m*x3))*100000000); //Math rounding, ALSO goes a looooong way
                        double b = Math.round((c)*100000000);
                        //System.out.println(a + " " + b);
                        if(a == b)
                        {
                            counter++;
                            // System.out.println("Hello");
                        }
                    }
                }
                else
                {
                    counter = 0;
                    for(int k=0; k<points.length; k++)
                    {
                        int x3=points[k][0],y3=points[k][1];
                        if(x3==x1)
                        {
                            counter++;
                        }
                    }
                }
                
                //System.out.println(counter);
                finans = Math.max(counter, finans);
            }
            //System.out.println();
        }

        return finans;
    }

}

/*
Runtime
271 ms
Beats
5.45%
Memory
39.9 MB
Beats
96.49%

Time Complexity: O(n^3) - Brute force used, slow over here for some reason
Space Complxity: O(1)
 */


//Solution 1 (O(n^3))
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n == 1) return n;
        int result = 0;
        for(int i = 0; i< n; i++){
            for(int j = i+1; j< n; j++){
                result = Math.max(result, getPoints(i, j, points));
            }
        }
        return result;
    }
    private int getPoints(int pt1, int pt2, int[][] points){
        int[] point1 = points[pt1], point2 = points[pt2];
        double slope = (point1[1] - point2[1])/(double)(point1[0] - point2[0]);
        int result = 0;
        for(int i = 0; i<points.length; i++){
            if((points[i][0] == point1[0] && points[i][1] == point1[1]) || 
               (slope == Double.POSITIVE_INFINITY && (point1[1] - points[i][1])/(double)(point1[0] - points[i][0]) == Double.POSITIVE_INFINITY) || 
               ((double)(point1[1] - points[i][1])/(double)(point1[0] - points[i][0]) == slope)) 
                result++;
        }
        return result;
    }
}

/*
Runtime
44 ms
Beats
61.84%
Memory
40.1 MB
Beats
95.59%
 */

//Optimal Solution - O(n^2)

class Solution {
    public int maxPoints(int[][] arr) {
      int max = 1;
      for (int i = 0; i < arr.length; i++) {
          HashMap<Double, Integer> map = new HashMap<>();
          for (int j = 0; j < arr.length; j++) {
              if (i == j) continue;
              double slope = (arr[j][0] - arr[i][0]) != 0 ? (arr[j][1] - arr[i][1]) * 1.0 / (arr[j][0] - arr[i][0]) : Integer.MAX_VALUE;
              map.put(slope, map.getOrDefault(slope, 1) + 1);
              max = Math.max(max, map.get(slope));
          }
      }
      return max;
  }
}

/*
Runtime
22 ms
Beats
88.57%
Memory
42.5 MB
Beats
71.2%

Time: O(n^2)
Space: O(1)

Works on using Hmap to hold count of points that posess same slope relative to iterated point
 */