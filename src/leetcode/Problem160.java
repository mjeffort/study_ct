package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem160 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;

        while(currA != currB) {
            currA = currA == null ? headB : currA.next;
            currB = currB == null ? headA : currB.next;
        }

        return currA;

//        ListNode pA = headA;
//        ListNode pB = headB;
//        List<ListNode> listA = new ArrayList<>();
//        List<ListNode> listB = new ArrayList<>();
//
//        while (pA.next != null) {
//            listA.add(pA);
//            pA = pA.next;
//        }
//
//        while (pB.next != null) {
//            listB.add(pB);
//            pB = pB.next;
//        }
//
//        ListNode t = null;
//        int dif = Math.abs(listA.size() - listB.size());
//        if (listA.size() >= listB.size()) {
//            int a = dif;
//            int b = 0;
//            while (b < listB.size()) {
//                if (listA.get(a) == listB.get(b)) {
//                    t = listA.get(a);
//                }
//                a++;
//                b++;
//            }
//        } else {
//            int a = 0;
//            int b = dif;
//            while (a < listA.size()) {
//                if (listA.get(a) == listB.get(b)) {
//                    t = listA.get(a);
//                    break;
//                }
//                a++;
//                b++;
//            }
//        }
//
//        if(t == null) return null;
//        int k = listA.indexOf(t);
//
//        while (k-- > 0) {
//            headA = headA.next;
//        }
//
//        return headA;
    }

    public static void main(String[] args) {
        Problem160 m = new Problem160();

        ListNode headA = new ListNode(4);
        ListNode headA1 = new ListNode(1);
        ListNode headA2 = new ListNode(8);
        ListNode headA3 = new ListNode(4);
        ListNode headA4 = new ListNode(5);
        headA.next = headA1;
        headA1.next = headA2;
        headA2.next = headA3;
        headA3.next = headA4;

        ListNode headB= new ListNode(5);
        ListNode headB1= new ListNode(6);
        ListNode headB2= new ListNode(1);
        ListNode headB3= new ListNode(8);
        ListNode headB4= new ListNode(4);
        ListNode headB5= new ListNode(5);
        headB.next = headB1;
        headB1.next = headB2;
        headB2.next = headB3;
        headB3.next = headB4;
        headB4.next = headB5;
        ListNode solustion = m.getIntersectionNode(headA, headB);
        System.out.println(solustion);
    }
}
