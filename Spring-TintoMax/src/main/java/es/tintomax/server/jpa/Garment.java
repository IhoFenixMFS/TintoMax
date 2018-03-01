package es.tintomax.server.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the garment database table.
 *
 */
@Entity
@Table(name="garment")
@NamedQuery(name="Garment.findAll", query="SELECT g FROM Garment g")
public class Garment{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="garment_number")
	private int garmentNumber;

	@Column(name="name")
	private String name;

	@Column(name="without_iva_cleaning")
	private double withoutIvaCleaning;

	@Column(name="without_iva_ironing")
	private double withoutIvaIroning;

	

	public Garment() {
	}
	public Garment(int garmentNumber,String name, double withoutIvaCleaning, double withoutIvaIroning) {
		this.garmentNumber=garmentNumber;
		this.name=name;
		this.withoutIvaCleaning=withoutIvaCleaning;
		this.withoutIvaIroning=withoutIvaIroning;
	}

	public int getGarmentNumber() {
		return this.garmentNumber;
	}

	public void setGarmentNumber(int garmentNumber) {
		this.garmentNumber = garmentNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWithoutIvaCleaning() {
		return this.withoutIvaCleaning;
	}

	public void setWithoutIvaCleaning(double withoutIvaCleaning) {
		this.withoutIvaCleaning = withoutIvaCleaning;
	}

	public double getWithoutIvaIroning() {
		return this.withoutIvaIroning;
	}

	public void setWithoutIvaIroning(double withoutIvaIroning) {
		this.withoutIvaIroning = withoutIvaIroning;
	}

	

	

	@Override
	public String toString() {
		return "Garment{" +
				"garmentNumber=" + garmentNumber +
				", name='" + name + '\'' +
				", withoutIvaCleaning=" + withoutIvaCleaning +
				", withoutIvaIroning=" + withoutIvaIroning +
				'}';
	}
}