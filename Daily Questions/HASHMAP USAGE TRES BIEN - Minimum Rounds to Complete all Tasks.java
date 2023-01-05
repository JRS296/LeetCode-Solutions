//Attempt #1 - 29mins + 1sneak peek
//Link: https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/

class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        int ans = 0;
        for(int x: tasks)
        {
            if(hmap.containsKey(x))
            {
                int y = hmap.get(x)+1;
                hmap.put(x,y);
            }
            else
            {
                hmap.put(x,1);
                q.add(x);
            }  
        }
        int leng = q.size();
        for(int i=0; i<leng; i++)
        {
            int tar = q.peek();
            int freq = hmap.get(tar);
            //System.out.println(tar+" "+freq);
            // if(freq==2||freq==3)
            // {
            //     ans++;
            //     System.out.println("Yus");
            // }
            if(freq==1)
            {
                return -1;
            }
            // else if(freq%3==0)
            // {
            //     ans+=freq/3;
            // }
            // else 
            // {
            //     ans++;
            // }
            ans += freq / 3;
            if(freq % 3 != 0) 
                ans++;

            //System.out.println(ans);
            q.remove();
        }
        return ans;
    }
}

/*
Runtime
124 ms
Beats
10.43%
Memory
139.8 MB
Beats
5.5%
 */

//Optimized Solution - w/o Queue
class Solution1 {
    // This function returns the minimum number of rounds needed to
    // process all tasks in the given array of tasks.
    public int minimumRounds(int[] tasks) {

        // Create a HashMap to store the count of each task
        HashMap<Integer, Integer> getCount = new HashMap<>();

        // Iterate through the tasks array and store the count of each task
        // in the HashMap
        for (int t : tasks) {
            getCount.put(t, getCount.getOrDefault(t, 0) + 1);
        }

        // Initialize a result variable to 0
        int result = 0;

        // Iterate through the values in the HashMap (which represent the counts of the tasks)
        for (int count : getCount.values()) {
            // If a task has a count of 1, it cannot be grouped with other tasks
            // and so we return -1
            if (count == 1) return -1;

            // Add the number of rounds needed to process the tasks with count greater than or equal to 3
            result += count / 3;

            // If there are any tasks left with count less than 3, we need an additional round
            // to process these tasks
            if(count % 3 != 0) result++;
        }

        // Return the total number of rounds needed to process all tasks
        return result;
    }
}
/*
Runtime
86 ms
Beats
41.4%
Memory
108.8 MB
Beats
16.52%
 */

//Method 2 - no hmap, very fast
class Solution2 {
    public int minimumRounds(int[] tasks) {
        // Sort the tasks array in ascending order
        Arrays.sort(tasks);
        int result = 0, count = 0;
        // Iterate through each task
        for (int i = 0; i < tasks.length; i++) {
            // Increment the count of tasks with the same value
            count++;
            // If we have reached the last task or the current task is different from the next task
            if (i == tasks.length - 1 || tasks[i] != tasks[i + 1]) {
                // If there is only one task with this value, we cannot create groups of 3
                // and we return -1
                if (count == 1) {
                    return -1;
                }
                // Add the number of full groups of 3 we can create from the tasks with this value
                result += count / 3;
                // If there are remaining tasks that cannot be included in a group of 3,
                // we need one more round to process these tasks
                if(count % 3 != 0) result++;
                // Reset the count for the next set of tasks
                count = 0;
           }
        }
        // Return the total number of rounds needed
        return result;
    }
}
/*
Runtime
11 ms
Beats
98.9%
Memory
51.5 MB
Beats
97.57%
 */