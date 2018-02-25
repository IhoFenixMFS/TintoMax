package es.tintomax.server.jpa;

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

	@Column(name="id_garment", insertable=false, updatable=false)
	private int idGarment;

	public TicketPK() {
	}
	public int getNumTicket() {
		return this.numTicket;
	}
	public void setNumTicket(int numTicket) {
		this.numTicket = numTicket;
	}
	public int getIdGarment() {
		return this.idGarment;
	}
	public void setIdGarment(int idGarment) {
		this.idGarment = idGarment;
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
			&& (this.idGarment == castOther.idGarment);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numTicket;
		hash = hash * prime + this.idGarment;
		
		return hash;
	}
}