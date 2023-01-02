//02.01.23 - Detect Capitals
//Link: https://leetcode.com/problems/detect-capital/

//Attempt #1 - 25mins
class Solution {
    public boolean detectCapitalUse(String word) {
        boolean ans = true;
        int cas = -1;
        if (word.length() == 1)
            return true;

        if (Character.isUpperCase(word.charAt(0)) && Character.isLowerCase(word.charAt(1))) {
            cas = 0;
        } else if (Character.isLowerCase(word.charAt(0))) {
            cas = 1;
        } else if (Character.isUpperCase(word.charAt(0))) {
            cas = 2;
        } else {
            ans = false;
        }

        for (int i = 0; i < word.length(); i++) {
            if (cas == 0) {
                if (i == 0)
                    continue;
                else if (!Character.isLowerCase(word.charAt(i))) {
                    ans = false;
                    break;
                }
            } else if (cas == 1) {
                if (!Character.isLowerCase(word.charAt(i))) {
                    ans = false;
                    break;
                }
            } else if (cas == 2) {
                if (!Character.isUpperCase(word.charAt(i))) {
                    ans = false;
                    break;
                }
            } else {
                ans = false;
            }
        }

        return ans;
    }
}

/*
 * Runtime
 * 1 ms
 * Beats
 * 100%
 * Memory
 * 40.5 MB
 * Beats
 * 95.10%
 */

//Simplified Solution
class Solution2 {
    public boolean detectCapitalUse(String word) {
        if(word.length() == 0 || word.length() == 1) return true;
        
        if(Character.isUpperCase(word.charAt(0))){
            boolean isFirstCharacter = Character.isUpperCase(word.charAt(1));
            for(int i = 2; i < word.length(); i++){
                boolean currentCharState = Character.isUpperCase(word.charAt(i));
                if(currentCharState != isFirstCharacter) return false;
            }
        }else{
            for(int i = 1; i < word.length(); i++){
                if(Character.isUpperCase(word.charAt(i))) return false;
            }
        }
        return true;
    }
}