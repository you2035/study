package leetCode;

/**
 * @Auther: liuxin
 * @Date: 2020/3/5 16:37
 * @Description:给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(4);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		l1.setNext(l2);
		l2.setNext(l3);
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(6);
		ListNode l6 = new ListNode(4);
		l4.setNext(l5);
		l5.setNext(l6);
		ListNode listNode = addTwoNumbers(l1, l4);

		System.out.println(listNode.val);
		System.out.println(listNode.next.val);
		System.out.println(listNode.next.next.val);
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int sum = 0;
		ListNode head = new ListNode(0);
		ListNode cur = head;

		while (l1 != null || l2 != null || sum != 0) {
			sum += (l1 != null ? l1.val : 0)
							+ (l2 != null ? l2.val : 0);
			cur = cur.next = new ListNode(sum % 10);

			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;
			sum = sum / 10;
		}
		return head.next;
	}

	public static ListNode TwoNumbers(ListNode l1, ListNode l2) {
		int sum = 0;
		ListNode head = new ListNode(0);
		ListNode cur = head;

		while (l1 != null || l2 != null || sum != 0) {

		}
		return head.next;
	}

}


class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}
}

