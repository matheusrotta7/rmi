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

}
