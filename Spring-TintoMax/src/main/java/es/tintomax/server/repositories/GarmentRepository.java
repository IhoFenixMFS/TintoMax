package es.tintomax.server.repositories;

import es.tintomax.server.jpa.Garment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface GarmentRepository extends CrudRepository<Garment, Integer> {

	Page <Garment> findAll(Pageable page);
	
}
