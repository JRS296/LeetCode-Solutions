//Attempt #1 - 110 mins
//Link: https://leetcode.com/problems/jump-game-ii/description/

class Solution {
    public int jump(int[] nums) {
        int count = 0;

        Queue<Integer> queue = new LinkedList<Integer>();


        queue.offer(0); // queue.add(root) - offer returns false if unsuccessful
        while (!queue.isEmpty()) {
            //System.out.println(queue + " ------   " + queue.size());
            int levelNum = queue.size();
            count++;

            for(int j=0; j<levelNum; j++)
            {
                if(queue.peek()==nums.length-1)
                    return count-1;
                int x = nums[queue.peek()];
                for (int i = queue.peek()+1; i <= queue.peek()+x; i++) {
                    queue.offer(i);
                //System.out.print(queue.poll() + " ");
                //sublist.add(nums[queue.poll()]);
                
                // Same as queue.remove() - poll() will not return error if q is empty.
                }
                queue.poll();
            }
        }
        return count;
    }
}

/*
TLE: 82/109
Using BFS to get size
 */

//Solution 1 - https://leetcode.com/problems/jump-game-ii/solutions/3158136/beats-99-beginner-level-easy-solution-java-explained/
class Solution1 {
    public int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int max = 0;
        int curr = 0;
        int count = 0;
        for(int i = 0 ; i < nums.length - 1 ; i++){
            max = Math.max(max , i + nums[i]);
            if(curr == i){
                curr = max;
                count++;
            }
            if(curr>nums.length-1){
                return count;
            }
        }
        return count;
    }
}
/*
Runtime
1 ms
Beats
99.45%
Memory
42.7 MB
Beats
64.47%

Time - O(n)
Space - O(1)
 */

//Solution 2 (Implicit BFS) - https://leetcode.com/problems/jump-game-ii/solutions/3158169/clean-codes-full-explanation-implicit-bfs-c-java-python3/

class Solution2 {
    public int jump(int[] nums) {
      int ans = 0;
      int end = 0;
      int farthest = 0;
  
      // Implicit BFS
      for (int i = 0; i < nums.length - 1; ++i) {
        farthest = Math.max(farthest, i + nums[i]);
        if (farthest >= nums.length - 1) {
          ++ans;
          break;
        }
        if (i == end) {   // Visited all the items on the current level
          ++ans;          // Increment the level
          end = farthest; // Make the queue size for the next level
        }
      }
  
      return ans;
    }
  }

/*
Runtime
1 ms
Beats
99.45%
Memory
42.5 MB
Beats
83.82%
Time - O(n)
Space - O(1)
 */

//Solution 3 (Greedy) - https://leetcode.com/problems/jump-game-ii/solutions/3158071/greedy-o-n-with-video-java-c-python/
class Solution3 {
    public int jump(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int currEnd = 0;
        int currFarthest = 0;
        
        for(int i = 0;i<n-1;i++){
            currFarthest = Math.max(currFarthest, i+ nums[i]);
            if(i==currEnd){
                ans++;
                currEnd = currFarthest;
            }
        }
        return ans;
    }
}
/*
Runtime
1 ms
Beats
99.45%
Memory
43.2 MB
Beats
33.57%
Time - O(n)
Space - O(1)
 */