class Solution {
    public int[][] merge(int[][] intervals) {
        //sort the array in ascending order of intervals
        Arrays.sort(intervals, new Comparator<int []>(){
            public int compare(int[]a, int []b)
            {
                return a[0] - b[0];
            }
        });
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i<intervals.length; i++)
        {
            //check if the current interval overlaps

            //If it doesn't overlap add it to then ans list
            if(ans.isEmpty() || intervals[i][0] > ans.get(ans.size()-1).get(1))
            {   

                ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }
            else
            {
                //overlaps with the last interval inside the ans list
                ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size()-1).get(1), intervals[i][1]));
            }
        }
        int finalAns [][] = new int [ans.size()][2];
         for (int i = 0; i < ans.size(); i++) {
            List<Integer> row = ans.get(i);
            for (int j = 0; j < 2; j++) {
                finalAns[i][j] = row.get(j);
            }
        }

        return finalAns;
    }
}