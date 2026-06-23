class Solution {
    ListNode dummy = new ListNode(0);
    ListNode res = dummy;
    public void helper(int x){
        res.next = new ListNode(x);
        res = res.next;
    }
    public ListNode partition(ListNode head, int x) {
        ListNode temp = head;
        while(temp != null){
            if(temp.val < x){
                helper(temp.val);
            }
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            if(temp.val >= x){
                helper(temp.val);
            }
            temp = temp.next;
        }
        return dummy.next;
    }
}