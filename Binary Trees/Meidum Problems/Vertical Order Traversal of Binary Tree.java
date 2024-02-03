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
 //Making the below class for the queue
 class Tuple{
     int row;
     int col;
     TreeNode node;

     Tuple(int row, int col, TreeNode node)
     {
        this.row = row;
        this.col = col;
        this.node = node;
     }

 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //For storing the node values along with their coordinates
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        //Keys represent the verticals that left to right
        // The values represent a tree map which contains Levels as keys and Priority queues hold the actual value of the node. a Level can have multiple values

        //Making a priorityy queue to traverse the Tree in level order
        //We will be storing tuple containing row, col and node
        Queue<Tuple> q = new LinkedList<>();

        //Push the first node into the queue
        Tuple newTuple = new Tuple(0, 0, root);

        q.offer(newTuple);

        //Traverse the tree in level order
        while(!q.isEmpty())
        {
            //Pop the first element
            Tuple tuple = q.poll();

            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            //If the Map doesn't contain the current vertical then create
            if(!map.containsKey(x))
            {
                map.put(x, new TreeMap<>());
            }
            //At this point a vertical with value x is sure to be there, so now proceed with adding the level and the node's value for the current node
            //If the current vertical doesn't contains a level with value y then insert it
            if(!map.get(x).containsKey(y))
            {
                map.get(x).put(y, new PriorityQueue<>()); //putting a new priority queue for the current level(y)
            }
            //Insert the current node's value for the current level (y)
            map.get(x).get(y).offer(node.val);
            //Push the node's left child into the queue with the new vertical and level
            if(node.left != null) q.offer(new Tuple(x-1, y+1, node.left)); //vertical will decrease because we going towards left portion/side of the map but the level will increase because we are going downwards as per the problem statement.
            
            //Similarly push the right child into the queue if it is not null
            if(node.right != null) q.offer(new Tuple(x + 1, y + 1, node.right)); // both the vertical and the level will increase here
        }

        //Note: The final answers wants the values to be from left to right starting from top to down. So if in one vertical (top to down) exists multiple values then they will come in one single list and so on.

        List<List<Integer>> ans = new ArrayList<>();  
        //Once we are done with the map filled with all the nodes with their x and y coordinates now we can make a list of list of these nodes
        for(TreeMap<Integer, PriorityQueue<Integer>> vals : map.values())
        {
            //Add a new list into the ans
            ans.add(new ArrayList<>());

            //Traverse the current vertical which will be a a list of nodes contained in priority queue and push all those values into the newly added list
            for(PriorityQueue<Integer> nodes: vals.values())
            {
                //now we traverse this pq to get all the values
                while(!nodes.isEmpty())
                {
                    ans.get(ans.size() - 1).add(nodes.poll());
                }

            }
        }
        return ans;
    }
}