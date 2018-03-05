package es.tintomax.server.repositories;

import es.tintomax.server.jpa.Ticket;
import es.tintomax.server.jpa.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
	List<Ticket> findByUser(User user);
	Ticket findById(long id);
}
