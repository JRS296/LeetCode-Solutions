//Attempt #1 - NA - REDO

class Solution {
    
    private static final String START = "0000";
    
    public int openLock(String[] deadends, String target) {
        if (target == null || target.length() == 0) return -1;
        Set<String> visited = new HashSet<>(Arrays.asList(deadends)); //Very important
        Queue<String> queue = new LinkedList<>();
        int level = 0;
        queue.offer(START);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentLock = queue.poll();
                if (!visited.add(currentLock)) continue;
                if (currentLock.equals(target)) return level;
                
                for (String nextLock : getNextStates(currentLock)) {
                    if (!visited.contains(nextLock)) queue.offer(nextLock);
                }
            }
            level++;
        }
        
        return -1;
    }
    
    private List<String> getNextStates(String lock) {
        List<String> locks = new LinkedList<>();
        char[] arr = lock.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            arr[i] = c == '9' ? '0' : (char) (c + ((char) 1));
            locks.add(String.valueOf(arr));
            arr[i] = c == '0' ? '9' : (char) (c - ((char) 1));
            locks.add(String.valueOf(arr));
            arr[i] = c;
        }
        return locks;
    }
}

/*
Runtime
113 ms
Beats
78.67%
Memory
50.5 MB
Beats
66.57%

Time: O(n)
Space: O(2n)
 */