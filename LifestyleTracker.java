/**

This is a template for a Java file. Has all the methods for the Tracker to function. It also contain an addition undo function during some processes of record from Food/Activity.

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

Modifying elements inside the ArrayList- https://howtodoinjava.com/java/collections/arraylist/replace-element-arraylist/
Getting Last Item in Arraylist - https://stackoverflow.com/questions/22977272/how-to-get-last-item-in-arrayliststring?fbclid=IwAR1ygNSlhdIr3xE_inWN5mr1_e0nsUhpHywonwmmZFB2BnRmKIWuPGLOEPQ
Finding out the index of a particular element- https://beginnersbook.com/2013/12/java-arraylist-indexof-method-example/?fbclid=IwAR16qqKPD0nA4ZpdgKWIghdQ7oMum4gqCaQTMKZvbc8K99nOtX5NoXfrCVw
Getting Index of a particular element in the ArrayList- https://www.tutorialspoint.com/get-the-index-of-a-particular-element-in-an-arraylist-in-java
Formatting String - https://www.javatpoint.com/java-string-format?fbclid=IwAR0p52r1jEP1LCWW6GBKTjJDY6vbzw-RhL0Gyhk3rWdt8wG_bCjIlv8JKpI
Removing an element in the ArrayList- https://www.geeksforgeeks.org/remove-element-arraylist-java/
	
*/
import java.util.ArrayList;
import java.util.Scanner;

public class LifestyleTracker {
	
	Scanner in = new Scanner(System.in);
	
	//Food
	private ArrayList<Food> food;
	private ArrayList<String> ate;
	private ArrayList<Food> newFood;
	private ArrayList<Food> undoFood;
	private String feedbackFood;
	private String feedbackEat;

	//Activity
	private ArrayList<Activity> activity;
	private ArrayList<String> performed;
	private ArrayList<Activity> newActivity;
	private ArrayList<Activity> undoActivity;
	private String feedbackPerform;
	private String feedbackActivity;
	
	//Other
	private String printReport;
	private double totalCalGained;
	private double totalCalBurned;
	private double kcal;
	private String edit;
	private String remove;


	//Constructor
	public LifestyleTracker() {
		
		//Food
		food = new ArrayList<>();
		ate = new ArrayList<String>();
		newFood = new ArrayList<>();
		undoFood = new ArrayList<>();
		
		//Activity	
		activity = new ArrayList<>();
		performed = new ArrayList<String>();
		newActivity = new ArrayList<Activity>();
		undoActivity = new ArrayList<>();
	
		//Other
		printReport = "";
		totalCalGained = 0;
		totalCalBurned = 0;
		kcal = 0.00012959782;
		edit = "";
		remove = "";
	}
	
	//Methods
	
