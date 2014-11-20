import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class StartPainel {
	
	public static void main (String[] args) {		
		new StartPainel().go();
	}
	
	public void go(){
		try {
			Registry Meuregistro = LocateRegistry.getRegistry("127.0.0.1", 1234);
			
			// procurando o serviço MeuRegistro
			RemoteInterface impl = (RemoteInterface) Meuregistro.lookup("GeneratePassword");
			
			while (true){
				Ticket showPainel = impl.ShowTicketServerd();
				if (showPainel != null){
					System.out.println(showPainel.getClient());
				}
			}
			
		}
		catch(Exception ex){ 
			ex.printStackTrace();
		}
	}

}
