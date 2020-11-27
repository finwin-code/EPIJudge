package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashSet;
import java.util.Set;

public class CollatzChecker {
  @EpiTest(testDataFile = "collatz_checker.tsv")

  public static boolean testCollatzConjecture(int n) {
    // test collatz conjecture for numbers up to n.
    // if n is odd, triple it and add 1, else halve it. Eventually 1 is reached.
    Set<Long> collatzSequence = new HashSet<>();
    collatzSequence.add(1L);
    collatzSequence.add(2L);
    for (int i = 3; i <= n; i += 2) {
      Set<Long> visited = new HashSet<>();
      long num = i;
      while (num != 1 && !visited.contains(num) && !collatzSequence.contains(num)) {
        visited.add(num);
        num = ((num & 1) == 0) ? num >> 1 : num + ((num + 1) >> 1);
      }

      if (visited.contains(num)) return false;
      collatzSequence.addAll(visited);
    }
    return true;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "CollatzChecker.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
