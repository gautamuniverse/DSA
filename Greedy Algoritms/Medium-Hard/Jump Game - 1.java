class Solution {
    public boolean canJump(int[] nums) {
        //Base cases
     int reachable = 0;  //THIS REPRESENTS THE CURRENT INDEX IS REACHABLE OR NOT
       for(int i = 0; i < nums.length; i ++) {
           if(i > reachable) return false;  //THIS MEANS THAT WE HAVE REACHED AN INDEX WHICH IS GREATER THAN THE REACHABLE, THAT IS WE NEVER ENCOUNTERED AN INDEX HAVING JUMP SIZE THAT COULD REACH THIS INDEX.
           reachable = Math.max(reachable, i + nums[i]);  //IF THE CURRENT JUMP SIZE IS GREATER THAN WHAT WE CAN REACH BY CURRENT MAX JUMP SIZE THEN WE WILL UPDATE THE REACHABLE WITH NEW INCREASED REACHABLE INDEX JUMP SIZE.
       } 
       return true;
      
    }
}