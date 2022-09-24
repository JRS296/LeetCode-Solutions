//Attempt #1 - Lost
//Link:

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

// Basic idea is straight forward:

// Start form the head , move one step each time to the next node
// When meet with a node with child, say node p, follow its child chain to the end and connect the tail node with p.next, by doing this we merged the child chain back to the main thread
// Return to p and proceed until find next node with child.
// Repeat until reach null

class Solution {
    public Node flatten(Node head) {
        if( head == null) return head;
	// Pointer
        Node p = head; 
        while( p!= null) {
            /* CASE 1: if no child, proceed */
            if( p.child == null ) {
                p = p.next;
                continue;
            }
            /* CASE 2: got child, find the tail of the child and link it to p.next */
            Node temp = p.child;
            // Find the tail of the child
            while( temp.next != null ) 
                temp = temp.next;
            // Connect tail with p.next, if it is not null
            temp.next = p.next;  
            if( p.next != null )  p.next.prev = temp;
            // Connect p with p.child, and remove p.child
            p.next = p.child; 
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }
}

/*
26 / 26 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 42.1 MB

Good Solution
 */

/*
Explanation:
    Basic idea is straight forward:

Start form the head , move one step each time to the next node
When meet with a node with child, say node p, follow its child chain to the end and connect the tail node with p.next, by doing this we merged the child chain back to the main thread
Return to p and proceed until find next node with child.
Repeat until reach null
*/

//Revise