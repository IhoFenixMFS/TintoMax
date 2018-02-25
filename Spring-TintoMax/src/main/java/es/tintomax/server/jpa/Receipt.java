package es.tintomax.server.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the recibos database table.
 * 
 */
@Entity
@Table(name="recibos")
//@NamedQuery(name="Recibo.findAll", query="SELECT r FROM Recibo r")
public class Receipt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_recibo")
	private int idRecibo;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_entrada")
	private Date fechaEntrada;

	@Temporal(TemporalType.DATE)
	@Column(name="salida_apx")
	private Date salidaApx;

	@Temporal(TemporalType.DATE)
	@Column(name="salida_real")
	private Date salidaReal;

	@Column(name="tot_prendas")
	private int totPrendas;

	@Column(name="tot_siva")
	private double totSiva;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="recibo1")
	private List<Bill> facturas1;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="recibo2")
	private List<Bill> facturas2;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_user")
	private User usuario;

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="recibo")
	private List<Ticket> tickets;

	public Receipt() {
	}

	public int getIdRecibo() {
		return this.idRecibo;
	}

	public void setIdRecibo(int idRecibo) {
		this.idRecibo = idRecibo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaEntrada() {
		return this.fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getSalidaApx() {
		return this.salidaApx;
	}

	public void setSalidaApx(Date salidaApx) {
		this.salidaApx = salidaApx;
	}

	public Date getSalidaReal() {
		return this.salidaReal;
	}

	public void setSalidaReal(Date salidaReal) {
		this.salidaReal = salidaReal;
	}

	public int getTotPrendas() {
		return this.totPrendas;
	}

	public void setTotPrendas(int totPrendas) {
		this.totPrendas = totPrendas;
	}

	public double getTotSiva() {
		return this.totSiva;
	}

	public void setTotSiva(double totSiva) {
		this.totSiva = totSiva;
	}

	public List<Bill> getFacturas1() {
		return this.facturas1;
	}

	public void setFacturas1(List<Bill> facturas1) {
		this.facturas1 = facturas1;
	}

	public Bill addFacturas1(Bill facturas1) {
		getFacturas1().add(facturas1);
		facturas1.setRecibo1(this);

		return facturas1;
	}

	public Bill removeFacturas1(Bill facturas1) {
		getFacturas1().remove(facturas1);
		facturas1.setRecibo1(null);

		return facturas1;
	}

	public List<Bill> getFacturas2() {
		return this.facturas2;
	}

	public void setFacturas2(List<Bill> facturas2) {
		this.facturas2 = facturas2;
	}

	public Bill addFacturas2(Bill facturas2) {
		getFacturas2().add(facturas2);
		facturas2.setRecibo2(this);

		return facturas2;
	}

	public Bill removeFacturas2(Bill facturas2) {
		getFacturas2().remove(facturas2);
		facturas2.setRecibo2(null);

		return facturas2;
	}

	public User getUsuario() {
		return this.usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket addTicket(Ticket ticket) {
		getTickets().add(ticket);
		ticket.setRecibo(this);

		return ticket;
	}

	public Ticket removeTicket(Ticket ticket) {
		getTickets().remove(ticket);
		ticket.setRecibo(null);

		return ticket;
	}

}