	public String editReport() {
		
		System.out.print("Which records do you want to access? (Ate/Performed): ");
		String er = in.next();
		
		if (er.equalsIgnoreCase("ate")) {
			
			System.out.print("-----------------\n");
			System.out.print("RECORDS OF FOOD EATEN\n");
			System.out.print( "-----------------\n");
			
			if (newFood.size()==0) {
				
				System.out.print("No records found.\n");
				edit = "-----------------";
				
			} else if (newFood.size() > 0) {
				
				int reportNum = 1;
				
				for (Food uc : newFood){
					
					System.out.printf("Record %d | %.2f serving(s) of %s, %.2f kcal\n", reportNum++, uc.getFoodServing(), uc.getFoodName(), uc.getFoodCalories()*uc.getFoodServing());
				}
				System.out.print( "-----------------");
				System.out.print("\nWhich specific record number would you like to update?: ");
				int record = in.nextInt();
				
				while (true) {
					
					if (record <= newFood.size()) { 
					
						for( Food uc:newFood) {
							
							if ((newFood.indexOf(uc))+ 1 == record) {
								
								System.out.printf("How many number of serving(s) do you wish to update for Record %d?: ", record);
								double updateNum=in.nextDouble();
								
								while (true) {
									
									if (updateNum > 0) {
										ate.set(record - 1, String.format("%.2f serving(s) of %s, %.2f kcal", updateNum, (newFood.get(record - 1)).getFoodName(), (newFood.get(record - 1)).getFoodCalories()*updateNum));
										totalCalGained -= (newFood.get(record - 1)).getFoodCalories()*(newFood.get(record - 1)).getFoodServing();
										totalCalGained += (newFood.get(record - 1)).getFoodCalories()*updateNum;
										edit = String.format("Successfully updated Record %d to: %.2f serving(s) of %s, %.2f kcal", record, updateNum, (newFood.get(record - 1)).getFoodName(), (newFood.get(record - 1)).getFoodCalories()*updateNum);
										newFood.set(record - 1, new Food ( (newFood.get(record - 1)).getFoodName(), updateNum, (newFood.get(record - 1)).getFoodCalories()));										
										break;
										
									} else {
										
										System.out.print("Invalid input. Please input a number greater than 0: ");
										updateNum = in.nextDouble();
									}
								}
								break;
							}
						}
						break;
						
					} else {
						
						System.out.print("Invalid input. Please input a number found in the records: ");
						record = in.nextInt();
					}
				}
			}
		} else if(er.equalsIgnoreCase("performed")) {
			
			System.out.print("-----------------\n");
			System.out.print("RECORDS OF ACTIVITIES PERFORMED\n");
			System.out.print( "-----------------\n");
			
			if (newActivity.size() == 0) {
				
				System.out.print("No records found.\n");
				edit= "-----------------";
				
			} else if (newActivity.size() > 0) {
				
				int reportNum = 1;
				
				for (Activity up : newActivity){
					
					System.out.printf("Record %d | %.2f hour(s) of %s, %.2f kcal\n", reportNum++, up.getActivityHours(), up.getActivityName(), up.getActivityCalories()*up.getActivityHours());
				}
				System.out.print( "-----------------");
				System.out.print("\nWhich specific record number would you like to update?: ");
				int record = in.nextInt();
				
				while (true) {
					
					if (record <= newActivity.size()) { 
					
						for( Activity up:newActivity) {
							
							if ((newActivity.indexOf(up)) + 1 ==record) {
								
								System.out.printf("How many number of hour(s) do you wish to update for Record %d?: ", record);
								double updateNum = in.nextDouble();
								
								while (true) {
									
									if (updateNum > 0) {
										
										performed.set(record - 1, String.format("%.2f hour(s) of %s, %.2f kcal", updateNum, (newActivity.get(record - 1)).getActivityName(), (newActivity.get(record - 1)).getActivityCalories()*updateNum));
										totalCalBurned -= (newActivity.get(record - 1)).getActivityCalories()*(newActivity.get(record - 1)).getActivityHours();
										totalCalBurned += (newActivity.get(record - 1)).getActivityCalories()*updateNum;
										edit = String.format("Successfully updated Record %d to: %.2f hour(s) of %s, %.2f kcal", record, updateNum, (newActivity.get(record - 1)).getActivityName(), (newActivity.get(record - 1)).getActivityCalories()*updateNum);
										newActivity.set(record - 1, new Activity ( (newActivity.get(record - 1)).getActivityName(), updateNum, (newActivity.get(record - 1)).getActivityCalories()));										
										break;
				
									} else {
										
										System.out.print("Invalid input. Please input a number greater than 0: ");
										updateNum = in.nextDouble();
									}
								}
							}
						}
						break;	
						
					} else {
						
						System.out.print("Invalid input. Please input a number found in the records: ");
						record=in.nextInt();
					}
				}
			}
		} else {
			
			edit = "Invalid input.";
		}
		return edit;
	}

