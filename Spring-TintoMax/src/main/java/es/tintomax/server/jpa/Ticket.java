package es.tintomax.server.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ticket database table.
 *
 */
@Entity
@Table(name="ticket")
@NamedQuery(name="Ticket.findAll", query="SELECT t FROM Ticket t")
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TicketPK id;

	@Lob
	@Column(name="observations")
	private String observations;

	@Column(name="quantity")
	private int quantity;

	private String service;

	@Column(name="without_iva_im_unit")
	private double withoutIvaImUnit;

	@Column(name="without_iva_total")
	private double withoutIvaTotal;

	//bi-directional many-to-one association to Garment
	@ManyToOne
	@JoinColumn(name="id_garment", insertable = false, updatable = false)
	private Garment garment;

	//bi-directional many-to-one association to Receipt
	@ManyToOne
	@JoinColumn(name="num_ticket", insertable = false, updatable = false)
	private Receipt receipt;

	public Ticket() {
	}

	public TicketPK getId() {
		return this.id;
	}

	public void setId(TicketPK id) {
		this.id = id;
	}

	public String getObservations() {
		return this.observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getService() {
		return this.service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public double getWithoutIvaImUnit() {
		return this.withoutIvaImUnit;
	}

	public void setWithoutIvaImUnit(double withoutIvaImUnit) {
		this.withoutIvaImUnit = withoutIvaImUnit;
	}

	public double getWithoutIvaTotal() {
		return this.withoutIvaTotal;
	}

	public void setWithoutIvaTotal(double withoutIvaTotal) {
		this.withoutIvaTotal = withoutIvaTotal;
	}

	public Garment getGarment() {
		return this.garment;
	}

	public void setGarment(Garment garment) {
		this.garment = garment;
	}

	public Receipt getReceipt() {
		return this.receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	@Override
	public String toString() {
		return "Ticket{" +
				"id=" + id +
				", observations='" + observations + '\'' +
				", quantity=" + quantity +
				", service='" + service + '\'' +
				", withoutIvaImUnit=" + withoutIvaImUnit +
				", withoutIvaTotal=" + withoutIvaTotal +
				'}';
	}
}