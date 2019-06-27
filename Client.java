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
            System.out.println("Choose one of the following options: \n1: list all people that have graduated in a certain course\n2: list all skills in a city\n3: end activities\n4:list all skills from people that live in a certain city\n5: add new experience to a certain user\n6:show user's experience by providing their email\n7: list all info from all profiles\n8: show user\'s complete info by providing their email");
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
                Scanner sc = new Scanner(System.in);  //
                String city = sc.nextLine();
                obj = (AddI) Naming.lookup("OPT2");
                ArrayList<String> result = obj.opt2(city);
                System.out.println("\n\nThe skills in said city are:\n" + result + "\n\n");
            }
        }
	}

}
