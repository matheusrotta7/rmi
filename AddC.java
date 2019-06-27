import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.nio.file.*;
import java.util.*;

public class AddC extends UnicastRemoteObject implements AddI {

	protected AddC() throws RemoteException {
		super();
	}


	public int add (int x, int y) throws Exception {
		return x+y;
	}

    public int subtract (int x, int y) throws Exception {
		return x-y;
	}

    public ArrayList<String> opt1 (String course) throws Exception {

        String contents = new String(Files.readAllBytes(Paths.get("data.txt")));
        // return contents;
        ArrayList<String> namelist = new ArrayList<String>();
        Scanner sc = new Scanner (contents);
        String name = "";
        while (sc.hasNext()) {
            String[] a = sc.nextLine().split("[:]");
            if (a[0].equals("Nome Completo")) {
                name = a[1];
            }
            else if (a[0].equals("Formação Acadêmica")) {
                // System.out.println(a[1]);
                if (a[1].equals(course)) {
                    namelist.add(name);
                }
            }

        }

        return namelist;
    }

    public ArrayList<String> opt2 (String city) throws Exception {

        String contents = new String(Files.readAllBytes(Paths.get("data.txt")));
        // return contents;
        ArrayList<String> skill_list = new ArrayList<String>();
        Scanner sc = new Scanner (contents);
        boolean correct_city = false;
        while (sc.hasNext()) {
            String[] a = sc.nextLine().split("[:]");
            if (a[0].equals("Residência")) {
                if (a[1].equals(city)) {
                    correct_city = true;
                }
                else {
                    correct_city = false;
                }
            }
            else if (a[0].equals("Habilidades")) {
                // System.out.println(a[1]);
                if (correct_city) {
                    skill_list.add(a[1]);
                }
            }

        }

        return skill_list;
    }

    // public void opt3 (String user, String exp) throws Exception {
    //     String contents = new String(Files.readAllBytes(Paths.get("data.txt")));
    //
    //     //------create auxiliary file (begin)-------//
    //     File file = new File("aux.txt");
    //
    //     // creates the file
    //     file.createNewFile();
    //
    //     // creates a FileWriter Object
    //     FileWriter writer = new FileWriter(file);
    //
    //     // Writes the content to the file
    //     writer.write("This\n is\n an\n example\n");
    //     writer.flush();
    //     writer.close();
    //     //------create auxiliary file (end)-------//
    //     // return contents;
    //     Scanner sc = new Scanner (contents);
    //     boolean correct_person = false;
    //     while (sc.hasNext()) {
    //         String curline = sc.nextLine();
    //         writer.write(curline);
    //         String[] a = curline.split("[:]");
    //         if (a[0].equals("Nome Completo")) {
    //             if (a[1].equals(user)) {
    //                 correct_person = true;
    //             }
    //             else {
    //                 correct_person = false;
    //             }
    //         }
    //         else if (a[0].equals("Experiência")) {
    //             // System.out.println(a[1]);
    //             if (correct_person) {
    //
    //             }
    //         }
    //
    //     }
    // }

    public ArrayList<String> opt4 (String user) throws Exception {
        String contents = new String(Files.readAllBytes(Paths.get("data.txt")));
        // return contents;
        ArrayList<String> exp_list = new ArrayList<String>();
        Scanner sc = new Scanner (contents);
        boolean correct_email = false;
        outter:
        while (sc.hasNext()) {
            String[] a = sc.nextLine().split("[:]");
            if (a[0].equals("Email")) {
                if (a[1].equals(user)) {
                    correct_email = true;
                }
                else {
                    correct_email = false;
                }
            }
            else if (a[0].equals("Experiência")) {
                // System.out.println(a[1]);
                if (correct_email) {
                    exp_list.add(a[1]); //add first experience, which comes after the ':'
                    while (sc.hasNext()) {
                        String cur = sc.nextLine();
                        if (cur.equals("-----")) {
                            break outter;
                        }
                        else {
                            exp_list.add(cur);
                        }
                    }
                }
            }

        }

        return exp_list;
    }

    public String opt5 () throws Exception {

        String contents = new String(Files.readAllBytes(Paths.get("data.txt")));

        return contents;
    }

    public String opt6 (String user) throws Exception {
        String contents = new String(Files.readAllBytes(Paths.get("data.txt")));
        // return contents;
        String result = "";
        Scanner sc = new Scanner (contents);
        // boolean correct_email = false;
        outter:
        while (sc.hasNext()) {
            String b = sc.nextLine();
            String[] a = b.split("[:]");
            if (a[0].equals("Email")) {
                if (a[1].equals(user)) {
                    result += b;
                    result += "\n";
                    while (sc.hasNext()) {
                        String cur = sc.nextLine();
                        if (cur.equals("-----")) {
                            break outter;
                        }
                        else {
                            result += cur;
                            result += "\n";
                        }
                    }
                }
            }
        }

        return result;
    }



}
