package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubarrayWithDistinctValues {
  @EpiTest(testDataFile = "longest_subarray_with_distinct_values.tsv")

  public static int longestSubarrayWithDistinctEntries(List<Integer> A) {
      int maxLen = 0;
      int startIdx = 0;
      Map<Integer, Integer> mostRecentIndex = new HashMap<>();
      for (int i = 0; i < A.size(); i++) {
          Integer lastIndex = mostRecentIndex.put(A.get(i), i);
          if (lastIndex != null && lastIndex >= startIdx) {
              // i.e. we reached a duplicate.
              maxLen = Math.max(maxLen, i - startIdx);
              startIdx = lastIndex + 1;
          }
      }
      maxLen = Math.max(maxLen, A.size() - startIdx);
      return maxLen;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LongestSubarrayWithDistinctValues.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
