package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class CircularQueue {

  public static class Queue {
    Integer[] queue;
    int count; // count of elements in queue
    int first, last; // first and last of queue
    private final int SCALING_FACTOR = 2;
    public Queue(int capacity) {
      if (capacity <= 0) throw new IllegalArgumentException("Queue capacity must be positive integer");
      queue = new Integer[capacity];
      count = 0;
      first = 0;
      last = 0; // last is exclusive.
    }
    public void enqueue(Integer x) {
      if (count == queue.length) {
        ensureCapacity();
      };
      queue[last] = x;
      last = (last + 1) % queue.length;
      count++;
      return;
    }
    public Integer dequeue() {
      if (count == 0) throw new IllegalStateException("Queue is empty");
      Integer result = queue[first];
      first = (first + 1) % queue.length;
      count--;
      return result;
    }
    public int size() {
      return count;
    }

    private void ensureCapacity() {
      if (count < queue.length) return;
      Collections.rotate(Arrays.asList(queue), -first);
      first = 0;
      last = queue.length;
      queue = Arrays.copyOf(queue, queue.length * SCALING_FACTOR);
    }

    @Override
    public String toString() {
      StringJoiner joiner = new StringJoiner(",", "[", "]");
      for (int i = 0; i < count; i++) {
        joiner.add(queue[(first + i) % queue.length].toString());
      }
      return joiner.toString();
    }
  }
  @EpiUserType(ctorParams = {String.class, int.class})
  public static class QueueOp {
    public String op;
    public int arg;

    public QueueOp(String op, int arg) {
      this.op = op;
      this.arg = arg;
    }

    @Override
    public String toString() {
      return op;
    }
  }

  @EpiTest(testDataFile = "circular_queue.tsv")
  public static void queueTester(List<QueueOp> ops) throws TestFailure {
    Queue q = new Queue(1);
    int opIdx = 0;
    for (QueueOp op : ops) {
      switch (op.op) {
      case "Queue":
        q = new Queue(op.arg);
        break;
      case "enqueue":
        q.enqueue(op.arg);
        break;
      case "dequeue":
        int result = q.dequeue();
        if (result != op.arg) {
          throw new TestFailure()
              .withProperty(TestFailure.PropertyName.STATE, q)
              .withProperty(TestFailure.PropertyName.COMMAND, op)
              .withMismatchInfo(opIdx, op.arg, result);
        }
        break;
      case "size":
        int s = q.size();
        if (s != op.arg) {
          throw new TestFailure()
              .withProperty(TestFailure.PropertyName.STATE, q)
              .withProperty(TestFailure.PropertyName.COMMAND, op)
              .withMismatchInfo(opIdx, op.arg, s);
        }
        break;
      }
      opIdx++;
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "CircularQueue.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
