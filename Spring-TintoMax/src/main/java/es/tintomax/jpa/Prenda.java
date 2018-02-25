package es.tintomax.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the prendas database table.
 * 
 */
@Entity
@Table(name="prendas")
@NamedQuery(name="Prenda.findAll", query="SELECT p FROM Prenda p")
public class Prenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="num_prenda")
	private int numPrenda;

	@Column(name="limpieza_siva")
	private double limpiezaSiva;

	private String nombre;

	@Column(name="plancha_siva")
	private double planchaSiva;

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="prenda")
	private List<Ticket> tickets;

	public Prenda() {
	}

	public int getNumPrenda() {
		return this.numPrenda;
	}

	public void setNumPrenda(int numPrenda) {
		this.numPrenda = numPrenda;
	}

	public double getLimpiezaSiva() {
		return this.limpiezaSiva;
	}

	public void setLimpiezaSiva(double limpiezaSiva) {
		this.limpiezaSiva = limpiezaSiva;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPlanchaSiva() {
		return this.planchaSiva;
	}

	public void setPlanchaSiva(double planchaSiva) {
		this.planchaSiva = planchaSiva;
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket addTicket(Ticket ticket) {
		getTickets().add(ticket);
		ticket.setPrenda(this);

		return ticket;
	}

	public Ticket removeTicket(Ticket ticket) {
		getTickets().remove(ticket);
		ticket.setPrenda(null);

		return ticket;
	}

}