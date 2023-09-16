public class Solution 
{
	public static String reverseString(String str) 
	{
		//Write your code here
	// 	int left = 0;
	// int right = s.length() - 1;

	// String temp = "";
	// String ans = "";

	// //Iterate the string and keep on adding to form a word
	// //If empty space is encountered then add the current word to the result
	// while (left <= right)
	// {
	// 	char ch = s.charAt(left);
	// 	if (ch != ' ')
	// 	{
	// 		temp += ch;
	// 	}
	// 	else if (ch == ' ')
	// 	{
	// 		if (!ans.equals(""))
	// 		{
	// 			ans = temp + " " + ans;
	// 		}
	// 		else
	// 		{
	// 			ans = temp;
	// 		}
	// 		temp = "";
	// 	}
	// 	left++;
		
	// }

	// //If not empty string then add to the result(Last word is added)
	// if (!temp.equals(""))
	// {
	// 	if (!ans.equals(""))
	// 	{
	// 		ans = temp + " " + ans;
	// 	}
	// 	else
	// 	{
	// 		ans = temp;
	// 	}
	// }
	
	// return ans.trim();
	

	//Using the internal functions

	//  String words[]=str.split(" ");

    //     StringBuilder sb=new StringBuilder();

    //     for (int i=words.length-1; i>=0; i--) 

    //     {

    //         sb.append(words[i]);

    //          if (i > 0) {

    //             sb.append(" ");//add space

    //         }

    //     }

    //     return sb.toString();


		// Optimal Solution using Backward Travel: Time - O(N) and Space - O(N)

		if (str == null || str.length() == 0) 
		{
			return str;
		}

		StringBuilder ans = new StringBuilder();

		// if the string is " " then return ""
		if (str.length() == 1 && str.charAt(0) == ' ') 
		{
			return ans.toString();
		}

		int start = str.length() - 1;

		while (start >= 0) 
		{

			// Skip multiple spaces
			if (str.charAt(start) == ' ') 
			{
				start--;
			}

			else 
			{

				// Add space between words
				if (ans.length() > 0) 
				{
					ans.append(" ");
				}

				int j = start;

				// Loop for extracting word
				while (j >= 0 && str.charAt(j) != ' ') 
				{
					j--;
				}

				// add current word to ans
				ans.append(str.substring(j + 1, start + 1));
				start = j;
			}
		}

		return ans.toString();
	}
}
