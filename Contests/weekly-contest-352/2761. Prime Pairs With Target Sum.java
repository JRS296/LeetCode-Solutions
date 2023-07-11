import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        boolean listofprimes[] = helper(1, n);
        for(int i=1; i<n+1; i++) {
            if(listofprimes[i] && listofprimes[n-i]) {
                ans.add(new ArrayList<Integer>(Arrays.asList(i, n-i)));
                listofprimes[i] = false;
            }
        }
        //System.out.println(Arrays.toString(listofprimes));
        return ans;
    }
    
    public static boolean[] helper(int start, int n)
    {
        boolean[] prime = new boolean[n + 2];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
 
        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }

        return prime;
    } 
}