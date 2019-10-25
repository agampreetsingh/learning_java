import java.util.PriorityQueue;
import java.util.Comparator;

/*
 *PriorityQueue in java is implementation of 
 *Heap and using Comparator we can customize ordering
 *and create Min Heap and Max Heap
 *
 *For More:- https://en.wikipedia.org/wiki/Heap_(data_structure)
 */
class PriorityQueueInJava {
	public static void main (String[] args) { 
	    int[] sampleDataSet = new int[]{5,4,10,9,7,1,6};
	    
	    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	    minHeap.add(sampleDataSet[0]);
	    minHeap.add(sampleDataSet[1]);
	    minHeap.add(sampleDataSet[2]);
	    System.out.println("Current minimum in minHeap :"+minHeap.peek());
	    minHeap.poll();  //removing root element of minHeap
	    System.out.println("Current minimum in minHeap :"+minHeap.peek());
	    minHeap.add(sampleDataSet[3]);
	    minHeap.add(sampleDataSet[4]);
	    minHeap.add(sampleDataSet[5]);
	    System.out.println("Remove minimum in minHeap :"+minHeap.poll());
	    
	    System.out.println("\n---------------------------------------------\n");
	    
	    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
	        
	        public int compare(Integer a,Integer b){
	            return -1 * (a - b);
	        }
	    });
	    maxHeap.add(sampleDataSet[0]);
	    maxHeap.add(sampleDataSet[1]);
	    maxHeap.add(sampleDataSet[2]);
	    System.out.println("Current maximum in maxHeap :"+maxHeap.peek());
	    maxHeap.poll();  //removing root element of maxHeap
	    System.out.println("Current maximum in maxHeap :"+maxHeap.peek());
	    maxHeap.add(sampleDataSet[3]);
	    maxHeap.add(sampleDataSet[4]);
	    maxHeap.add(sampleDataSet[5]);
	    System.out.println("Remove maximum in maxHeap :"+maxHeap.poll());
	}
}
