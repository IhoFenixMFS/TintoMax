package es.tintomax.server.repositories;

import es.tintomax.server.jpa.Receipt;
import org.springframework.data.repository.CrudRepository;

public interface ReceiptRepository extends CrudRepository<Receipt, Integer> {

}
