package es.tintomax.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ticket database table.
 * 
 */
@Embeddable
public class TicketPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="num_ticket", insertable=false, updatable=false)
	private int numTicket;

	@Column(name="id_prenda", insertable=false, updatable=false)
	private int idPrenda;

	public TicketPK() {
	}
	public int getNumTicket() {
		return this.numTicket;
	}
	public void setNumTicket(int numTicket) {
		this.numTicket = numTicket;
	}
	public int getIdPrenda() {
		return this.idPrenda;
	}
	public void setIdPrenda(int idPrenda) {
		this.idPrenda = idPrenda;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TicketPK)) {
			return false;
		}
		TicketPK castOther = (TicketPK)other;
		return 
			(this.numTicket == castOther.numTicket)
			&& (this.idPrenda == castOther.idPrenda);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numTicket;
		hash = hash * prime + this.idPrenda;
		
		return hash;
	}
}