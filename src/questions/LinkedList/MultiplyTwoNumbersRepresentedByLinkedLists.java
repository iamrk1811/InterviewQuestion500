package questions.LinkedList;

public class MultiplyTwoNumbersRepresentedByLinkedLists {
//    Q - https://www.geeksforgeeks.org/multiply-two-numbers-represented-linked-lists/
    public long solve(ListNode l1, ListNode l2) {
        long p = 0l;
        long q = 0l;
        long mul = 0l;
        while(l1 != null){
            p = (p * 10 + l1.data) % 1000000007;
            l1 = l1.next;
        }
        while(l2 != null){
            q = (q * 10 + l2.data) % 1000000007;
            l2 = l2.next;
        }
        mul = (p * q) % 1000000007;
        return mul;
    }
}
