package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElementInLongArray {

  public static int findKthLargestUnknownLength(Iterator<Integer> stream,
                                                int k) {
    // find kth largest number in a stream of numbers.
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    while (stream.hasNext()) {
      minHeap.add(stream.next());
      if (minHeap.size() > k) minHeap.poll();
    }
    return minHeap.peek();
  }

  @EpiTest(testDataFile = "kth_largest_element_in_long_array.tsv")
  public static int findKthLargestUnknownLengthWrapper(List<Integer> stream,
                                                       int k) {
    return findKthLargestUnknownLength(stream.iterator(), k);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "KthLargestElementInLongArray.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
