package es.tintomax.server.repositories;

import es.tintomax.server.jpa.Bill;
import org.springframework.data.repository.CrudRepository;

public interface BillRepository extends CrudRepository<Bill, Integer> {

}
