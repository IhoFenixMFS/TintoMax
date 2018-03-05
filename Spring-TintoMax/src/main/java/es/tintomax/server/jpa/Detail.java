/*package es.tintomax.server.jpa;

import javax.persistence.*;

@Entity
public class Detail {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    //bi-directional many-to-one association to User
    @ManyToOne
    private Ticket ticket;

    @OneToOne
    private Garment garment;

    private int numGarments;

    private String service;

    private int price;

    public Detail() {}

    public Detail(Ticket ticket, Garment garment, int numGarments, String service, int price) {
        this.ticket = ticket;
        this.garment = garment;
        this.numGarments = numGarments;
        this.service = service;
        this.price = price;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Garment getGarment() {
        return garment;
    }

    public void setGarment(Garment garment) {
        this.garment = garment;
    }

    public int getNumGarments() {
        return numGarments;
    }

    public void setNumGarments(int numGarments) {
        this.numGarments = numGarments;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}*/
