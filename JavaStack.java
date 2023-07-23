// Question 8: Java Stack

// Skill Mapping: Basic

// Description: Solve the HackerRank Problem given as a link below -

// https://www.hackerrank.com/challenges/java-stack/problem

import java.util.*;
class Solution{
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            
            Stack<Character> st = new Stack<>();
            boolean flag = true;
            
            for(int i=0; i<input.length(); i++)
            {
                if(input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[')
                {
                    st.push(input.charAt(i));
                }
                else
                {
                    if(input.charAt(i) == ')' && !st.isEmpty() && st.peek() == '(')
                    {
                        st.pop();
                    }
                    else if(input.charAt(i) == '}' && !st.isEmpty() && st.peek() == '{')
                    {
                        st.pop();
                    }
                    else if(input.charAt(i) == ']' && !st.isEmpty() && st.peek() == '[')
                    {
                        st.pop();
                    }
                    else
                    {
                        flag = false;
                    }
                }
            }
            
            if(input.length() == 0)
            {
                System.out.println("true");
            }
            else if(flag == true && st.size() == 0)
            {
                System.out.println("true");
            }
            else
            {
                System.out.println("false");
            }
		}
		
	}
}
