import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.nio.file.*;
import java.io.File;
import java.io.FileWriter;
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

    public boolean opt3 (String email, String exp) throws Exception {
        boolean success = false;
        boolean experienceState = false;
        int experienceCounter = 1;
        String contents = new String(Files.readAllBytes(Paths.get("data.txt")));
    
        //------create auxiliary file (begin)-------//
        File file = new File("data.txt");
    
        // creates the file
        file.createNewFile();
    
        // creates a FileWriter Object
        FileWriter writer = new FileWriter(file);
    
        // return contents;
        Scanner sc = new Scanner (contents);
        boolean correct_person = false;
        
        while (sc.hasNext()) {
            if (experienceState) {
                experienceCounter++;
            }
            String curline = sc.nextLine();
            String[] a = curline.split("[:]");
            if (a[0].equals("Email")) {
                if (a[1].equals(email)) {
                    correct_person = true;
                    success = true;
                }
                else {
                    correct_person = false;
                }
            }
            else if (a[0].equals("Experiência")) {
                // System.out.println(a[1]);
                if (correct_person) {
                    experienceState = true;
                }
            } else if (curline.equals("-----") && correct_person) {
                writer.write("(" + experienceCounter + ") " + exp + "\n");
                writer.flush();
            }
            writer.write(curline + "\n");
            writer.flush();
        }
        writer.close();
        return success;
    }

    public String opt5 () throws Exception {

        String contents = new String(Files.readAllBytes(Paths.get("data.txt")));

        return contents;
    }



}
