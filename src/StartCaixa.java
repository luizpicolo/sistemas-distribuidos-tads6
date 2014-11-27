import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class StartCaixa {

	private Scanner scanner;
	private Ticket ticket;
	public static int num = 0;
	
	public static void main(String[] args) {
		new StartCaixa().go();
	}

	public void go() {
		try {
			Registry Meuregistro = LocateRegistry.getRegistry("127.0.0.1", 1234);
			
			// procurando o serviço MeuRegistro
			RemoteInterface impl = (RemoteInterface) Meuregistro.lookup("GeneratePassword");
			
			scanner = new Scanner(System.in);
			System.out.println("Clique Enter para continuar");
			while (scanner.nextLine() != null){	
				try {
					ticket = impl.SelectTicket("Caixa-" + this.num++);
					if (ticket != null){
						System.out.println("Cliente - " + ticket.getClient());
					} else {
						System.out.println("Estou verificando se há novos tickets");
						while (!impl.CheckTicket()){ }
						System.out.println("Há tickets a serem atendidos");
					}
				} catch (Exception e) { }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
