package es.tintomax.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user")
	private int idUser;

	private String apellidos;

	private String direccion;

	private String dni;

	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_alta")
	private Date fechaAlta;

	private String nombre;

	private String password;

	@Column(name="t_user")
	private String tUser;

	private int telf;

	//bi-directional many-to-one association to Recibo
	@OneToMany(mappedBy="usuario")
	private List<Recibo> recibos;

	public Usuario() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTUser() {
		return this.tUser;
	}

	public void setTUser(String tUser) {
		this.tUser = tUser;
	}

	public int getTelf() {
		return this.telf;
	}

	public void setTelf(int telf) {
		this.telf = telf;
	}

	public List<Recibo> getRecibos() {
		return this.recibos;
	}

	public void setRecibos(List<Recibo> recibos) {
		this.recibos = recibos;
	}

	public Recibo addRecibo(Recibo recibo) {
		getRecibos().add(recibo);
		recibo.setUsuario(this);

		return recibo;
	}

	public Recibo removeRecibo(Recibo recibo) {
		getRecibos().remove(recibo);
		recibo.setUsuario(null);

		return recibo;
	}

}