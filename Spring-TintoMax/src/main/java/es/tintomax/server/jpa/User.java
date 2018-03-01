package es.tintomax.server.jpa;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;


/**
 * The persistent class for the user database table.
 *
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idUser;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;

	private String address;

	private String dni;

	private String email;

	private String lastNames;

	private String name;

	@Column(name="password")
	private String passwordHash;

	private long phoneNumber;

	@Temporal(TemporalType.DATE)
	private Calendar signUpDate;

	public User() {
	}
	public User(String dni,String name, String lastNames,String address,String email,Calendar signUpDate, long phoneNumber, String password, String... roles) {
		this.dni=dni;
		this.name = name;
		this.lastNames=lastNames;
		this.address=address;
		this.email=email;
		this.signUpDate=signUpDate;
		this.phoneNumber = phoneNumber;
		this.passwordHash = new BCryptPasswordEncoder().encode(password);
		this.roles = new ArrayList<>(Arrays.asList(roles));
	}


	//(t_user, dni, name, last_names, address, phone_number, email, sign_up_date, password))
	//('admin', '00000000A', 'Administrador', 'Admin', 'TintoMax', 0, 'admin@admin.admin', '2018-02-01', 'admin');
	public Long getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Long idUser) {
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

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String password) {
		this.passwordHash = new BCryptPasswordEncoder().encode(password);
	}

	public long getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Calendar getSignUpDate() {
		return this.signUpDate;
	}

	public void setSignUpDate(Calendar signUpDate) {
		this.signUpDate = signUpDate;
	}
	
	public List<String> getRoles() {
		return roles;
	}
	@ManyToMany
	@JoinTable(name="user_role", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
	public void setRoles(List<String> roles) {
		this.roles = roles;
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
				", password='" + passwordHash + '\'' +
				", phoneNumber=" + phoneNumber +
				", signUpDate=" + signUpDate +
				'}';
	}
}