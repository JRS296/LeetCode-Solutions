public class Solution {
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

// Idea: Floyd's Cycle Detection algorithm, also known as the "tortoise and
// hare" algorithm.

/*
 * we move the slow pointer one step at a time, and the fast pointer two steps
 * at a time. If there is a cycle in the linked list, the two pointers will
 * eventually meet at some point. Otherwise, the fast pointer will reach the end
 * of the linked list.
 * 
 * Once the two pointers meet, we reset the slow pointer to the head of the
 * linked list, and move both pointers one step at a time. The point where the
 * two pointers meet again is the node where the cycle begins.
 */

// https://leetcode.com/problems/linked-list-cycle-ii/solutions/3274119/beats-100-video-java-c-python/

/*
 * When fast and slow meet at point p, the length they have run are 'a+2b+c' and
 * 'a+b'.
 * Since the fast is 2 times faster than the slow. So a+2b+c == 2(a+b), then we
 * get 'a==c'.
 * So when another slow2 pointer run from head to 'q', at the same time,
 * previous slow pointer will run from 'p' to 'q', so they WILL ALWAYS meet at
 * the pointer 'q' together.
 */

/*
 * 16 / 16 test cases passed.
 * Status: Accepted
 * Runtime: 0 ms
 * Memory Usage: 44.8 MB
 * Time Complexity: ??
 */


