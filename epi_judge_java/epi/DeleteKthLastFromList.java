package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class DeleteKthLastFromList {
    @EpiTest(testDataFile = "delete_kth_last_from_list.tsv")

    // Assumes L has at least k nodes, deletes the k-th last node in L.
    public static ListNode<Integer> removeKthLast(ListNode<Integer> L, int k) {
        final ListNode<Integer> HEAD = new ListNode<>(0, L);
        ListNode<Integer> current = HEAD, frontNode = HEAD;
        while (--k >= 0) {
            frontNode = frontNode.next;
        }
        while (frontNode.next != null) {
            frontNode = frontNode.next;
            current = current.next;
        }
        // delete current.next;
        current.next = current.next.next;
        return HEAD.next;
    }

    public static void main(String[] args) {
        System.exit(
            GenericTest
                .runFromAnnotations(args, "DeleteKthLastFromList.java",
                    new Object() {}.getClass().getEnclosingClass())
                .ordinal());
    }
}
