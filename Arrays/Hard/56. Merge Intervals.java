class Solution {
    public int[][] merge(int[][] arr) {
         // Write your code here.
        //Naive solution
        //Space -  O(1)
        //Time -  O(2N)
        // Arrays.sort(arr, new Comparator<int[]>()
        // {
        //     public int compare(int a[], int b[])
        //     {
        //         return a[0] - b[0];
        //     }
        // });
        // List<List<Integer>> ans = new ArrayList<>();
        // int n = arr.length;
        // for(int i = 0; i<n; i++)
        // {
        //     int start = arr[i][0];
        //     int end = arr[i][1];
        //     //check if the current interval lies in an existing interval and conintue
        //     if(!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1))
        //     {
        //         continue;
        //     }
        //      //check the rest of the intervals:
        //     for(int j = i+1; j<n; j++)
        //     {
        //         if(arr[j][0] <= end)
        //         {
        //             end = Math.max(arr[j][1], end);
        //         }
        //         else
        //         {
        //             break;
        //         }
        //     } 

        //     ans.add(Arrays.asList(start, end));
        // }

        // int finalAns [][] = new int[ans.size()][ans.get(0).size()];
        // for(int i = 0; i<ans.size(); i++)
        // {
        //     finalAns[i][0] = ans.get(i).get(0);
        //     finalAns[i][1] = ans.get(i).get(1);
        // }

        // return finalAns;


        //Optimal approach -  Time Complexity O(NLogN + N)
        Arrays.sort(arr, new Comparator<int []>()
        {
            public int compare(int a[], int b[])
            {
                return a[0] - b[0];
            }
        });
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        for(int i = 0; i<n; i++)
        {
            if(ans.isEmpty() || arr[i][0] > ans.get(ans.size()-1).get(1))
            {
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            }
            else
            {
                ans.get(ans.size()-1).set(1, Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]));
            }
        }

        int finalAns [][] = new int[ans.size()][ans.get(0).size()];
        for(int i = 0; i<ans.size(); i++)
        {
            finalAns[i][0] = ans.get(i).get(0);
            finalAns[i][1] = ans.get(i).get(1);
        }

        return finalAns;
    }
}