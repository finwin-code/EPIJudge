package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestContainedInterval {
  @EpiTest(testDataFile = "longest_contained_interval.tsv")

  public static int longestContainedRange(List<Integer> A) {
    // Find the largest size of subset with the property that if two integers are in the subset, so are all
    // integers in between them.
    // A = {6,-2,7,-1,9,8,1,3,-2,2,4,0} -> -2,-2,-1,0,1,2,3,4 -> 8
    Map<Integer, Integer> freq = new HashMap<>();
    for (Integer num : A) {
        // track frequency to include duplicates in the output subset.
      // test cases doens't want you to include duplicates in output. hence, count set to 1.
      freq.put(num, 1);
    }
    int longestRange = 0;
    while (freq.size() > 0) {
      Map.Entry<Integer, Integer> entry = freq.entrySet().iterator().next();
      freq.remove(entry.getKey());
      int num = entry.getKey();
      int currentLen = entry.getValue();
      Integer val;
      while ((val = freq.get(++num)) != null) {
        currentLen += val;
        freq.remove(num);
      }
      num = entry.getKey();
      while ((val = freq.get(--num)) != null) {
        currentLen += val;
        freq.remove(num);
      }
      longestRange = longestRange < currentLen ? currentLen : longestRange;
    }
    return longestRange;
  }


  public static void main(String[] args) {
    LongestContainedInterval.longestContainedRange(Arrays.asList(34, -4, -20, -25, 25, -34, -15, -17, -11, -16, 23, 4
        , 10, 20, -6, 28, -14, -33, 11, -10, -23, 19, -27, 1, -12, 33, -18, 24));
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LongestContainedInterval.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
