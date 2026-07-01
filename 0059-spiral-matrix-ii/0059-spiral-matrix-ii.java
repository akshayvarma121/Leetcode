class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        
        int top = 0;          
        int bottom = n - 1;   
        int left = 0;         
        int right = n - 1;    

        int val = 1;          

        
        while (top <= bottom && left <= right) {

            // 1) LEFT -> RIGHT on TOP row
            for (int j = left; j <= right; j++) {
                ans[top][j] = val++;     
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                ans[i][right] = val++;    
            }
            right--;                      

            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    ans[bottom][j] = val++;  
                }
                bottom--;                     
            }

            
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans[i][left] = val++;     
                }
                left++;                       
            }
        }

        return ans;
    }
}