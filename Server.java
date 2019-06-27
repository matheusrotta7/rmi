import java.rmi.Naming;

public class Server {

	public static void main (String[] args) throws Exception {
        AddC obj = new AddC();
        Naming.rebind("ADD", obj);
		Naming.rebind("SUBTRACT", obj);
        Naming.rebind("OPT1", obj);
        Naming.rebind("OPT2", obj);
        // Naming.rebind("OPT3", obj);
        // Naming.rebind("OPT4", obj);
        Naming.rebind("OPT5", obj);
        // Naming.rebind("OPT6", obj);
		System.out.println("server started");
	}

}
