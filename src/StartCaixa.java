import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class StartCaixa {

	private Scanner scanner;
	private Ticket ticket;

	public static void main(String[] args) {
		new StartCaixa().go();
	}

	public void go() {
		try {
			Registry Meuregistro = LocateRegistry.getRegistry("127.0.0.1", 1234);
			
			// procurando o serviço MeuRegistro
			RemoteInterface impl = (RemoteInterface) Meuregistro.lookup("GeneratePassword");
			
			scanner = new Scanner(System.in);
			while (scanner.nextLine() != null){	
				try {
					ticket = impl.SelectTicket();
					if (ticket != null){
						System.out.println("Mensagem: " + ticket.getClient());
					} else {
						System.out.println("Não há tickets =)");
					}
				} catch (Exception e) {
					System.out.println("Não há tickets =)");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
