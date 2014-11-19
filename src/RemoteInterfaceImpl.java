import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteInterfaceImpl extends UnicastRemoteObject implements RemoteInterface {

	private static final long serialVersionUID = 1L;
	private ArrayList<Ticket> listTickets = new ArrayList<>();
	private static int password;

	public Ticket SelectTicket() {
		if (this.listTickets.size() > 0){
			for (Ticket ticket : this.listTickets) {
				if (ticket.getPriority() == 1){
					Ticket t = ticket;
					this.listTickets.remove(ticket);
					return t;
				}
			}
			
			Ticket ticket = this.listTickets.get(0);
			this.listTickets.remove(0);
			return ticket;
		}
		
		return null;
	}

	public RemoteInterfaceImpl() throws RemoteException {
	}

	@Override
	public Ticket GenerateTicket(int priority) throws RemoteException {
		Ticket ticket = new Ticket(priority);
		int password = this.password++;
		ticket.setNumber(password);
		ticket.setClient("Client_" + password);
		this.listTickets.add(ticket);
		return ticket;
	}

}
