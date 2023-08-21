class Solution {

    public static void reverse(int nums[], int start, int end){
    // While start index is less than end index
    while(start < end){
        // Swap elements at start and end indices
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        // Increment start index and decrement end index
        start++;
        end--;
    }
}

    public void rotate(int[] nums, int k) {
        // Ensure k is within array bounds
        k %= nums.length;
        // Reverse entire array
        reverse(nums, 0, nums.length - 1);
        // Reverse first k elements
        reverse(nums, 0, k - 1);
        // Reverse remaining elements
        reverse(nums, k, nums.length - 1);
    }
}


// class Solution {
//     public void rotate(int[] nums, int k) {
//         int [] ans = new int[nums.length];
//         for(int i = 0; i<nums.length; i++)
//         {
//             ans[(i+k)%nums.length] = nums[i];
//         }
//         for(int i = 0; i<nums.length; i++)
//         {
//             nums[i] = ans[i];
//         }
//     }

//     // public void rotate(int[] nums, int k) {
//     //     if(nums.length == 1)
//     //     return;
        
//     //     for(int j = 0; j<k; j++)
//     //     {
//     //     int prev = nums[0];
//     //     int current = nums[1];
//     //     for(int i =1; i<nums.length-1; i++)
//     //     {   current = nums[i]; 
//     //         nums[i] = prev;
//     //         prev = current;
//     //     }  
//     //     int temp = nums[nums.length-1];
//     //     nums[nums.length-1] = prev;
//     //     nums[0] = temp;
//     //     }
//     // }
// }