//Attempt #1 - 20mins
//Link: https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1228/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode a = ans;
        String num1 = "", num2 = "";

        while (l1 != null) {
            num1 += String.valueOf(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            num2 += String.valueOf(l2.val);
            l2 = l2.next;
        }

        int len1 = num1.length();
        int len2 = num2.length();
        String n1 = "";
        String n2 = "";
        for (int i = len1 - 1; i > -1; i--) {
            n1 += num1.charAt(i);
        }

        for (int i = len2 - 1; i > -1; i--) {
            n2 += num2.charAt(i);
        }

        int x = Integer.parseInt(n1) + Integer.parseInt(n2);
        // System.out.println(x);
        int l = String.valueOf(x).length();
        for (int i = 0; i < l; i++) {
            int n = x % 10;
            ans.next = new ListNode(n);
            // System.out.println(ans.next.val);
            ans = ans.next;
            x /= 10;
        }

        return a.next;
    }
}

/*
 * 32 / 1568 test cases passed
 */

// Attempt #2 - 50mins

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null & l2 == null) {
            return null;
        } else if (l1.next == null && l2 == null) {
            return l1;
        } else if (l2.next == null && l1 == null) {
            return l2;
        }
        ListNode ans = new ListNode(0);
        ListNode a = ans;
        long num1 = 0, num2 = 0;
        int c1 = 0, c2 = 0;

        while (l1 != null) {
            num1 += l1.val;
            num1 *= 10;
            c1++;
            l1 = l1.next;
        }

        while (l2 != null) {
            // System.out.print(l2.val+" * ");
            num2 += l2.val;
            num2 *= 10;
            c2++;
            // System.out.println(num2);
            l2 = l2.next;
        }
        num1 /= 10;
        num2 /= 10;
        long n1 = reverse(num1);
        long n2 = reverse(num2);
        if ((String.valueOf(n1).length()) != c1) {
            int t = String.valueOf(n1).length();
            t = Math.abs(t - c1);
            n1 *= Math.pow(10, t);
        }
        if ((String.valueOf(n2).length()) != c2) {
            int t = String.valueOf(n2).length();
            t = Math.abs(t - c2);
            n2 *= Math.pow(10, t);
        }
        long n3 = n1 + n2;
        // System.out.println(n3 + " " + n1 + " " + n2);
        // System.out.println(num1 + " " + num2);
        // System.out.println(reverse(num2));
        // System.out.println(c1+" "+c2);

        int len = String.valueOf(n3).length();
        for (int i = 0; i < len; i++) {
            long n = n3 % 10;
            ans.next = new ListNode((int) n);
            ans = ans.next;
            n3 /= 10;
        }

        return a.next;
    }

    public static long reverse(long x) {
        long number = x, reverse = 0;
        while (number != 0) {
            long remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;
        }
        return reverse;
    }
}

/*
 * 1565 / 1568 test cases passed.
 * Good solution, but not String based, therefore fails
 */

// Solution:
class Solution {
    // Add Two Numbers (Java improved)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummyHead.next;
    }
}

/*
1568 / 1568 test cases passed.
Status: Accepted
Runtime: 4 ms
Memory Usage: 48.1 MB

Time Complexity: O(n) n - largest linked list
Space Complexity: O(1)
 */

//Explanation: https://leetcode.com/problems/add-two-numbers/solution/