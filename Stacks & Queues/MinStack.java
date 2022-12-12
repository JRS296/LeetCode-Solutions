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