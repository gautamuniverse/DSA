public class Solution {
    public static String graphColoring(int [][]mat, int m) {
        // Write your code here
        int totalNodes = mat.length;

        int [] colored = new int [totalNodes];

        if(helper(0, mat, colored, m, totalNodes) == true)
        return "YES";
        else
        return "NO";
    }

    private static boolean isSafe(int [] colored, int node, int [][] mat, int color)
    {   

        //Check in the graph if there are any neighbors of the current node and the color assigned
        //to that neighbor is same as the one assigned to the current node. If so return false(Not possible)
        for(int i = 0; i< mat.length; i++)
        {
            if(mat[node][i] == 1 && colored[i] == color)
            return false;
        }

        //none of the neighbors had the same color, so return true(possible)
        return true;
    }

    private static boolean helper(int node, int [][] mat, int [] colored, int m, int totalNodes)
    {   

        //We were able to color total nodes, hence return true
        if(node == totalNodes)
        {
            return true;
        }

        //Iterate through each color and try with assigning them to each nodes one by one.
        //The first node has the option to be colored with each of the m colors.
        for(int i = 1; i<=m; i++)
        {   
            //Check if it is possible to color the current node with the current color.
            if(isSafe(colored, node,mat, i))
            {   
                //assign current color to the node.
                colored[node] = i;
                //recursive check if the current combination is posisble for next nodes.
                if(helper(node+1, mat, colored, m, totalNodes))
                return true;

                //backtrack and reinitilaize the node back to 0
                colored[node] = 0;
            }
        }

        return false;
    }
}