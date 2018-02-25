package es.tintomax.server.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the bill database table.
 * 
 */
@Entity
@Table(name="bill")
@NamedQuery(name="Bill.findAll", query="SELECT b FROM Bill b")
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="num_bill")
	private int numBill;

	@Temporal(TemporalType.DATE)
	@Column(name="bill_date")
	private Date billDate;

	@Column(name="name")
	private String name;

	@Column(name="num_ticket")
	private int numTicket;

	@Column(name="without_iva_amount")
	private double withoutIvaAmount;

	//bi-directional many-to-one association to Receipt
	@ManyToOne
	@JoinColumn(name="id_receipt")
	private Receipt receipt;

	public Bill() {
	}

	public int getNumBill() {
		return this.numBill;
	}

	public void setNumBill(int numBill) {
		this.numBill = numBill;
	}

	public Date getBillDate() {
		return this.billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumTicket() {
		return this.numTicket;
	}

	public void setNumTicket(int numTicket) {
		this.numTicket = numTicket;
	}

	public double getWithoutIvaAmount() {
		return this.withoutIvaAmount;
	}

	public void setWithoutIvaAmount(double withoutIvaAmount) {
		this.withoutIvaAmount = withoutIvaAmount;
	}

	public Receipt getReceipt() {
		return this.receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	@Override
	public String toString() {
		return "Bill{" +
				"numBill=" + numBill +
				", billDate=" + billDate +
				", name='" + name + '\'' +
				", numTicket=" + numTicket +
				", withoutIvaAmount=" + withoutIvaAmount +
				'}';
	}

}