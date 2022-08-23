import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Attempt #1 - barely 5 mins (copied from Pascal's Triangle 1)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>(rowIndex);
        for(int i=1; i<=rowIndex+1; i++)//Add + 1 to original solution
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
        return ret.get(rowIndex);
    }
}

/*

34 / 34 test cases passed.
Status: Accepted
Runtime: 4 ms
Memory Usage: 42 MB
 */