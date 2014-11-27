import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteInterfaceImpl extends UnicastRemoteObject implements RemoteInterface {

	private static final long serialVersionUID = 1L;
	private ArrayList<Ticket> listTicketsNotServed = new ArrayList<>();
	private ArrayList<Ticket> listTicketsServed = new ArrayList<>();
	private static int password;

	public Ticket SelectTicket(String caixa) {
		if (this.listTicketsNotServed.size() > 0){
			for (Ticket ticket : this.listTicketsNotServed) {
				if (ticket.getPriority() == 1){
					Ticket t = ticket;
					this.listTicketsNotServed.remove(ticket);
					t.setCaixa(caixa);
					this.listTicketsServed.add(t);
					return t;
				}
			}
			
			Ticket ticket = this.listTicketsNotServed.get(0);
			ticket.setCaixa(caixa);
			this.listTicketsServed.add(ticket);
			this.listTicketsNotServed.remove(0);
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
		ticket.setClient("Cliente - " + password);
		this.listTicketsNotServed.add(ticket);
		return ticket;
	}
	
	public Ticket ShowTicketServerd(){
		int position = this.listTicketsServed.size();
		if (position > 0) {
			Ticket ticket = this.listTicketsServed.get(0);
			this.listTicketsServed.remove(ticket);
			return ticket;
		} else {
			return null;
		}
	}
	
	public Boolean CheckTicket(){
		if (this.listTicketsNotServed.size() > 0){
			return true;
		} else {
			return false;
		}
	}

}
