
/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 *********************************************/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Tuple {
    int hd; // horizontal distance
    TreeNode node;
    Tuple(int hd, TreeNode node) {
        this.hd = hd;
        this.node = node;
    }
}

public class Solution {
    public static List<Integer> getTopView(TreeNode root) {
        // Write your code here.

        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>(); //tree map because it stores the keys in natural ordering
        Queue<Tuple> q = new LinkedList<>();

        if(root == null) return ans;

        q.add(new Tuple(0, root));

        while(!q.isEmpty())
        {
            //Extract the element from the queue
            Tuple tuple = q.remove();

            int hd = tuple.hd;
            TreeNode node = tuple.node;

            //If the current hd is not present in the map only then add a new entry into the map
            if(map.get(hd) == null)
            {
                map.put(hd, node.data);
            }

            //push left and right childs of the node into the queue
            if(node.left != null) q.add(new Tuple(hd-1, node.left));
            if(node.right != null) q.add(new Tuple(hd+1, node.right)); 
        }

        //We are done with the data collection now we can extract the map entries and fil in the final answer list
        for(Map.Entry<Integer, Integer> entry: map.entrySet())
        {
            ans.add(entry.getValue());
        }

        return ans;
    }
}
