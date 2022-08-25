/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (f == s) {
                ListNode slow2 = head;
                while (slow2 != s) {
                    s = s.next;
                    slow2 = slow2.next;
                }
                return s;
            }
        }

        return null;
    }
}

/*
When fast and slow meet at point p, the length they have run are 'a+2b+c' and 'a+b'.
Since the fast is 2 times faster than the slow. So a+2b+c == 2(a+b), then we get 'a==c'.
So when another slow2 pointer run from head to 'q', at the same time, previous slow pointer will run from 'p' to 'q', so they meet at the pointer 'q' together.
 */

/*
16 / 16 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 44.8 MB
Time Complexity: ??
 */