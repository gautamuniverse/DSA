class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //Naive
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for(int j=0;i<g.length && j<s.length;)
        {
            if(s[j] >= g[i])
            {
                j++;
                i++;  //represents count. we are only incrementint count when a cookie was assigned so no need of a separate count variable.
            }
            else
            {
                j++;
            }
        }

        return i;
    }
}