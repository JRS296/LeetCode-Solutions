//Attempt #1 - 45mins
//Link: https://leetcode.com/problems/lru-cache/description/

import java.util.HashMap;
import java.util.Map;

class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, ListNode> dic;
    ListNode head;
    ListNode tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        dic = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!dic.containsKey(key)) {
            return -1;
        }
        
        ListNode node = dic.get(key);
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (dic.containsKey(key)) {
            ListNode oldNode = dic.get(key);
            remove(oldNode);
        }
        
        ListNode node = new ListNode(key, value);
        dic.put(key, node);
        add(node);
        
        if (dic.size() > capacity) {
            ListNode nodeToDelete = head.next;
            remove(nodeToDelete);
            dic.remove(nodeToDelete.key);
        }
    }
    
    public void add(ListNode node) {
        ListNode previousEnd = tail.prev;
        previousEnd.next = node;
        node.prev = previousEnd;
        node.next = tail;
        tail.prev = node;
    }
    
    public void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
Runtime
70 ms
Beats
49.60%
Memory
119.1 MB
Beats
51.32%

TC - O(1)
SC - O(n)
 */