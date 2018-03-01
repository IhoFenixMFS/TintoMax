package es.tintomax.server.jpa;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the bill database table.
 *
 */
@Entity
@Table(name="bill")
@NamedQuery(name="Bill.findAll", query="SELECT b FROM Bill b")
public class Bill{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="num_bill")
	private int numBill;

	@Temporal(TemporalType.DATE)
	@Column(name="bill_date")
	private Date billDate;

	@Column(name="name")
	private String name;

	@Column(name="without_iva_amount")
	private double withoutIvaAmount;

	//bi-directional many-to-one association to Receipt
	@ManyToOne
	@JoinColumn(name="id_ticket")
	private Ticket id_ticket;

	public Bill() {
	}

	public int getNumBill() {
		return this.numBill;
	}

	public Date getBillDate() {
		return this.billDate;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public double getWithoutIvaAmount() {
		return this.withoutIvaAmount;
	}


	
	
	//Constructor
	public Bill(int numBill,String name, Date billDate,double withoutIvaAmount){
		this.numBill=numBill;
		this.name=name;
		this.billDate=billDate;
		this.withoutIvaAmount=withoutIvaAmount;
	}
	
	@Override
	public String toString() {
		return "Bill{" +
				"numBill=" + numBill +
				", billDate=" + billDate +
				", name='" + name + '\'' +
				", numTicket=" + id_ticket +
				", withoutIvaAmount=" + withoutIvaAmount +
				'}';
	}

}