	public String removeReport(){
		
		System.out.print("Which records do you want to remove? (Ate/Performed): ");
		String rr = in.next();
		
		if (rr.equalsIgnoreCase("ate")) {
			
			System.out.print("-----------------\n");
			System.out.print("RECORDS OF FOOD EATEN\n");
			System.out.print( "-----------------\n");
			
			if (newFood.size() == 0) {
				
				System.out.print("No records found.\n");
				remove = "-----------------";
				
			} else if (newFood.size() > 0) {
				
				int reportNum = 1;
				for (Food uc : newFood){
					
					System.out.printf("Record %d | %.2f serving(s) of %s, %.2f kcal\n", reportNum++, uc.getFoodServing(), uc.getFoodName(), uc.getFoodCalories()*uc.getFoodServing());
				}
				System.out.print( "-----------------");
				System.out.print("\nWhich specific record number would you like to remove?: ");
				int record = in.nextInt();
				
				while (true) {
					
					if (record <= newFood.size()) {
						
						for( Food uc:newFood) {
							
							if ((newFood.indexOf(uc))+ 1 == record) {
								
								undoFood.add(newFood.get(record - 1));
								totalCalGained -= (newFood.get(record - 1)).getFoodCalories()*(newFood.get(record - 1)).getFoodServing();
								ate.remove(record - 1);
								newFood.remove(record - 1);
								System.out.printf("Successfully removed Record %d. Do you want to undo? (Yes/No): ", record);
								String undoF=in.next();
								
								if (undoF.equalsIgnoreCase("Yes")) {
									
									ate.add(String.format("%.2f serving(s) of %s, %.2f kcal", undoFood.get(undoFood.size() - 1).getFoodServing(), undoFood.get(undoFood.size()-1).getFoodName(), undoFood.get(undoFood.size()-1).getFoodCalories()*undoFood.get(undoFood.size()-1).getFoodServing() ));
									newFood.add(undoFood.get(undoFood.size() - 1));
									totalCalGained+= (undoFood.get(undoFood.size() - 1)).getFoodCalories()*(undoFood.get(undoFood.size() - 1)).getFoodServing();
									remove = String.format("You have added Record %d back in the list.", record);
									
									break;
									
								} else if (undoF.equalsIgnoreCase("No")) {
									
									remove = String.format("Record %d has not been added back.", record);
									
									break;
									
								} else{
						
									System.out.println("Invalid input.");
									remove = String.format("Record %d has not been added back.", record);
									
									break;
								}
							}
						}
						break;
						
					} else {
						
						System.out.print("Invalid input. Please input a number found in the records: ");
						record=in.nextInt();
					}
				}
			}
		} else if (rr.equalsIgnoreCase("performed")) {
			
			System.out.print("-----------------\n");
			System.out.print(" RECORDS OF ACTIVITIES PERFORMED \n");
			System.out.print( "-----------------\n");
			
			if (newActivity.size() == 0) {
				System.out.print("No records found.\n");
				remove= "-----------------";
				
			} else if (newActivity.size() > 0) {
				
				int reportNum = 1;
				
				for (Activity uc : newActivity){
					
					System.out.printf("Record %d | %.2f hour(s) of %s, %.2f kcal\n", reportNum++, uc.getActivityHours(), uc.getActivityName(), uc.getActivityCalories()*uc.getActivityHours());
				}
				System.out.print( "-----------------");
				System.out.print("\nWhich specific record number would you like to remove?: ");
				int record = in.nextInt();
				
				while (true) {
					
					if (record <= newActivity.size()) { 
					
						for( Activity uc:newActivity) {
							
							if ((newActivity.indexOf(uc)) + 1 == record) {
								
								undoActivity.add(newActivity.get(record - 1));
								totalCalBurned -= (newActivity.get(record - 1)).getActivityCalories()*(newActivity.get(record - 1)).getActivityHours();
								performed.remove(record - 1);
								newActivity.remove(record - 1);
								System.out.printf("Successfully removed Record %d. Do you want to undo? (Yes/No): ", record);
								String undoA = in.next();
								
								if (undoA.equalsIgnoreCase("Yes")) {
									
									performed.add(String.format("%.2f hour(s) of %s, %.2f kcal", undoActivity.get(undoActivity.size() - 1).getActivityHours(), undoActivity.get(undoActivity.size() - 1).getActivityName(), undoActivity.get(undoActivity.size() - 1).getActivityCalories()*undoActivity.get(undoActivity.size() - 1).getActivityHours() ));
									newActivity.add(undoActivity.get(undoActivity.size() - 1));
									totalCalBurned += (undoActivity.get(undoActivity.size() - 1)).getActivityCalories()*(undoActivity.get(undoActivity.size()-1)).getActivityHours();
									remove = String.format("You have added Record %d back in the list.", record);
									break;
									
								} else if (undoA.equalsIgnoreCase("No")) {
									
									remove = String.format("Record %d has not been added back.", record);
									
									break;
									
								} else{
						
									System.out.println("Invalid input.");
									remove = String.format("Record %d has not been added back.", record);
									
									break;								
								}
							}
						}
						break;		
						
					} else {
						
						System.out.print("Invalid input. Please input a number found in the records: ");
						record = in.nextInt();
					}
				}
			}
		} else {
			
			remove = "Invalid input.";
		}
		return remove;
	} 

	
	public String addFood(String n, double c) {
		
		while (true) {
			
			if (c >= 0) {
				
				food.add( new Food (n,c) );
				
				for (Food f : food) {
					
					if (f == food.get(food.size() - 1)) {
						
						feedbackFood = String.format("Added Food %s with %.2f kcal", n, c);
						break;
						
					} else if (f.getFoodName().equalsIgnoreCase(n)) {
						
						f.updateCalories(c);
						feedbackFood=String.format("Updated Food %s with %.2f kcal", f.getFoodName(), f.getFoodCalories());
						break;
					}
				}
				break;
				
			} else {
				
				System.out.print("Invalid input. Please input another value: ");
				c = in.nextDouble();
			}
		}
		return feedbackFood;		
	}

