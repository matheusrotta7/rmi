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
            System.out.println("Choose one of the following options: \n1: list all people that have graduated in a certain course\n2: add new profile\n3: end activities\n4:list all skills from people that live in a certain city\n5: add new experience to a certain user\n6:show user's experience by providing their email\n7: list all info from all profiles\n8: show user\'s complete info by providing their email");
            int choice = myObj.nextInt();  // Read user input
            if (choice == 1) {
                // FileReader fr=null;
                // try
                // {
                //     fr = new FileReader("data.txt");
                // }
                // catch (FileNotFoundException fe)
                // {
                //     System.out.println("File not found");
                // }
                //
                // String cur;
                //
                //
                // // read from FileReader till the end of file
                // while ((cur=fr.read()) != null)
                //     System.out.print(cur);
                //
                // // close the file
                // fr.close();
                obj = (AddI) Naming.lookup("OPT1");
                String result = obj.opt1("teste");
                System.out.println(result);
            }
        }
	}

}
