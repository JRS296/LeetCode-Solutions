//Attempt #1 - 30mins
//Link: https://leetcode.com/problems/find-the-town-judge/

class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1)
            return 1;
        HashMap<Integer, HashSet<Integer>> ans = new HashMap<Integer, HashSet<Integer>>();
        for(int i[]: trust )
        {
            //System.out.println(i[0]+"--trusts-->"+i[1]);
            if(!ans.containsKey(i[0]))
            {
                ans.put(i[0], new HashSet<Integer>());
                ans.put(i[1], new HashSet<Integer>());
                ans.get(i[0]).add(i[1]);
            }
            else
            {
                ans.get(i[0]).add(i[1]);
                boolean flag = ans.containsKey(i[1]);
                if(!flag)
                {
                    ans.put(i[1], new HashSet<Integer>());
                }
            }
        }
        //System.out.println(ans);
        for(int x: ans.keySet())
        {
            if(ans.get(x).isEmpty())
            {
                int sizeCounter = 0;
                for(HashSet<Integer> y: ans.values())
                {
                    if(y.contains(x))
                    {
                        sizeCounter++;
                    }
                }

                if(sizeCounter==(n-1))
                {
                    return x;
                }
                else
                {
                    continue;
                }
            }
        }

        //System.out.println(x);
        return -1;
    }
}

/*
80 / 92 testcases passed
 */

//Attempt 2 - 5mins

class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1)
            return 1;
        HashMap<Integer, HashSet<Integer>> ans = new HashMap<Integer, HashSet<Integer>>();
        for(int i[]: trust )
        {
            //System.out.println(i[0]+"--trusts-->"+i[1]);
            if(!ans.containsKey(i[0]))
            {
                ans.put(i[0], new HashSet<Integer>());
                //ans.put(i[1], new HashSet<Integer>());
                ans.get(i[0]).add(i[1]);
                boolean flag = ans.containsKey(i[1]);
                if(!flag)
                {
                    ans.put(i[1], new HashSet<Integer>());
                }
            }
            else
            {
                ans.get(i[0]).add(i[1]);
                boolean flag = ans.containsKey(i[1]);
                if(!flag)
                {
                    ans.put(i[1], new HashSet<Integer>());
                }
            }
        }
        //System.out.println(ans);
        for(int x: ans.keySet())
        {
            if(ans.get(x).isEmpty())
            {
                int sizeCounter = 0;
                for(HashSet<Integer> y: ans.values())
                {
                    if(y.contains(x))
                    {
                        sizeCounter++;
                    }
                }

                if(sizeCounter==(n-1))
                {
                    return x;
                }
                else
                {
                    continue;
                }
            }
        }

        //System.out.println(x);
        return -1;
    }
}

/*
Runtime
24 ms
Beats
15.92%
Memory
49.8 MB
Beats
80.90%

Time: O(n^2)
Space: (O(n))
 */

 //Optimal Solution - Graph THeory
 class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0 && n == 1) 
            return 1;
        int[] count = new int[n + 1];
        for (int[] person : trust) {
            count[person[0]]--;
            count[person[1]]++;
        }

        for (int person = 0; person < count.length; person++) {
            if (count[person] == n - 1) return person;
        }
        return -1;
    }
}

 /*
Runtime
15 ms
Beats
34.97%
Memory
74.6 MB
Beats
9.58%
  */

//Optimal 2 - Array Method

class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1 && trust.length == 0) return 1;
        int [] count = new int[n+1];
        for(int i = 0;i<trust.length;i++){
            
            count[trust[i][0]]--;
            
            count[trust[i][1]]++;
        }

       for(int i = 0;i<count.length;i++){
           if(count[i] ==n-1)  return i;
       }
        return -1;
    }
}

/*
Runtime
4 ms
Beats
55.79%
Memory
72.4 MB
Beats
24.33%
 */