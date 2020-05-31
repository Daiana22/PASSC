package horoscop;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		DBInterface database = new MySQLDB();
		HoroscopePrediction h = new HoroscopePrediction(database.getStudentsFromDB());
		Scanner keyboard = new Scanner(System.in);
		while(true) {
		System.out.println("Menu:");
		System.out.println("1.List all students");
		System.out.println("2.Predict the increase or decrease of a students grade.");
		System.out.println("3.Predict how many students will have lower grades.");
		System.out.println("4.Predict if a student will have a good day or not.");
		System.out.println("5.Exit.");
		System.out.println("Your option:");
	
		int option;
		int id;
		String NewId;
		option = keyboard.nextInt();
		
		switch(option) {
			case 1:
				h.getAllStudents();
				break;
			case 2:
				System.out.print("Student Id=");
				id = keyboard.nextInt();
				NewId = Integer.toString(id);
				System.out.println("Prediction: " + h.generateGradePrediction(NewId));
				break;
			case 3:
				System.out.println("There will be a number of " + h.determineStudentsWithLowerGradesInTheFuture() + " students with grades that will decrease.");
				break;
			case 4:
				System.out.print("Id=");
				id = keyboard.nextInt();
				NewId = Integer.toString(id);
				System.out.println("Prediction: " + h.willHaveAGoodDayOrNot(NewId));
				break;
			case 5:
				keyboard.close();
				return;
			}
		}

	}


}
