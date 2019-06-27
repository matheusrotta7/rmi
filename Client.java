import java.rmi.Naming;
import java.io.*;
import java.util.*;


public class Client {

	public static void main (String[] args) throws Exception {
        AddI obj = (AddI) Naming.lookup("ADD");
		AddI obj2 = (AddI) Naming.lookup("SUBTRACT");
        int n = obj.add(12, 34);
		int m = obj2.subtract(12, 34);
        System.out.println("Addition = " + n);
		System.out.println("Subtraction = " + m);

        while (true) {
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Choose one of the following options: \n1: list all people that have graduated in a certain course\n2: list all skills in a city\n3: add new experience to a user\n4: given an email, show user's experience\n5: drop all information\n6: given email, show user's whole info\n");
            int choice = myObj.nextInt();  // Read user input
            if (choice == 1) {
                //user chose to list all names that graduated in a certain course
                //let's ask for the course
                System.out.println("Please inform the desired course: ");
                Scanner sc = new Scanner(System.in);  //
                String course = sc.nextLine();
                obj = (AddI) Naming.lookup("OPT1");
                ArrayList<String> result = obj.opt1(course);
                System.out.println("\n\nThe students that graduated said course are:\n" + result + "\n\n");
            }
            else if (choice == 2) {
                //user chose to list all skills that are present in a certain city
                //let's ask for the city
                System.out.println("Please inform the desired city: ");
                Scanner sc = new Scanner(System.in);
                String city = sc.nextLine();
                obj = (AddI) Naming.lookup("OPT2");
                ArrayList<String> result = obj.opt2(city);
                System.out.println("\n\nThe skills in said city are:\n" + result + "\n\n");
            }
            else if (choice == 3) {
                //user chose to add new experience to a certain user
                //let's ask for the user
                // Scanner sc = new Scanner(System.in);
                // System.out.println("Please inform the desired user: ");
                // String user = sc.nextLine();
                // System.out.println("Please inform the desired experience: ");
                // String exp = sc.nextLine();
                // obj = (AddI) Naming.lookup("OPT3");
                // obj.opt3(user, exp);
                // System.out.println("\n\nDatabase succesfully updated" + "\n\n");
            }
            else if (choice == 4) {
                //user chose to show user's experience given their email
                //let's ask the email
                System.out.println("Please inform the desired email: ");
                Scanner sc = new Scanner(System.in);
                String email = sc.nextLine();
                obj = (AddI) Naming.lookup("OPT4");
                ArrayList<String> result = obj.opt4(email);
                System.out.println("\n\nThe experience of the user is:\n" + result + "\n\n");
            }
            else if (choice == 5) {
                //user chose to show all info
                obj = (AddI) Naming.lookup("OPT5");
                String result = obj.opt5();
                System.out.println("\n\nHere is all the info of the database:\n\n" + result + "\n\n");
            }
            else if (choice == 6) {
                //user chose to show user's whole info given their email
                //let's ask the email
                System.out.println("Please inform the desired email: ");
                Scanner sc = new Scanner(System.in);
                String email = sc.nextLine();
                obj = (AddI) Naming.lookup("OPT6");
                ArrayList<String> result = obj.opt6(email);
                System.out.println("\n\nThe user's whole info is:\n" + result + "\n\n");
            }
        }
	}

}
