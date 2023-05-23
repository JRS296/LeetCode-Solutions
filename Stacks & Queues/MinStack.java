//Attempt #1 - 10mins
//Link: https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1360

class MinStack {
    private Node head;

    public void push(int x) {
        if (head == null)
            head = new Node(x, x, null);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

/*
 * Runtime
 * 3 ms
 * Beats
 * 100%
 * Memory
 * 44.3 MB
 * Beats
 * 84.20%
 */

//Attempt #2 - 5mins (But O(n))
class MinStack {
    int min = Integer.MAX_VALUE;
    ArrayList<Integer> mstk;
    int curr = -1;

    public MinStack() {
        mstk = new ArrayList<Integer>();
    }
    
    public void push(int val) {
        mstk.add(val);
        min = Math.min(min, val);
        curr++;
    }
    
    public void pop() { //O(n) time for finding min Val
        mstk.remove(curr--);
        min = Integer.MAX_VALUE;
        for(int x: mstk) {
            min = Math.min(min, x);
        }
    }
    
    public int top() {
        return mstk.get(curr);
    }
    
    public int getMin() {
        return min;
    }
}

/**
Runtime
6 ms
Beats
50.76%
Memory
47 MB
Beats
6.71%
 */

//Optimal #2 

class MinStack {
    LinkedList<TplusMin> stack;
    private class TplusMin {
        int val;
        int min;
        public TplusMin(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    public MinStack() {
        stack = new LinkedList<>();
    }
    
    public void push(int val) {
        int newMin;
        if (stack.size() == 0){
            newMin = val;
        }
        else {
            int currentMin = stack.getFirst().min;
            newMin = val < currentMin ? val : currentMin;
        }
        stack.addFirst(new TplusMin(val, newMin));
    }
    
    public void pop() {
        stack.removeFirst();
    }
    
    public int top() {
        return stack.peekFirst().val;
    }
    
    public int getMin() {
        return stack.peekFirst().min;
    }
}

/*
Runtime
5 ms
Beats
87.46%
Memory
47.5 MB
Beats
5.93%
 */