//Attempt - Null
//Link: https://leetcode.com/explore/learn/card/hash-table/182/practical-applications/1139

import java.util.LinkedList;
import java.util.List;
import javax.swing.text.html.HTMLDocument.Iterator;

class MyHashSet {
    List<Integer>[] container = null;
    int cap = 1000;
    double loadFactor = 0.75;
    int count = 0;

    /** Initialize your data structure here. */
    public MyHashSet() {
        container = new LinkedList[cap];
    }

    public void add(int key) {
        if (contains(key))
            return;
        if (loadFactor * cap == count) {
            count = 0;
            // rehash
            cap *= 2;
            List<Integer>[] oldC = container;
            container = new LinkedList[cap];
            for (int i = 0; i < oldC.length; i++) {
                List<Integer> list = oldC[i];
                if (list != null) {
                    for (int entry : list)
                        this.add(entry);
                }
            }
        }
        int hash = key % cap;
        if (container[hash] == null)
            container[hash] = new LinkedList<>();
        container[hash].add(key);
        ++count;
    }

    public void remove(int key) {
        int hash = key % cap;
        List<Integer> list = container[hash];
        if (list != null) {
            Iterator<Integer> itr = list.iterator();
            while (itr.hasNext())
                if (itr.next() == key) {
                    itr.remove();
                    --count;
                    break;
                }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = key % cap;
        List<Integer> list = container[hash];
        if (list != null) {
            Iterator<Integer> itr = list.iterator();
            while (itr.hasNext())
                if (itr.next() == key)
                    return true;
        }
        return false;
    }
}

/*
33 / 33 test cases passed.
Status: Accepted
Runtime: 38 ms
Memory Usage: 59 MB
 */