import java.io.Serializable;

public class Ticket implements Serializable {
	
	private int number = 0;
	private String client;
	private int priority = 0;
	private String caixa;

	public Ticket(int priority) {
		this.priority = priority;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getCaixa() {
		return caixa;
	}

	public void setCaixa(String caixa) {
		this.caixa = caixa;
	}

	@Override
	public String toString() {
		return "Ticket [number=" + number + ", client=" + client
				+ ", priority=" + priority + ", caixa=" + caixa + "]";
	}
}
