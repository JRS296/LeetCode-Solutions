//Attempt #1 - 20mins
//Link: https://leetcode.com/problems/copy-list-with-random-pointer/description/

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution { //2 pass approach
    /*Approach
    - TC -- > O(N) || SC --> O(N)
    - for every node, create a copy list using next pointer
    - Also save the address of original node as key and copy node as value in a hashmap [This will help to get to the random pointer of each copy node]
    - These two above step will create a copy list with random pointer as null
    - To set random pointer of copy list, we need two pointer :: p1[head of original list] and p2[head of copy list]
    - now for every node of copy list, we can map it's random pointer by using map as implemented in the last loop
    */
    public Node copyRandomList(Node head) {
        //base - case
        if(head == null) return null;
        
        HashMap<Node, Node> map = new HashMap<>();
        map.put(null, null);
        Node temp = head;
        Node copy = new Node(0);
        Node t = copy;
        
        while(temp != null) {
            Node newNode = new Node(temp.val);
            
            map.put(temp, newNode);
            
            t.next = newNode;
            t = t.next;
            temp = temp.next;
        }
        
        copy = copy.next; //remove dummy node
        Node p1 = head;
        Node p2 = copy;
        while(p2 != null) {
            p2.random = map.get(p1.random);
            p1 = p1.next;
            p2 = p2.next;
        }
        return copy;
    }
}

/*
Runtime
0 ms
Beats
100%
Memory
43.1 MB
Beats
35.45%

TC - O(n)
SC - O(n)
 */

//Another Soln - REcursive

class Solution2 {
  public Node copyRandomList(Node head) {
    if (head == null)
      return null;
    if (map.containsKey(head))
      return map.get(head);

    Node newNode = new Node(head.val);
    map.put(head, newNode);
    newNode.next = copyRandomList(head.next);
    newNode.random = copyRandomList(head.random);
    return newNode;
  }

  private Map<Node, Node> map = new HashMap<>();
}

/*
Runtime
0 ms
Beats
100%
Memory
43.1 MB
Beats
60.3%

TC - O(n)
SC - O(n)
 */