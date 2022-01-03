//Abdul-Samad Olagunju
//Ms. Dalal
//AP Computer Programming
//November 1, 2018

import java.util.*;

public class Magpie2 {

	public String GreetingUser()
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("AI: Hi. How are you doing?");
		String response = scan.nextLine();

		response = "AI: Wow, I feel the same. Tell me, Do you like to listen to pop, rock, or rap?";
		return response;
	}
	public String OutputResponse(String userresponse)
	{
		String response = "";
		if( (findKeyword(userresponse, "pop", 0) != -1) || (findKeyword(userresponse, "rock", 0) != -1) || (findKeyword(userresponse, "rap", 0) != -1))
		{
			response = "AI: You have good taste in music. How do you feel when listening to music?";
		}
		else if(userresponse.length() == 0)
		{
			response = "Can you respond to me.";
		}
		else if(findKeyword(userresponse, "I want to", 0) >= 0)
		{
			response = IWantTo(userresponse);
		}
		else if((findKeyword(userresponse, "you", 0) >= 0) && (findKeyword(userresponse, "me", 0) >= 0))
		{
			response = transformYouMe(userresponse);
		}
		else 
		{
			response = ChooseRandomQuestion();
		}
		return response;
	}
	public String ChooseRandomQuestion()
	{
		Random generator = new Random();
		String otherresponse = "";
		int num = generator.nextInt(3) + 1;
		if(num == 1)
		{ 
			otherresponse = "AI: Hmmm. Very Interesting... Is there something about me that you’ve always wanted to know but have never asked?";
		}
		if(num == 2)
		{
			otherresponse = "AI: Ok. Off on a tangent...Do you have any regrets?";
		}
		if(num == 3)
		{
			otherresponse = "AI: That's ok. Random question: How has your life been different than what you’d imagined?";
		}
		return otherresponse;
	}
	public String IWantTo(String userresponse)
	{
		String response;
		userresponse = userresponse.trim();
		String lastChar = userresponse.substring(userresponse.length() - 1);
		if (lastChar.equals("."))
		{
			userresponse = userresponse.substring(0, userresponse.length() - 1);
		}
		int psn = findKeyword (userresponse, "I want to", 0);
		String something = userresponse.substring(psn + 9).trim();
		response = "Would you be really happy if you had " + something + "?";
		return response;
	}
	public String transformYouMe(String userresponse)
	{
		String response = "";
		userresponse = userresponse.trim();
		String lastChar = userresponse.substring(userresponse.length() - 1);
		if (lastChar.equals("."))
		{
			userresponse = userresponse.substring(0, userresponse.length() - 1);
		}
		
		int You = findKeyword (userresponse, "you", 0);
		int Me = findKeyword (userresponse, "me", You + 3);
		
		String something = userresponse.substring(You + 3, Me).trim();
		response = "What makes you think that I " + something + " you?";
		return response;
	}
	private int findKeyword(String statement, String goal, int startPos)
	{
		String phrase = statement.trim();
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
		while (psn >= 0)
		{
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring (psn - 1, psn).toLowerCase();
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(psn + goal.length(),
				psn + goal.length() + 1).toLowerCase();
			}
			/* determine the values of psn, before, and after at this point in the method. */
			if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))
			&&
			((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
			{
				return psn;
			}
			psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
		}
		 return -1;
	}
	}