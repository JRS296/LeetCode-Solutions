//Attempt #1 - 1hr
//Link: 

class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        // IDEA -> Use Binary search to find optimal number of trips between best and
        // worst case
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        if (time.length == 1 && time[0] < totalTrips)
            return totalTrips;
        else if (time.length == 1 && time[0] > totalTrips)
            return time[0];

        for (int x : time) {
            low = Math.min(low, x);
            high = Math.max(high, x);
        }
        high *= totalTrips; // Worst Case Scenario
        int mid = 0;

        while (low < high) {
            mid = low + (high - low) / 2;
            int completedTrips = 0;
            int flag = 0;

            for (int i = 0; i < time.length; i++) {
                completedTrips += (mid / time[i]);
            }
            if (completedTrips >= totalTrips) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}

/*
 * 93 / 123 testcases passed
 */

// Solution:
class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long lowestTime = 1;
        long maxTime = 100000000000000L;
        while (lowestTime < maxTime) {
            long mid = lowestTime + (maxTime - lowestTime) / 2;
            long tripsDone = tripsCompleted(time, mid, totalTrips);
            if (tripsDone >= totalTrips) {
                maxTime = mid;
            } else {
                lowestTime = mid + 1;
            }
        }
        return lowestTime;
    }

    private long tripsCompleted(int[] time, long currentTime, int totalTrips) {
        long tripsDone = 0;
        for (int t : time) {
            long tmp = (long) t;
            tripsDone += (currentTime / tmp);
            // instead of iterating the loop any further, break the loop.
            if (tripsDone >= totalTrips) {
                break;
            }
        }
        return tripsDone;
    }
}

/*
Runtime
183 ms
Beats
91.94%
Memory
57.4 MB
Beats
18.30%
 */