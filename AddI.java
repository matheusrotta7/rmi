import java.rmi.Remote;

public interface AddI extends Remote {

    public int add (int x, int y) throws Exception;
	public int subtract (int x, int y) throws Exception;
    public String opt1 (String course) throws Exception;

}
