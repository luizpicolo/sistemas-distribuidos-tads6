import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote {
	public Ticket SelectTicket() throws RemoteException;
	public Ticket GenerateTicket(int priority) throws RemoteException;
	public Ticket ShowTicketServerd() throws RemoteException;
	public Boolean CheckTicket() throws RemoteException;
}
