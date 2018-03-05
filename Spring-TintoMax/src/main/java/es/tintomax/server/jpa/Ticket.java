package es.tintomax.server.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Ticket database table.
 *
 */
@Entity
@Table(name="Ticket")
@NamedQuery(name="Ticket.findAll", query="SELECT r FROM Ticket r")
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Calendar apxOutput;

	@Temporal(TemporalType.DATE)
	private Calendar entryDate;

	@Temporal(TemporalType.DATE)
	private Calendar realOutput;

	private String status;

	private int totalGarments;

	private double withoutIvaTotal;

	//bi-directional many-to-one association to User
	@ManyToOne(cascade=CascadeType.MERGE)
	private User user;


	

	public Ticket(User user,int totalGarments, Calendar entryDate, Calendar apxOutput, Calendar realOutput, double withoutIvaTotal,String status) {
		this.user=user;
		this.totalGarments=totalGarments;
		this.entryDate=entryDate;
		this.apxOutput=apxOutput;
		this.realOutput=realOutput;
		this.withoutIvaTotal=withoutIvaTotal;
		this.status=status;		
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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
		return this.status;
	}

	public void setState(String status) {
		this.status = status;
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
		return "Ticket{" +
				"idTicket=" + id +
				", apxOutput=" + apxOutput +
				", entryDate=" + entryDate +
				", realOutput=" + realOutput +
				", status='" + status + '\'' +
				", totalGarments=" + totalGarments +
				", withoutIvaTotal=" + withoutIvaTotal +
				'}';
	}
}