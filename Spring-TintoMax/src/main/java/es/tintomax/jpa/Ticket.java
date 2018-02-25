package es.tintomax.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ticket database table.
 * 
 */
@Entity
@NamedQuery(name="Ticket.findAll", query="SELECT t FROM Ticket t")
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TicketPK id;

	private int cantidad;

	@Column(name="im_unit_siva")
	private double imUnitSiva;

	@Lob
	private String observaciones;

	private String servicio;

	@Column(name="total_siva")
	private double totalSiva;

	//bi-directional many-to-one association to Prenda
	@ManyToOne
	@JoinColumn(name="id_prenda")
	private Prenda prenda;

	//bi-directional many-to-one association to Recibo
	@ManyToOne
	@JoinColumn(name="num_ticket")
	private Recibo recibo;

	public Ticket() {
	}

	public TicketPK getId() {
		return this.id;
	}

	public void setId(TicketPK id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getImUnitSiva() {
		return this.imUnitSiva;
	}

	public void setImUnitSiva(double imUnitSiva) {
		this.imUnitSiva = imUnitSiva;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getServicio() {
		return this.servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public double getTotalSiva() {
		return this.totalSiva;
	}

	public void setTotalSiva(double totalSiva) {
		this.totalSiva = totalSiva;
	}

	public Prenda getPrenda() {
		return this.prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}

	public Recibo getRecibo() {
		return this.recibo;
	}

	public void setRecibo(Recibo recibo) {
		this.recibo = recibo;
	}

}