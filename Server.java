import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;
import java.nio.file.*;

public class Server {

	public static void main (String[] args) throws Exception {
        System.setProperty("java.security.policy", Paths.get("rmi.policy").toAbsolutePath().toString());
	
        AddC obj = new AddC();
        Registry registry = LocateRegistry.getRegistry(1099);
        registry.rebind("OPT1", obj);
        registry.rebind("OPT2", obj);
        registry.rebind("OPT3", obj);
        registry.rebind("OPT4", obj);
        registry.rebind("OPT5", obj);
        registry.rebind("OPT6", obj);
		System.out.println("server started");
	}

}
