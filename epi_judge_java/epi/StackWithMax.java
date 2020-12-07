package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
public class StackWithMax {

    public static class Stack {
        private static final int DEFAULT_STACK_SIZE = 16;
        private static final int SCALE_FACTOR = 2;

        // tracks elements in the stack
        private Integer[] elementStack;
        private int elementPos;

        // tracks max in the stack
        private Integer[] maxStack;
        private int maxPos;

        Stack() {
            elementStack = new Integer[DEFAULT_STACK_SIZE];
            maxStack = new Integer[DEFAULT_STACK_SIZE];
            elementPos = maxPos = 0;
        }
        public boolean empty() {
            return elementPos == 0;
        }
        public Integer max() {
            return maxStack[maxPos - 1];
        }
        public Integer pop() {
            elementPos--;
            if (maxStack[maxPos - 1] == elementStack[elementPos]) {
                maxPos--;
            }
            return elementStack[elementPos];
        }
        public void push(Integer x) {
            ensureCapacity();
            elementStack[elementPos++] = x;
            if (maxPos == 0 || x >= maxStack[maxPos - 1]) {
                maxStack[maxPos++] = x;
            }
        }

        private void ensureCapacity() {
            if (elementPos >= elementStack.length) {
                elementStack = Arrays.copyOf(elementStack, elementStack.length * SCALE_FACTOR);
            }

            if (maxPos >= maxStack.length) {
                maxStack = Arrays.copyOf(maxStack, maxStack.length * SCALE_FACTOR);
            }
        }
    }
    @EpiUserType(ctorParams = {String.class, int.class})
    public static class StackOp {
        public String op;
        public int arg;

        public StackOp(String op, int arg) {
            this.op = op;
            this.arg = arg;
        }
    }

    @EpiTest(testDataFile = "stack_with_max.tsv")
    public static void stackTester(List<StackOp> ops) throws TestFailure {
        try {
            Stack s = new Stack();
            int result;
            for (StackOp op : ops) {
                switch (op.op) {
                case "Stack":
                    s = new Stack();
                    break;
                case "push":
                    s.push(op.arg);
                    break;
                case "pop":
                    result = s.pop();
                    if (result != op.arg) {
                        throw new TestFailure("Pop: expected " + String.valueOf(op.arg) +
                            ", got " + String.valueOf(result));
                    }
                    break;
                case "max":
                    result = s.max();
                    if (result != op.arg) {
                        throw new TestFailure("Max: expected " + String.valueOf(op.arg) +
                            ", got " + String.valueOf(result));
                    }
                    break;
                case "empty":
                    result = s.empty() ? 1 : 0;
                    if (result != op.arg) {
                        throw new TestFailure("Empty: expected " + String.valueOf(op.arg) +
                            ", got " + String.valueOf(s));
                    }
                    break;
                default:
                    throw new RuntimeException("Unsupported stack operation: " + op.op);
                }
            }
        } catch (NoSuchElementException e) {
            throw new TestFailure("Unexpected NoSuchElement exception");
        }
    }

    public static void main(String[] args) {
        System.exit(
            GenericTest
                .runFromAnnotations(args, "StackWithMax.java",
                    new Object() {}.getClass().getEnclosingClass())
                .ordinal());
    }
}
