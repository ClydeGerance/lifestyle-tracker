/**

This is a template for a Java file. It has the main method of the LifeStyleTracker.

@author Clyde Lester M. Gerance (185503))
@version December 5, 2022

**/
/*
I have not discussed the Java language code in my program 
with anyone other than my instructor or the teaching assistants 
assigned to this course.
I have not used Java language code obtained from another student, 
or any other unauthorized source, either modified or unmodified.
If any Java language code or documentation used in my program 
was obtained from another source, such as a textbook or website, 
that has been clearly noted with a proper citation in the comments 
of my program.
*/


import java.util.Scanner;

public class TrackerConsole {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//instance fields
		String action;
		String name;
		double amount;

		LifestyleTracker lt = new LifestyleTracker();

		System.out.printf("Welcome to %s's Lifestyle Tracker!\n", args[0]);
		
		while (true) { 
			action= in.next();

			if (action.equalsIgnoreCase("food")) {
				name = in.next();
				amount = in.nextDouble();
				System.out.println(lt.addFood(name,amount));
			}
			
			if (action.equalsIgnoreCase("eat")) {
			name = in.next();
			amount = in.nextDouble();
			System.out.println(lt.eat(name,amount));
			}

			if (action.equalsIgnoreCase("activity")){
				name = in.next();
				amount = in.nextDouble();
				System.out.println(lt.addActivity(name,amount));
			}

			if (action.equalsIgnoreCase("perform")){
				name = in.next();
				amount = in.nextDouble();
				System.out.println(lt.perform(name,amount));
			}
			
			if (action.equalsIgnoreCase("edit")) {
				System.out.println(lt.editReport());
			}

			if (action.equalsIgnoreCase("remove")) {
				System.out.println(lt.removeReport());
			}

			if (action.equalsIgnoreCase("report")) {
				System.out.println(lt.report());
				break;
			}
			
		} 
	}
}