package es.tintomax.server.repositories;

import es.tintomax.server.jpa.Garment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface GarmentRepository extends CrudRepository<Garment, Integer> {

}
