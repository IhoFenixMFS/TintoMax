package es.tintomax.server.repositories;

import es.tintomax.server.jpa.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

}
