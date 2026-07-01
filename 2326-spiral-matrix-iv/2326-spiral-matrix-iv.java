class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        //matrix mein -1 fill krdiya 
        for (int i = 0; i < m; i++) {
            Arrays.fill(ans[i], -1);
        }

        int top = 0; 
        int bottom = m - 1;
        int left = 0; 
        int right = n - 1;
        ListNode curr = head;

        while (curr != null && top <= bottom && left <= right) {
            
           // left to right top pe 
            for (int j = left; j <= right && curr != null; j++) {
                ans[top][j] = curr.val;
                curr = curr.next;
            }
            top++;

            // top to bottom 

            for (int i = top; i <= bottom && curr != null; i++) {
                ans[i][right] = curr.val;
                curr = curr.next;
            }
            right--;

            //Right to left 

            if (top <= bottom) {
                for (int j = right; j >= left && curr != null; j--) {
                    ans[bottom][j] = curr.val;
                    curr = curr.next;
                }
                bottom--;
            }

            //bottom to top 

            if (left <= right) {
                for (int i = bottom; i >= top && curr != null; i--) {
                    ans[i][left] = curr.val;
                    curr = curr.next;
                }
                left++;
            }
        }

        return ans;
    }
}