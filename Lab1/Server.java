
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Asus
 */
public class Server implements Hello {

    static int[][] mas = new int[10][10];

    public Server() {
    }

    public static void main(String args[]) {
        try {
            Server obj = new Server();
            Hello stub = (Hello) UnicastRemoteObject.exportObject((Remote) obj, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Hello", (Remote) stub);
            System.err.println("Server ready");
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    mas[i][j] = (Math.random() < 0.5) ? 0 : 1;
                }
                System.out.print("\n");
            }
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public String order(int a, int b) throws RemoteException {
        String res;

        if (mas[b][a] == 0) {
            mas[b][a] = 1;
            return "SUCCESS!!!";
        } else {
            return "NOT AVAILABLE(((";
        }
    }

    @Override
    public int[][] map() throws RemoteException {
        return mas;
    }
}
