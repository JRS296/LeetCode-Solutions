//Attempt #1 - 5mins
//Link: https://leetcode.com/explore/learn/card/recursion-i/255/recursion-memoization/1661/

class Solution {
    public int fib(int N) {
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        if (cache.containsKey(N)) {
      return cache.get(N);
    }
    int result;
    if (N < 2) {
      result = N;
    } else {
      result = fib(N-1) + fib(N-2);
    }
    // keep the result in cache.
    cache.put(N, result);
    return result;
    }
}

/*

31 / 31 test cases passed.
Status: Accepted
Runtime: 245 ms
Memory Usage: 41.4 MB

HORRIBLY SLOW
 */

//My optimal non recursive soln
class Solution {
  public int fib(int N) {
      if(N==0 || N==1)
          return N;
      int arr[] = new int[N+1];
      arr[0] = 0;
      arr[1] = 1;
      
      
      int ans = 0;
      for(int i=2; i<N+1; i++)
      {
          arr[i] = arr[i-1] + arr[i-2];
      }
      
      return arr[N];
  }
}

/*
Runtime
0 ms
Beats
100%
Memory
38.9 MB
Beats
87.68%
 */