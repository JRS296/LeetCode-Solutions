//Attempt #1 - 1hr 15 mins
//Link: https://leetcode.com/problems/perfect-squares/

class Solution { // Roughly 8mins left outta 30
    public int numSquares(int n) {
        int noTerms = 1;

        if (n == 1)
            return 1;

        while ((noTerms * noTerms) <= n) {
            noTerms++;
        }
        List<Integer> list = generateSquares(noTerms);
        Collections.reverse(list);
        // System.out.println(list);

        // BFS starts here
        int ans = 999;
        int sum = 0;
        int count;

        for (int i = 0; i < list.size(); i++) {
            sum = list.get(i);
            count = 1;
            for (int j = i; j < list.size(); j++) {
                sum += list.get(j);
                if (sum > n) {
                    sum -= list.get(j);
                    continue;
                } else if (sum <= n) {
                    count++;
                    j--;
                    if (sum == n) {
                        System.out.println(sum + " " + count);
                        break; 
                        /*
                            Need to find method to solve cases like n=43, where it breaks without taking all cases into consideration
                         */
                    }

                }
            }

            ans = Math.min(ans, count);
        }

        return ans;
    }

    public List<Integer> generateSquares(int x) {
        List<Integer> ans = new ArrayList<Integer>(x);
        for (int i = 1; i < x; i++) {
            ans.add(i * i);
        }
        return ans;
    }
}

/*
564/588 Test Cases Passed

Time: O(n^2)
Space: O(n)
 */

//Optimal Soln - Using BFS

// The DP solution is the most popular one, yet somehow I feel like the bfs solution share some light on a more general problem type. Here is the bfs solution. The idea is: a dp array is used to store the original square number, it is initialized as 1. Each time we poll a number from the queue and check each perfect square number. When n is reached, it is the shortest path and dp array gives the result. When the sum is over n, we break. When less than n, we need another round of bfs. dp[curr + i*i] == 0 when it has not been visited before, so we don't need a separate visited array.

public class Solution {
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i*i <= n; i++) {
            if(i*i == n) {
                return 1;
            }
            dp[i*i] = 1;
            q.offer(i*i);
        }
        while (!q.isEmpty()) {
            int curr = q.peek();
            for (int i = 1; i*i <= n-curr; i++) {
                if (curr + i*i == n) {
                    return dp[curr] + 1;
                } else if ((curr + i*i < n) && (dp[curr + i*i] == 0)) {
                    dp[curr + i*i] = dp[curr] + 1;
                    q.offer(curr + i*i);
                } else if (curr + i*i > n) {
                    break;
                }
            }
            q.poll();
        }
        return 0;
    }
}

/*
Runtime
11 ms
Beats
91.90%
Memory
42.2 MB
Beats
71.12%
 */

//Optimal Solution - using DP 
//Didnt know this was a DP q tbh, came close tho

//Link: https://leetcode.com/problems/perfect-squares/solutions/2838778/java-intuitive-dp-explained/

class Solution {
    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();

        int cur = 1;
        // Build the squares array
        while (Math.pow(cur, 2) <= n) {
            squares.add((int) Math.pow(cur++, 2));
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Base case
        dp[0] = 0;
        for (int i = 1; i < n+1; i++ ) {
            // DP transition
            for (int j = 0; j < squares.size() && squares.get(j) <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i-squares.get(j)]);
            }
        }
        return dp[n];

    }
}

/*
Runtime
85 ms
Beats
37.13%
Memory
41.9 MB
Beats
73.30%

Time: O(n*sqrt(n))
 */

//Optimal Solution 2 - using DP
//Link: https://leetcode.com/problems/perfect-squares/solutions/2832376/java-dp-o-sqrt-n-solution/

class Solution {
    public int numSquares(int n) {
        int [] dp = new int[n+1];
        
        for(int i=0;i<=n;i++)dp[i] = Integer.MAX_VALUE;
        
        dp[0]=0;
        int ind=1;
        
        while(ind*ind <= n){
            int square = ind*ind;
            
            for(int i=square;i<=n;i++){
                dp[i] = Math.min(dp[i-square]+1,dp[i]);
            }
            ind++;
        }
        
        return dp[n];
    }
}

/*
Runtime
35 ms
Beats
79.48%
Memory
41.8 MB
Beats
78.9%

Time: O(sqrt(n))
 */