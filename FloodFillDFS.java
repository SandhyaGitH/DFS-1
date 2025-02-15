// Time Complexity : O(mn)  m = number of rows , n = no of columns
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//1. using DFS

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       
        if(image == null || image.length ==0) return null;
        int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
        
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{sr,sc});
        int prevColor = image[sr][sc];
        image[sr][sc] =  newColor;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int i =0; i < size; i++)
            { 
                int[] curr = q.poll();
            
                for(int[] dir: dirs)
                {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if( r >= 0 && r < image.length && c >= 0 && c < image[0].length  &&                         image[r][c] == prevColor && image[r][c] != image[sr][sc])
                   {
                       image[r][c] =  newColor;
                        q.add(new int[]{r,c});
                    }
                }
             
            }
        }
         
        return image;
        
    }
}