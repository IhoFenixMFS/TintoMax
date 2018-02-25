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
@Table(name="receipt")
@NamedQuery(name="Receipt.findAll", query="SELECT r FROM Receipt r")
public class Receipt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_receipt")
	private int idReceipt;

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

	//bi-directional many-to-one association to Bill
	@OneToMany(mappedBy="receipt")
	private List<Bill> bills;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="receipt")
	private List<Ticket> tickets;

	public Receipt() {
	}

	public int getIdReceipt() {
		return this.idReceipt;
	}

	public void setIdReceipt(int idReceipt) {
		this.idReceipt = idReceipt;
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

	public Bill addBill(Bill bill) {
		getBills().add(bill);
		bill.setReceipt(this);

		return bill;
	}

	public Bill removeBill(Bill bill) {
		getBills().remove(bill);
		bill.setReceipt(null);

		return bill;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket addTicket(Ticket ticket) {
		getTickets().add(ticket);
		ticket.setReceipt(this);

		return ticket;
	}

	public Ticket removeTicket(Ticket ticket) {
		getTickets().remove(ticket);
		ticket.setReceipt(null);

		return ticket;
	}

	@Override
	public String toString() {
		return "Receipt{" +
				"idReceipt=" + idReceipt +
				", apxOutput=" + apxOutput +
				", entryDate=" + entryDate +
				", realOutput=" + realOutput +
				", state='" + state + '\'' +
				", totalGarments=" + totalGarments +
				", withoutIvaTotal=" + withoutIvaTotal +
				'}';
	}
}