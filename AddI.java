import java.rmi.Remote;
import java.util.*;

public interface AddI extends Remote {

    public int add (int x, int y) throws Exception;
	public int subtract (int x, int y) throws Exception;
    public ArrayList<String> opt1 (String course) throws Exception;
    public ArrayList<String> opt2 (String cidade) throws Exception;
    // public void opt3 (String user, String exp) throws Exception;
    public ArrayList<String> opt4 (String user) throws Exception;
    public String opt5 () throws Exception;
    // public void opt6 (String user, String exp) throws Exception;

}
