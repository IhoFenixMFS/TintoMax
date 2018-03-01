package es.tintomax.server.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Calendar;
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
	private int idReceipt;

	@Temporal(TemporalType.DATE)
	private Calendar apxOutput;

	@Temporal(TemporalType.DATE)
	private Calendar entryDate;

	@Temporal(TemporalType.DATE)
	private Calendar realOutput;

	private String state;

	private int totalGarments;

	private double withoutIvaTotal;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;


	@OneToMany(mappedBy = "receipt")
	List<Detail> details;

	public Receipt() {
	}

	public int getIdReceipt() {
		return this.idReceipt;
	}

	public void setIdReceipt(int idReceipt) {
		this.idReceipt = idReceipt;
	}

	public Calendar getApxOutput() {
		return this.apxOutput;
	}

	public void setApxOutput(Calendar apxOutput) {
		this.apxOutput = apxOutput;
	}

	public Calendar getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(Calendar entryDate) {
		this.entryDate = entryDate;
	}

	public Calendar getRealOutput() {
		return this.realOutput;
	}

	public void setRealOutput(Calendar realOutput) {
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


	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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