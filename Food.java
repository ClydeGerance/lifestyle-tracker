/**

This is a template for a Java file. Contains the data and actions for food.

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

public class Food {
	
	
	//instance fields
	private String food;
	private double calorieAmount;
	private double serving;

	//constructor
	public Food(String f, double sv, double c) {
		food = f;
		serving = sv;
		calorieAmount = c;

	}

	public Food(String f, double c) {
		food = f;
		calorieAmount = c;
	}

	//methods
	public String getFoodName() {
		return food;
	}

	public double getFoodServing() {
		return serving;
	}

	public double getFoodCalories() {
		return calorieAmount;
	}

	public void updateCalories(double c) {
		calorieAmount = c;
		c = calorieAmount;
	}
}