	public String addActivity(String n, double c) {
		
		while (true) {	
		
			if (c >= 0) {	
			
				activity.add( new Activity(n,c) );
				
				for (Activity a : activity) {
				
					if (a == activity.get(activity.size()-1)) {
						feedbackActivity = String.format("Added Activity %s with %.2f kcal", n, c);
					break;
					
					} else if (a.getActivityName().equalsIgnoreCase(n)) {
						
						a.updateCalories(c);
						feedbackActivity=String.format("Updated Activity %s with %.2f kcal", a.getActivityName(), a.getActivityCalories());
						break;
					}
				}
				break;
				
			} else {
				
				System.out.print("Invalid input. Please input another value: ");
				c = in.nextDouble();
			}
		}
		return feedbackActivity;		
	}

	public String eat(String foodName, double servings) {
		
		if (food.size() == 0) {
			
			System.out.print("The specified food does not exist. Do you wish to add this Food first? (Yes/No): "); 
			String fdAnswer = in.next(); 
			
			if (fdAnswer.equalsIgnoreCase("Yes")){
				
				System.out.print("Calorie intake per serving: ");
				double c = in.nextDouble();
				
				while (true) {
					
					if (c >= 0) {
						
						food.add( new Food (foodName, c));
						System.out.printf("Added Food %s with %.2f kcal to the records. How many serving(s) do you wish to eat?: ", foodName, c);
						double serving = in.nextDouble();
						
						while (true) {
							
							if (serving > 0) {
								
								ate.add(String.format("%.2f serving(s) of %s, %.2f kcal",serving, foodName, c * serving));
								feedbackEat = String.format("Ate %.2f serving(s) of %s, %.2f kcal", serving, foodName, c*serving);
								totalCalGained += c * serving;
								newFood.add(new Food (foodName, serving, c));
								break;
								
							} else {
								
								System.out.print("Invalid input. Please input a value greater than 0: ");
								serving = in.nextDouble();
							}
						}
						break;
						
					} else {
						
						System.out.print("Invalid input. Please input another value: ");
						c = in.nextDouble();
					}
				}

			} else if (fdAnswer.equalsIgnoreCase("No")){
				
				feedbackEat = String.format("Food %s was not added.", foodName);
				
			} else {
				
				feedbackEat = String.format("Food %s was not added.", foodName);
				System.out.println("Invalid input.");
			}

		} else {
			
			for (Food f : food) {
				
				if (f.getFoodName().equalsIgnoreCase(foodName)) {
					
					while (true) {
						
						if (servings > 0) {
							
							feedbackEat = String.format( "Ate %.2f servings(s) of %s, %.2f kcal", servings, foodName, f.getFoodCalories() * servings);
							ate.add(String.format("%.2f serving(s) of %s, %.2f kcal", servings, foodName, f.getFoodCalories() * servings));
							totalCalGained += f.getFoodCalories() * servings;
							newFood.add(new Food (foodName, servings, f.getFoodCalories()));
							break;
							
						} else {
							
							System.out.print("Invalid input. Please input a value greater than 0: ");
							servings = in. nextDouble();					
						}
					}
					break;
					
				} else if (f == food.get(food.size() - 1)) {
					
					System.out.print("The specified food does not exist. Do you wish to add this food first? (Yes/No): "); 
					String answerF2 = in.next();
					
					if (answerF2.equalsIgnoreCase("Yes")){
						
						System.out.print("Calorie intake per serving: ");
						double c = in.nextDouble();
						
						while (true) {
							
							if (c >= 0) {
								
								food.add( new Food (foodName, c));
								System.out.printf("Added Food %s with %.2f kcal to the records. How many serving(s) do you wish to eat?: ", foodName, c);
								double serve = in.nextDouble();

								while (true) {
									
									if (serve > 0) {
										
										ate.add(String.format("%.2f serving(s) of %s, %.2f kcal", serve, foodName, c * serve));
										feedbackEat = String.format("Ate %.2f serving(s) of %s, %.2f kcal", serve, foodName, c * serve);
										totalCalGained += c * serve;
										newFood.add(new Food (foodName, serve, c));	
										break;
										
									} else {
										
										System.out.print("Invalid input. Please input a value greater than 0: ");
										serve = in.nextDouble();
									}
								}
								break;
								
							} else {
								
								System.out.print("Invalid input. Please input another value: ");
								c = in.nextDouble();
							}
						}
						break;
						
					} else if (answerF2.equalsIgnoreCase("No")) {
						
						feedbackEat = String.format("Food %s was not added.", foodName);
						
					} else {
				
						feedbackEat = String.format("Food %s was not added.", foodName);
						System.out.println("Invalid input.");
						
						break;
					}
				}	
			}
		}
		return feedbackEat;
	}

