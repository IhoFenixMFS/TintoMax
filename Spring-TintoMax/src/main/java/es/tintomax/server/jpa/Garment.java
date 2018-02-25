package es.tintomax.server.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the garment database table.
 *
 */
@Entity
@Table(name="garment")
@NamedQuery(name="Garment.findAll", query="SELECT g FROM Garment g")
public class Garment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="garment_number")
	private int garmentNumber;

	@Column(name="name")
	private String name;

	@Column(name="without_iva_cleaning")
	private double withoutIvaCleaning;

	@Column(name="without_iva_ironing")
	private double withoutIvaIroning;

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="garment")
	private List<Ticket> tickets;

	public Garment() {
	}

	public int getGarmentNumber() {
		return this.garmentNumber;
	}

	public void setGarmentNumber(int garmentNumber) {
		this.garmentNumber = garmentNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWithoutIvaCleaning() {
		return this.withoutIvaCleaning;
	}

	public void setWithoutIvaCleaning(double withoutIvaCleaning) {
		this.withoutIvaCleaning = withoutIvaCleaning;
	}

	public double getWithoutIvaIroning() {
		return this.withoutIvaIroning;
	}

	public void setWithoutIvaIroning(double withoutIvaIroning) {
		this.withoutIvaIroning = withoutIvaIroning;
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket addTicket(Ticket ticket) {
		getTickets().add(ticket);
		ticket.setGarment(this);

		return ticket;
	}

	public Ticket removeTicket(Ticket ticket) {
		getTickets().remove(ticket);
		ticket.setGarment(null);

		return ticket;
	}

	@Override
	public String toString() {
		return "Garment{" +
				"garmentNumber=" + garmentNumber +
				", name='" + name + '\'' +
				", withoutIvaCleaning=" + withoutIvaCleaning +
				", withoutIvaIroning=" + withoutIvaIroning +
				'}';
	}
}