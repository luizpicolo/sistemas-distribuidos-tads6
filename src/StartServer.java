import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartServer {

	public static void main(String[] args) {
		try {
			new StartServer().go();;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void go() throws AccessException, RemoteException {
		Registry registro;
		Registry registro2;
		
		registro = LocateRegistry.createRegistry(1234);
		registro2 = LocateRegistry.createRegistry(1235);
		
		registro.rebind("GeneratePassword", new RemoteInterfaceImpl());
		registro2.rebind("painel", new RemoteInterfaceImpl());
	}
}
