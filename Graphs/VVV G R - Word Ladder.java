//Attempt #1 - DNA
//Link: https://leetcode.com/problems/word-ladder/description/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Ans obj = new Ans();
        return obj.wordLadderLength(beginWord, endWord, wordList);
    }
}

class Pair {
    String first;
    int second;

    Pair(String _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}

class Ans {
    public int wordLadderLength(String startWord, String targetWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();

        // BFS traversal with pushing values in queue
        // when after a transformation, a word is found in wordList.
        q.add(new Pair(startWord, 1));

        // Push all values of wordList into a set
        // to make deletion from it easier and in less time complexity.
        Set<String> st = new HashSet<String>();
        int len = wordList.size();
        for (int i = 0; i < len; i++) {
            st.add(wordList.get(i));
        }
        st.remove(startWord);

        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();

            // we return the steps as soon as
            // the first occurence of targetWord is found.
            if (word.equals(targetWord) == true)
                return steps;

            // Now, replace each character of ‘word’ with char
            // from a-z then check if ‘word’ exists in wordList.
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    // check if it exists in the set and push it in the queue.
                    if (st.contains(replacedWord) == true) {
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }

            }
        }
        return 0;
    }
}