//Attempt #1 - null
//Link: https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/description/

class Solution {// R L
    private int maxRequests;

    public int maximumRequests(int n, int[][] requests) {
        maxRequests = 0;
        int[] employees = new int[n];
        backtrack(requests, employees, 0, 0);
        return maxRequests;
    }

    private void backtrack(int[][] requests, int[] employees, int index, int count) {
        if (index == requests.length) {
            if (isAchievable(employees)) {
                maxRequests = Math.max(maxRequests, count);
            }
            return;
        }

        int from = requests[index][0];
        int to = requests[index][1];

        employees[from]--;
        employees[to]++;

        backtrack(requests, employees, index + 1, count + 1);

        employees[from]++;
        employees[to]--;

        backtrack(requests, employees, index + 1, count);
    }

    private boolean isAchievable(int[] employees) {
        for (int count : employees) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}