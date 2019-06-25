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

    public String opt1 (String course) throws Exception {
        String contents = new String(Files.readAllBytes(Paths.get("data.txt")));
        // return contents;
        Scanner sc = new Scanner (contents);
        while (sc.hasNext()) {
                String cur = sc.nextLine();
                System.out.println(cur);
            
        }

        return "hello";
    }

}
