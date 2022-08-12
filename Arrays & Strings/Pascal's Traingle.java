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
                    System.out.println(ret.get(i-1)+" "+j);
                    int x = ret.get(i-1).get(j) + ret.get(i-1).get(j+1);
                    System.out.println(x);
                    ret.get(i-1).set(j+1,x);
                }
            }
        }
        
        return ret;
    }
}