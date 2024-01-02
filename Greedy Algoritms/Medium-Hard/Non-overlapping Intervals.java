class Solution {
    public int eraseOverlapIntervals(int[][] in) {
        //sort in ascending order of the end times so that we can compare the current interval with the previous interval if it overlaps or not
        Arrays.sort(in, (a,b)->a[1]-b[1]);
        //starting res with -1 so as to avoid incrementing count for the first element.
        //p[] will contain the previous interval array
        //Whenever there is an overlap we will increment the res counter
        int res=-1, p[]=in[0];
        for(int[] i: in)
            if(i[0]<p[1]) res++;
            else p=i;
        return res;
    }
}