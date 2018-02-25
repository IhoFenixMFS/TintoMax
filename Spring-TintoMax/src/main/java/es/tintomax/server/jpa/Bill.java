package es.tintomax.server.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the facturas database table.
 * 
 */
@Entity
@Table(name="facturas")
//@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="num_factura")
	private int numFactura;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="importe_siva")
	private double importeSiva;

	private String nombre;

	//bi-directional many-to-one association to Recibo
	@ManyToOne
	@JoinColumn(name="num_ticket")
	private Receipt recibo1;

	//bi-directional many-to-one association to Recibo
	@ManyToOne
	@JoinColumn(name="id_recibo")
	private Receipt recibo2;

	public Bill() {
	}

	public int getNumFactura() {
		return this.numFactura;
	}

	public void setNumFactura(int numFactura) {
		this.numFactura = numFactura;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getImporteSiva() {
		return this.importeSiva;
	}

	public void setImporteSiva(double importeSiva) {
		this.importeSiva = importeSiva;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Receipt getRecibo1() {
		return this.recibo1;
	}

	public void setRecibo1(Receipt recibo1) {
		this.recibo1 = recibo1;
	}

	public Receipt getRecibo2() {
		return this.recibo2;
	}

	public void setRecibo2(Receipt recibo2) {
		this.recibo2 = recibo2;
	}

}