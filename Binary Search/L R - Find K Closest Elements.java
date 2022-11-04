//Attempt #1 - 30mins (DNF)
//Link:

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<Integer>(arr.length);

        for (int i = 0; i < k; i++) {
            ans.add(arr[i]);
        }

        int l = 0;
        int r = arr.length - 1;
        while (l < r) {

            int mid = l + (r - l) / 2;
            System.out.println(l + " " + mid + " " + r);
            if (arr[mid] == x) {
                ans.clear();
                int li = mid - (k / 2);
                for (int i = li; i < li + k; i++) {
                    ans.add(arr[i]);
                }
                break;
            } else if (arr[mid] < k) {
                l = mid + 1;
            } else if (arr[mid] > k) {
                r = mid - 1;
            }
        }
        return ans;
    }
}

/*
 * 8/66 Test Cases Passed
 */

// Attempt #2 - null
public List<Integer> findClosestElements(int[] A, int k, int x) {
    int left = 0, right = A.length - k;
    while (left < right) {
        int mid = (left + right) / 2;
        if (x - A[mid] > A[mid + k] - x)
            left = mid + 1;
        else
            right = mid;
    }
    return Arrays.stream(A, left, left + k).boxed().collect(Collectors.toList());
}

/*

66 / 66 test cases passed.
Status: Accepted
Runtime: 15 ms
Memory Usage: 62.5 MB
 */

// Optimal #1 - using two pointers - O(n)

class Solution2 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0;
        int hi = arr.length - 1;
        while (hi - lo >= k) {
            if (Math.abs(arr[lo] - x) > Math.abs(arr[hi] - x)) {
                lo++;
            } else {
                hi--;
            }
        }
        List<Integer> result = new ArrayList<>(k);
        for (int i = lo; i <= hi; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}

/*

66 / 66 test cases passed.
Status: Accepted
Runtime: 16 ms (beats 46%)
Memory Usage: 60.4 MB (beats 81%)

Time Complexity: O(n)
Space COmplxity: O(n)
 */