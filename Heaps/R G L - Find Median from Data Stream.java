//Attempt #1 - 20 mins
//Link: https://leetcode.com/problems/find-median-from-data-stream/

class MedianFinder {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        arr.add(num);
    }
    
    public double findMedian() {
        Collections.sort(arr);
        int l = arr.size();
        if (l%2==0)
        {
            double x = (double)(arr.get(l/2) + arr.get((l/2)-1))/2;
            return x;
        }
        else
        {
            double x = arr.get(l/2);
            return x;
        }
    }
}

/**
Time Limit Exceeded
17 / 21 test cases passed.
 */

//Optimal Solution
class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();//heap is a minimal heap by default
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());//change to a maximum heap

// Adds a number into the data structure.
public void addNum(int num) {
maxHeap.offer(num);
minHeap.offer(maxHeap.poll());
if (maxHeap.size() < minHeap.size())
    maxHeap.offer(minHeap.poll());
}

// Returns the median of current data stream
public double findMedian() {
if (maxHeap.size() == minHeap.size())
    return (maxHeap.peek() + minHeap.peek()) / 2.0;
else
    return maxHeap.peek();
}
}

/**
* Your MedianFinder object will be instantiated and called as such:
* MedianFinder obj = new MedianFinder();
* obj.addNum(num);
* double param_2 = obj.findMedian();
*/

/*
Runtime: 323 ms, faster than 25.45% of Java online submissions for Find Median from Data Stream.
Memory Usage: 125.3 MB, less than 36.85% of Java online submissions for Find Median from Data Stream.
 */

 //Attempt #2 - 10mins

 class MedianFinder {
    //Approach: Using PriorityQueue
    private Queue<Integer> smallHeap; //small elements - maxHeap
    private Queue<Integer> largeHeap; //large elements - minHeap
    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a, b) -> b - a);
        largeHeap = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        //first add a value on the smallHeap
        smallHeap.add(num);

        //now separate them based on the large or small value
        //eek me se nikal ke dusre me dalna hai
        if(smallHeap.size()-largeHeap.size()>1 || !largeHeap.isEmpty() && smallHeap.peek()>largeHeap.peek()){
            largeHeap.add(smallHeap.poll());
        }
        if(largeHeap.size()-smallHeap.size()>1){
            smallHeap.add(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        //we have three cases 
        //based on the we can get the solution
        if(smallHeap.size()==largeHeap.size()){
            return (double)(smallHeap.peek()+largeHeap.peek())/2;
        }
        else if(smallHeap.size()>largeHeap.size()){
            return (double) smallHeap.peek();
        }
        else{
            return (double) largeHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
