package es.tintomax.server.repositories;

import es.tintomax.server.jpa.Garment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface GarmentRepository extends JpaRepository<Garment, Integer> {

}
