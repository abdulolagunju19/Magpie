//Abdul-Samad Olagunju

import java.util.Scanner;
public class MagpieRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Magpie2 maggie = new Magpie2();
		System.out.println(maggie.GreetingUser());
		Scanner scan = new Scanner (System.in);
		String userentry = scan.nextLine();
		int counter = 0;
		 
		while(counter == 0)
		{
			System.out.println(maggie.OutputResponse(userentry));
			userentry = scan.nextLine();
			if(userentry.equals("Goodbye") || userentry.equals("Bye") || userentry.equals("bye"))
			{
				counter = 1;
			}
		}
		
	}
}
