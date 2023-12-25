class Solution {
    //  public  boolean isvalid(String s){

    // }
    public boolean checkValidString(String s) {

        //O(n)  O(1) space solution

        int cmin = 0; //this for counting the minimum number of open braces required to accomodate the right parenthesis
        int cmax = 0; //this for counting the upper range of open braces, that we can have, here the upper range means that the * will be contributing to the total open braces

        for(char i : s.toCharArray())
        {
            if(i == '(')
            {
                cmin++;
                cmax++;
            }
            else if(i == ')')
            {
                cmax--;
                cmin--;
            }
            else if( i == '*')
            {
                cmax++; //the * if becomes '(' then the upper range of the open braces increase
                cmin--; //the * doesnt contribute to become '(' therefore min count decreases

                //if * becomes '' empty, then nothing happens
                //Now new range of open - [cmax+1, cmin-1]
            }

            if(cmax < 0)//we have encountered a situation where we are out of open braces, that is for example: "())("
            {
                //so we will straight up return false
                return false;
            }

            cmin = Math.max(cmin, 0); //cmin cant become less than 0, that is invalid
        }
        return cmin==0; //if we have no open braces presnet that means we were able to accomodate all the closing parenthesis. therefore return true.
        //Otherwise will return false, because there are some open parenthesis presnet for which there are no closing parenthesis and also for which there were no stars


      
        // Stack<Integer> stack=new Stack<>();
        // Stack<Integer> st=new Stack<>();
        // int count=0;
        // boolean flag=false;
        // for(int i=0;i<s.length();i++){
        //     if(s.charAt(i)=='*'){
               
        //        st.push(i);
        //     }
        //      else if(s.charAt(i)=='('){
        //         stack.push(i);
        //     }
           
            
        //     else{// toh close hoga toh open ko n pop krdiya 
        //      if(!stack.isEmpty()){
        //         stack.pop();//agr woh empty hai then * ko pop krdiya bcz we can replace with the star
        //     }
        //     else if(!st.isEmpty()){
        //         st.pop();
        //     }
        //     else {
        //         return false;//agar dono empty retunr false
        //     }
        //     }
        // }
        // while(!stack.isEmpty()){//means open mai hai braces but replace ke liye star khtm return false
        //     if(st.isEmpty()){
        //         return false;
        //     }
        //     else if(stack.peek()<st.peek()){
        //         stack.pop();
        //         st.pop();
        //     }
        //     else{
        //         return false;
        //     }
        // }
        // return true;
        
    }
}