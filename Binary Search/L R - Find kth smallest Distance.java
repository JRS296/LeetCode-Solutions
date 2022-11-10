//Attempt #1 - 9mins+

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        ArrayList<String> ans = new ArrayList<String>();
        generatePermutation("1234", 0, 2, ans); 
        System.out.println(ans);
        return 0;
    }
    
    public static void generatePermutation(String str, int start, int end, ArrayList<String> ans) {
        if (start == end - 1)
            ans.add(str);// Prints the permutations
        else {
            for (int i = start; i < end; i++) {
                str = swapString(str, start, i); // Swapping the string by fixing a character
                generatePermutation(str, start + 1, end); // Recursively calling function generatePermutation() for rest of the characters
                str = swapString(str, start, i); // Backtracking and swapping the characters again.
            }
        }
    }
}

/*

 */