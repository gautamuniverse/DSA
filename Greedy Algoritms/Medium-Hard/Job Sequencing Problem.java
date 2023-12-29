class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        
        // //Sort the array in the descending order of profits
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
//get the maximum deadline from the jobs
      int maxi = 0;
      for (int i = 0; i < n; i++) {
         if (arr[i].deadline > maxi) {
            maxi = arr[i].deadline;
         }
      }
// //Create a job sequencing array of the maxDeadline size
      int result[] = new int[maxi + 1];
// //prefill all deadline representing indexes values to -1
      for (int i = 1; i <= maxi; i++) {
         result[i] = -1;
      }

      int countJobs = 0, jobProfit = 0;
// Iterate through the array and perform a job at its last day possible.
      for (int i = 0; i < n; i++) {
//Why greater than 0?  because deadline can't be 0
         for (int j = arr[i].deadline; j > 0; j--) {

            // Free slot found 
            if (result[j] == -1) {
               result[j] = i;
               countJobs++;
               jobProfit += arr[i].profit;
               break;
            }
         }
      }

      int ans[] = new int[2];
      ans[0] = countJobs;
      ans[1] = jobProfit;
      return ans;

    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/