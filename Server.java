import java.rmi.Naming;

public class Server {

	public static void main (String[] args) throws Exception {
        AddC obj = new AddC();
        Naming.rebind("ADD", obj);
		Naming.rebind("SUBTRACT", obj);
        Naming.rebind("OPT1", obj);
		System.out.println("server started");
	}

}
