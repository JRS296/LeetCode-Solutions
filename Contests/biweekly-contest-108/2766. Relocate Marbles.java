import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        HashSet<Integer> ans = new HashSet<Integer>();
        for(int x: nums) ans.add(x);
        
        for(int i=0; i<moveFrom.length; i++) {
            int from = moveFrom[i];
            int to = moveTo[i];
            ans.remove(from);
            ans.add(to);
            //Collections.replaceAll(ans,from,to);
        }
        
        ArrayList<Integer> ans2 =  new ArrayList<>(ans);
        Collections.sort(ans2);
        return ans2;
    }
}