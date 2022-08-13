import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>(numRows);
        for(int i=1; i<=numRows; i++)
        {
            ArrayList<Integer> a = new ArrayList<Integer>(Collections.nCopies(i, 1));
            ret.add(a);
            if(i>1)
            {
                for(int j=0; j<i-1; j++)
                {
                    //System.out.println(ret.get(i-1)+" "+j);
                    if(j>0 && j<i-1)
                    {
                        int x = ret.get(i-2).get(j) + ret.get(i-2).get(j-1);
                        //System.out.println(x +" "+ret.get(i-1));
                        ret.get(i-1).set(j, x);
                    }
                    //ret.get(i-1).set(j+1,x);
                }
            }
        }
        //System.out.println(ret);
        return ret;
    }
}

/*
Runtime: 1 ms (very Good)
Memory Usage: 42.5 MB (poor but understandable)
 */

class Solution2 {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0 ; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            
            for(int j = 0; j < i + 1 ; j++) {
                if(j == 0 || j == i) {
                    list.add(1);
                }
                else {
                    int a = result.get(i - 1).get(j - 1);
                    int b = result.get(i - 1).get(j);
                    list.add(a + b);
                }
            }
            result.add(list);
         }
        return result;
      }
}

 /*
Runtime: 1 ms (very good)
Memory Usage: 41.4 MB (tops 705, pretty efficient)
  */