	public String perform(String ActName, double hours) {
		
		if (activity.size() == 0) {
			
			System.out.print("The specified activity does not exist. Do you wish to add this activity first? (Yes/No): "); 
			String actAnswer = in.next();
			
			if (actAnswer.equalsIgnoreCase("Yes")){
				
				System.out.print("Calories to burn per hour: ");
				double d = in.nextDouble();
				
				while (true) {
					
					if (d >= 0) {
						
						activity.add( new Activity (ActName, d));
						System.out.printf("Added Activity %s with %.2f kcal to the records. How many hour(s) do you wish to perform?: ", ActName, d);
						double hour = in.nextDouble();
						
						while(true) {
							
							if (hour > 0) {
								
								performed.add(String.format("%.2f hour(s) of %s, %2f kcal", hour, ActName, d * hour));
								feedbackPerform = String.format("Performed %.2f hour(s) of %s, %.2f kcal", hour, ActName, d *hour);
								totalCalBurned+=d*hour;
								newActivity.add(new Activity (ActName, hour, d));
								break;
								
							} else {
								
								System.out.print("Invalid input. Please input a value greater than 0: ");
								hour=in.nextDouble();
							}
						}
						break;
						
					} else {
						
						System.out.print("Invalid input. Please input another value: ");
						d=in.nextDouble();
					}
				}
			} else if (actAnswer.equalsIgnoreCase("No")){
				
				feedbackPerform = String.format("Activity %s was not added.", ActName);
				
			} else {
				
				System.out.println("Invalid input.");
				feedbackPerform = String.format("Activity %s was not added.", ActName);
			}
	
		} else {
			
			for (Activity a : activity) {
				
				if (a.getActivityName().equalsIgnoreCase(ActName)) {
					
					while (true) {
						
						if (hours>0) {
							
							feedbackPerform = String.format( "Performed %.2f hours(s) of %s, %.2f kcal", hours, ActName, a.getActivityCalories()*hours);
							performed.add(String.format("%.2f hour(s) of %s, %.2f kcal", hours, ActName, a.getActivityCalories()*hours));
							totalCalBurned+=a.getActivityCalories()*hours;
							newActivity.add(new Activity (ActName, hours, a.getActivityCalories()));
							break;
							
						} else {
							
							System.out.print("Invalid input. Please input a value greater than 0: ");
							hours=in.nextDouble();
						}
					}
					break;
					
				} else if (a==activity.get(activity.size()-1)) {
					
					System.out.print("The specified activity does not exist. Do you wish to add this Activity first? (Yes/No): "); 
					String answerA2=in.next();
					
					if (answerA2.equalsIgnoreCase("Yes")){
						
						System.out.print("Calories to burn per hour: ");
						double cal2=in.nextDouble();
						
						while (true) {
							
							if (cal2>=0) {
								
								activity.add( new Activity (ActName, cal2));
								System.out.printf("Added Activity %s with %.2f kcal to the records. How many hour(s) do you wish to perform?: ", ActName, cal2);
								double h=in.nextDouble();
								
								while (true) {
									
									if (h>0) {
										
										performed.add(String.format("%.2f hour(s) of %s, %.2f kcal", h, ActName, cal2*h));
										feedbackPerform = String.format("Performed %.2f hour(s) of %s, %.2f kcal", h, ActName, cal2*h);
										totalCalBurned+=cal2*h;
										newActivity.add(new Activity (ActName, h, cal2));
										break;
										
									} else {
										
										System.out.print("Invalid input. Please input a value greater than 0: ");
										h=in.nextDouble();
									}
								}
								break;
								
							} else {
								
								System.out.print("Invalid input. Please input another value: ");
								cal2=in.nextDouble();
							}
						}
						break;
						
					} else if (answerA2.equalsIgnoreCase("No")){
						
						feedbackPerform = String.format("Activity %s was not added.", ActName);
						break;
						
					} else{
						
						System.out.println("Invalid input.");
						feedbackPerform = String.format("Activity %s was not added.", ActName);
					}
				}
			}
		}
		return feedbackPerform;
	}

	
	public String report() { 
	
		printReport += ("----------------\n");
		printReport += ("LIFESTYLE REPORT\n");
		printReport += ("----------------\n");
		printReport += ("Food Ate:\n");
		
		if (ate.size()==0)
			
			printReport += "No food ate.\n";
			
		else {
			
			for (String c : ate)
				printReport += (c) + "\n";
		}
		printReport += ("----------------\n");
		printReport += (String.format("Total Calories Ate: %.2f kcal\n", totalCalGained));
		printReport += ("----------------\n");
		printReport += ("Activities Performed:\n");
		
		if (performed.size()==0)
			
			printReport += "No activities performed.\n";
			
		else {
			for (String p : performed)
				printReport += (p) + "\n";
		}
		printReport += ("----------------\n");
		printReport += (String.format("Total Calories Burned: %.2f kcal\n", totalCalBurned));
		printReport += ("----------------\n");
		double netCal = totalCalGained-totalCalBurned;
		printReport += (String.format("Net Calories for the day: %.2f kcal\n", netCal));
		printReport += ("If you keep up this lifestyle...\n");
		
		if (netCal<0) {
			
			printReport += (String.format("In a week, you will lose %.2f kilograms.\n", (-netCal*kcal*7)));
			printReport += (String.format("In a month, you will lose %.2f kilograms.\n", (-netCal*kcal*30)));
			printReport += (String.format("In 3 months, you will lose %.2f kilograms.\n", (-netCal*kcal*30*3)));
			printReport += (String.format("In 6 months, you will lose %.2f kilograms.\n", (-netCal*kcal*30*6)));
			
		} else {
			
			printReport += (String.format("In a week, you will gain %.2f kilograms.\n", (netCal*kcal*7)));
			printReport += (String.format("In a month, you will gain %.2f kilograms.\n", (netCal*kcal*30)));
			printReport += (String.format("In 3 months, you will gain %.2f kilograms.\n", (netCal*kcal*30*3)));
			printReport += (String.format("In 6 months, you will gain %.2f kilograms.\n", (netCal*kcal*30*6)));
		}
		printReport += ("----------------");
		
		return printReport;
	}

}