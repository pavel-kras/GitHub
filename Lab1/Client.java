import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    private Client() {
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int x = 0;
            Registry registry = LocateRegistry.getRegistry(1099);
            Hello stub = (Hello) registry.lookup("Hello");
            while (true) {
                System.out.println("\nWhat do you want???\n1. MAP\n2. ORDER");
                x = scanner.nextInt();
                switch (x) {
                    case 1:
                        int[][] response1 = stub.map();
                        for (int i = 0; i < 10; i++) {
                            for (int j = 0; j < 10; j++) {
                                System.out.print(response1[i][j] + " ");
                            }
                            System.out.print("\n");
                        }
                        break;
                    case 2:
                        int a = 0;
                        int b = 0;

                        boolean bError = true;
                        System.out.println("enter parametr X: ");
                        a = scanner.nextInt();
                        System.out.println("enter parametr Y: ");
                        b = scanner.nextInt();
                        String response2 = stub.order(a, b);
                        System.out.println(response2);
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
