package es.tintomax.server.repositories;

import es.tintomax.server.jpa.Ticket;
import es.tintomax.server.jpa.User;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
	@Query("select t from Ticket t where t.user = ?1 and t.status =?2")
	Page<Ticket> findByUserAndStatus(User user, String status, Pageable page);
	
	@Query("select t from Ticket t where t.user = ?1 and (t.status ='Pendiente' or t.status='Listo')")
	Page<Ticket> findActiveByUser(User user, Pageable page);
	Page<Ticket> findByUser(User user, Pageable page);
	Ticket findById(long id);
}
