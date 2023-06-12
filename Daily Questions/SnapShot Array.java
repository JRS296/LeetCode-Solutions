//Attempt #1 - 5mins
//Link: https://leetcode.com/problems/snapshot-array/description/

class SnapshotArray {
    int arr[];
    HashMap<Integer,int[]> snapMap = new HashMap<Integer,int[]>();
    int ID = 0;

    public SnapshotArray(int length) {
        arr = new int[length];
    }
    
    public void set(int index, int val) {
        arr[index] = val;
    }
    
    public int snap() {
        int arrCopy[] = arr.clone();
        snapMap.put(ID++, arrCopy);
        return ID-1;
    }
    
    public int get(int index, int snap_id) {
        int arr[] = snapMap.get(snap_id);
        return arr[index];
    }
}

/*
MLE - 69/74
 */

//Optimal Soln - using treemap

class SnapshotArray {
    TreeMap<Integer, Integer>[] Tm;
    int snap_id = 0;
    public SnapshotArray(int length) {
        Tm = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            Tm[i] = new TreeMap<Integer, Integer>();
            Tm[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        Tm[index].put(snap_id, val);
    }

    public int snap() {
        return snap_id++;
    }

    public int get(int index, int snap_id) {
        return Tm[index].floorEntry(snap_id).getValue();
    }
}

/*
Runtime
67 ms
Beats
54.5%
Memory
77.6 MB
Beats
57.61%
 */