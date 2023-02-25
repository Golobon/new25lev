package Lev_29_lec_10_2;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/*
RMI-2
*/

public class Solution {
    public static Registry registry;

    public static final String UNIC_CAT_METHOD = "cat.method";
    public static final String UNIC_DOG_METHOD = "dog.speak";


    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.speak();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    // Pretend we're starting an RMI server as the SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        Remote r1;
        Remote r2;
        @Override
        public void run() {
            //напишите тут ваш код
            try { registry = LocateRegistry.createRegistry(2099);

                Animal cat = new Cat("Bob");
                r1 = UnicastRemoteObject.exportObject(cat, 0);
                registry.bind(UNIC_CAT_METHOD, r1);

                Animal dog = new Dog("Gary");
                r2 = UnicastRemoteObject.exportObject(dog, 0);
                registry.bind(UNIC_DOG_METHOD, r2);

            } catch (RemoteException e) { e.printStackTrace(); }
              catch (AlreadyBoundException e) { e.printStackTrace();
            }
        }
    });

    public static void main(String[] args) throws InterruptedException {
        // Starting an RMI server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        // Start the client
        CLIENT_THREAD.start();
    }
}

