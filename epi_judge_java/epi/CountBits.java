package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class CountBits {
    private static short[] cache;
    static {
       cache = oneBitsCache(8);
    }

    @EpiTest(testDataFile = "count_bits.tsv")
    public static short countBits(int x) {
        //int MASK = (1 << 8) - 1;
        //return (short) (cache[MASK & x] + cache[MASK & (x >> 8)] + cache[MASK & (x >> 16)] + cache[MASK & (x >> 24)]);
        short bits = 0;
        while (x != 0) {
            x = x & (x - 1);
            bits++;
        }
        return bits;
    }

    private static short[] oneBitsCache(int numBits) {
        short[] cache = new short[1 << numBits];
        cache[1] = 1;
        for (int bits = 2, start; bits <= numBits; bits++) {
            start = 1 << (bits - 1);
            for (int pos = start; pos < (1 << bits); pos++) {
                cache[pos] = (short) (1 + cache[pos - start]);
            }
        }
        return cache;
    }

    public static void main(String[] args) {
        System.exit(
            GenericTest
                .runFromAnnotations(args, "CountBits.java",
                    new Object() {}.getClass().getEnclosingClass())
                .ordinal());
    }
}
