package es.tintomax.server.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the receipt database table.
 *
 */
@Entity
@Table(name="ticket")
@NamedQuery(name="Ticket.findAll", query="SELECT t FROM Ticket t")
public class Ticket{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_ticket")
	private int id_ticket;

	@Temporal(TemporalType.DATE)
	@Column(name="apx_output")
	private Date apxOutput;

	@Temporal(TemporalType.DATE)
	@Column(name="entry_date")
	private Date entryDate;

	@Temporal(TemporalType.DATE)
	@Column(name="real_output")
	private Date realOutput;

	@Column(name="state")
	private String state;

	@Column(name="total_garments")
	private int totalGarments;

	@Column(name="without_iva_total")
	private double withoutIvaTotal;

	@OneToMany(mappedBy="id_ticket")
	private List<Bill> bills;
	
	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	
	

	public Ticket() {
	}

	public int getIdTicket() {
		return this.id_ticket;
	}

	public void setIdTicket(int idTicket) {
		this.id_ticket = idTicket;
	}

	public Date getApxOutput() {
		return this.apxOutput;
	}

	public void setApxOutput(Date apxOutput) {
		this.apxOutput = apxOutput;
	}

	public Date getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getRealOutput() {
		return this.realOutput;
	}

	public void setRealOutput(Date realOutput) {
		this.realOutput = realOutput;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getTotalGarments() {
		return this.totalGarments;
	}

	public void setTotalGarments(int totalGarments) {
		this.totalGarments = totalGarments;
	}

	public double getWithoutIvaTotal() {
		return this.withoutIvaTotal;
	}

	public void setWithoutIvaTotal(double withoutIvaTotal) {
		this.withoutIvaTotal = withoutIvaTotal;
	}

	public List<Bill> getBills() {
		return this.bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	

	

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	
	@Override
	public String toString() {
		return "Receipt{" +
				"idReceipt=" + id_ticket +
				", apxOutput=" + apxOutput +
				", entryDate=" + entryDate +
				", realOutput=" + realOutput +
				", state='" + state + '\'' +
				", totalGarments=" + totalGarments +
				", withoutIvaTotal=" + withoutIvaTotal +
				'}';
	}
}