//Attempt #1 - 15mins
//Link: https://leetcode.com/problems/gas-station/description/

//Logic: https://leetcode.com/problems/gas-station/solutions/3011456/java-solution-with-explanation/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas = 0;
        int totalcost = 0;

        for (int i = 0; i < gas.length; i++) {
            totalgas += gas[i];
            totalcost += cost[i];
        }

        if (totalgas < totalcost)
            return -1;

        int remainsGas = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            remainsGas = remainsGas + (gas[i] - cost[i]);
            // System.out.println(remainsGas + " " + start);
            if (remainsGas < 0) {
                start = i + 1;
                remainsGas = 0;
            }
        }
        return start;
    }
}

/*
 * Runtime
 * 1 ms
 * Beats
 * 100%
 * Memory
 * 62.2 MB
 * Beats
 * 88.8%
 */