package es.tintomax.server.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 *
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user")
	private int idUser;

	@Column(name="address")
	private String address;

	@Column(name="dni")
	private String dni;

	@Column(name="email")
	private String email;

	@Column(name="last_names")
	private String lastNames;

	@Column(name="name")
	private String name;

	@Column(name="password")
	private String password;

	@Column(name="phone_number")
	private int phoneNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="sign_up_date")
	private Date signUpDate;

	@Column(name="t_user")
	private String tUser;

	//bi-directional many-to-one association to Receipt
	@OneToMany(mappedBy="user")
	private List<Receipt> receipts;

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getLastNames() {
		return this.lastNames;
	}

	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getSignUpDate() {
		return this.signUpDate;
	}

	public void setSignUpDate(Date signUpDate) {
		this.signUpDate = signUpDate;
	}

	public String getTUser() {
		return this.tUser;
	}

	public void setTUser(String tUser) {
		this.tUser = tUser;
	}

	public List<Receipt> getReceipts() {
		return this.receipts;
	}

	public void setReceipts(List<Receipt> receipts) {
		this.receipts = receipts;
	}

	public Receipt addReceipt(Receipt receipt) {
		getReceipts().add(receipt);
		receipt.setUser(this);

		return receipt;
	}

	public Receipt removeReceipt(Receipt receipt) {
		getReceipts().remove(receipt);
		receipt.setUser(null);

		return receipt;
	}

	@Override
	public String toString() {
		return "User{" +
				"idUser=" + idUser +
				", address='" + address + '\'' +
				", dni='" + dni + '\'' +
				", email='" + email + '\'' +
				", lastNames='" + lastNames + '\'' +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", phoneNumber=" + phoneNumber +
				", signUpDate=" + signUpDate +
				", tUser='" + tUser + '\'' +
				'}';
	}
}