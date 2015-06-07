import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
    String order(int a, int b) throws RemoteException;
    int[][] map() throws RemoteException;
}