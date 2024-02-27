/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair{
    int num;  //index
    TreeNode node;

    Pair(TreeNode node, int num){
        this.num = num;
        this.node = node;
    }
}

//Intuition
//We have to find the longest width fo the binary tree therefore we can approach the problem using the level order traversal
//While travelling each level we can mark the indexes of the each node, we can mark the starting node index of each level as 0 and the last index node of the level size
//TO add the indexes to each node, we are using a custom class called Pair, where we are storing the node and its index. the index we are storing is following the standard way of storing the binary tree indexes, where the children are at 2n+1 and 2n+2 positions respectively.
// One catch: While traversing the levels it is difficult to determine the length just by the normal indexes, therefore the better way is to calculate min index of the level and substract it from the firstIndex making it 0 and then also from the last index of the level so that it is calculated accordingly.
// This way we will get the lastIndex and the firstIndex for each level where the level legnth will effectively be lastIndex - firstIndex + 1.
// We have to maintain the max of the every level width and return at the end of the looping throught each level.


class Solution {
    public int widthOfBinaryTree(TreeNode root) {

        if(root == null ) return 0;

        Queue<Pair> q = new LinkedList<>();
        int finalAns = 0;
        q.add(new Pair(root, 0));  //add the root node and 0 index as the element's index

        while(!q.isEmpty())
        {
            int startIndex = 0, lastIndex=0;
            int size = q.size(); //size of the current width(level)
            int min_in_level = q.peek().num;  //this we will use to make the index of the level's first node 0

            for(int i =0; i<size; i++)
            {
                //Take out the current node
                TreeNode currElement = q.peek().node;
                int currIndex = q.peek().num;

            
                if(i == 0) startIndex = currIndex - min_in_level;  //Adjust the index accordingly such that it is starting from the 0
                if(i == size - 1) lastIndex = currIndex - min_in_level; //Adjust the index accordingly such that it is 0 based indexing.
                 q.poll();
                //Add the left and right children of the current node into the queue
                if(currElement.left != null) q.offer(new Pair(currElement.left, 2*currIndex + 1));  //standard indexing in case of a binary tree
                if(currElement.right != null) q.offer(new Pair(currElement.right, 2* currIndex + 2));
            }

            finalAns = Math.max(finalAns, lastIndex - startIndex + 1);

        }

        return finalAns;
    }
}