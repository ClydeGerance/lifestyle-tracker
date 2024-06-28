/**

This is a template for a Java file. Contains the data and actions for activities.

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


public class Activity {


	//instance fields
	private String activityName;
	private double time;
	private double calorieAmount;

	//constructor
	public Activity (String n, double hrs, double c) {
		activityName = n;
		time = hrs;
		calorieAmount = c;
	}

	public Activity(String n, double c) {
		activityName = n;
		calorieAmount = c;
	}

	//methods
	public String getActivityName() {
		return activityName;
	}

	public double getActivityHours() {
		return time;
	}

	public double getActivityCalories() {
		return calorieAmount;
	}

	public void updateCalories(double c) {
		calorieAmount = c;
		c = calorieAmount;
	}


}