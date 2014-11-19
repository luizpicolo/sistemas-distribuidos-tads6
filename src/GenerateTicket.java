import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class GenerateTicket {

	private Scanner scanner;
	public static void main(String[] args) {
		new GenerateTicket().go();
	}
	

	public void go() {
		try {
			Registry MyRegister = LocateRegistry.getRegistry("127.0.0.1", 1234);
			
			RemoteInterface impl = (RemoteInterface) MyRegister.lookup("GeneratePassword");
			
			scanner = new Scanner(System.in);
			while (scanner.nextLine() != null){
				
				System.out.println("Digite a prioridade deste cliente");
				System.out.println(" 0 = Cliente não prioritário");
				System.out.println(" 1 = Cliente prioritário\n");
				
				// conectando com o servidor
				Ticket ticket = impl.GenerateTicket(Integer.parseInt(scanner.nextLine()));
				System.out.println("Seu Ticket: " + ticket.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
