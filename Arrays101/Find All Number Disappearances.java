import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0; i<len; i++)
        {
            ans.add(i+1);
        }
        //System.out.println(ans);
        for(int i=0; i<len; i++)
        {
            if(ans.contains(nums[i]))
            {
                ans.remove(ans.indexOf(nums[i]));
            }
        }
        return ans;
    }
}
/*
 * Time Limit Exceeded
 */

class Solution2 {
    public List findDisappearedNumbers(int[] nums) {
        Set h = new HashSet<>();
        Set h1 = new HashSet<>(nums.length);

             for(int i = 0; i<nums.length; i++){
                h.add(nums[i]);
             }
            for(int i=1; i<=nums.length; i++){
                  h1.add(i);
             }  
             h1.removeAll(h);
             List<Integer> a = new ArrayList<>(h1);

             return a;
    }
}

/*
Runtime: 73 ms
Memory Usage: 78.5 MB

Overall, poor solution
 */

class Solution3 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
	int[] res = new int[nums.length + 1];

	for (int num : nums) {
		res[num] = num;
	}

	List<Integer> result = new ArrayList<>(res.length);
	for (int i = 1; i < res.length; i++) {
		if (res[i] == 0) {
			result.add(i);
		}
	}

	return result;
}
}

/*
Runtime: 3 ms
Memory Usage: 50.1 MB

Amazing solution, very simple, beats 100% and 98% of solutions
 */