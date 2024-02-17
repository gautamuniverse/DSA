
/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    
     TreeNode(int val) {
         this.val = val;
         this.left = null;
         this.right = null;
     }
 }

 *********************************************/

import java.util.*;

class Pair {
    int hd; // Horizontal distance
    int vd; // vertical distance
    TreeNode node;

    Pair(int hd, int vd, TreeNode node) {
        this.hd = hd;
        this.vd = vd;
        this.node = node;
    }
}

class HeightPair {
    int height;
    int value;

    HeightPair(int height, int value) {
        this.height = height;
        this.value = value;
    }
}

public class Solution {
    public static List<Integer> bottomView(TreeNode root) {
        // Write your code here.
        List<Integer> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, HeightPair> map = new TreeMap<>(); // Map<hd, TreeMap<vertical, Node>>

        if (root == null)
            return ans;

        // Push the root into the q
        q.add(new Pair(0, 0, root));

        while (!q.isEmpty()) {
            // Take out the current pair
            Pair pair = q.poll();
            TreeNode node = pair.node;
            int hd = pair.hd;
            int vd = pair.vd;

            // If the map doesn't contain the current hd as key then add
            if (!map.containsKey(hd)) {
                map.put(hd, new HeightPair(vd, node.val));
            }
            // If the hd key exists compare the vertical distance
            else {
                int existingVD = map.get(hd).height;
                if (vd >= existingVD) {
                    // Current vertical distance greater than or equal means it will hide the
                    // previour node
                    // therefore replace it
                    map.put(hd, new HeightPair(hd, node.val));
                }
            }

            //Move towards left if child exists
            if(node.left != null) q.add(new Pair(hd-1, vd+1, node.left));
            //if the right child exists add it into the queue
            if(node.right != null) q.add(new Pair(hd+1, vd+1, node.right));
        }

        //We are done with the nodes collection in the map, fill the values in the ans list
        for(Map.Entry<Integer, HeightPair> entry: map.entrySet())
        {
            ans.add(entry.getValue().value);
        }

        return ans;

    }
}
