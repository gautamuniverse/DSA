class Solution {
    public boolean lemonadeChange(int[] bills) {
        long five = 0, ten = 0;

        for(int i : bills)
        {
            if(i == 5)
            {   
                five+=1;
                
            }
           else if(i == 10)
            {   ten+=1;
            
                if(five<=0) return false;
                five-=1;
            }
           else
            {   
                if(five>=1 && ten>=1)
                {   
                    ten-=1;
                    five-=1;
                }
                else if(five>=3 && ten<1)
                {
                    five-=3;
                }
                else return false;
            }

        }
        return true;
    }
}