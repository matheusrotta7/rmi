import java.rmi.Remote;
import java.util.*;

public interface AddI extends Remote {

    public ArrayList<String> opt1 (String course) throws Exception;
    public ArrayList<String> opt2 (String cidade) throws Exception;
    public boolean opt3 (String email, String exp) throws Exception;
    public ArrayList<String> opt4 (String user) throws Exception;
    public String opt5 () throws Exception;
    public String opt6 (String user) throws Exception;

}
