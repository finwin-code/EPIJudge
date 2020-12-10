package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ElementAppearingOnce {
    @EpiTest(testDataFile = "element_appearing_once.tsv")

    public static int findElementAppearsOnce(List<Integer> A) {
        Map<Integer, Integer> count = new HashMap<>();
        for (Integer num : A) count.merge(num, 1, Integer::sum);
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return -1;
    }

    public static void main(String[] args) {
        System.exit(
            GenericTest
                .runFromAnnotations(args, "ElementAppearingOnce.java",
                    new Object() {}.getClass().getEnclosingClass())
                .ordinal());
    }
}
