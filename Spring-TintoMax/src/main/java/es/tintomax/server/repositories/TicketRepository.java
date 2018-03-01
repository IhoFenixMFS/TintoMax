package es.tintomax.server.repositories;

import es.tintomax.server.jpa.Ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
