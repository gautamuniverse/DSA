import java.util.Scanner;

import java.util.PriorityQueue;

public class solution {
    static int minCost(int arr[], int n) {
        /*
         * Your class should be named Solution.Don't write main().Don't take
         * input, it is passed as function argument.Don't print output.Taking
         * input and printing output is handled automatically.
         */
         PriorityQueue<Integer> pq = new PriorityQueue<>();

         for(int i : arr)
         {
             pq.add(i);
         }

        int cost = 0;
         while(!pq.isEmpty())
         {  
             if(pq.size() == 1)
             {
                pq.poll();
             }
             else{
                 int num1 = pq.poll();
             int num2 = pq.poll();
             int ropeLength = num1+num2;
             cost+=ropeLength;
             pq.add(ropeLength);
             }
             
         }
        return cost;
    }
}