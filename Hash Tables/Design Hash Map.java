//Attempt - Null
//Link: https://leetcode.com/explore/learn/card/hash-table/182/practical-applications/1140

class MyHashMap {
    final ListNode[] nodes = new ListNode[10_000];

    public void put(int key, int value) {
        int i = idx(key);
        if (nodes[i] == null)
            nodes[i] = new ListNode(-1, -1);
        ListNode prev = find(nodes[i], key);
        if (prev.next == null)
            prev.next = new ListNode(key, value);
        else
            prev.next.val = value;
    }

    public int get(int key) {
        int i = idx(key);
        if (nodes[i] == null)
            return -1;
        ListNode node = find(nodes[i], key);
        return node.next == null ? -1 : node.next.val;
    }

    public void remove(int key) {
        int i = idx(key);
        if (nodes[i] != null) {
            ListNode prev = find(nodes[i], key);
            if (prev.next != null)
                prev.next = prev.next.next;
        }
    }

    int idx(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    ListNode find(ListNode bucket, int key) {
        ListNode node = bucket, prev = null;
        for (; node != null && node.key != key; node = node.next)
            prev = node;
        return prev;
    }

    class ListNode {
        int key, val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/*
36 / 36 test cases passed.
Status: Accepted
Runtime: 33 ms
Memory Usage: 61.1 MB
 */