package es.tintomax.server.repositories;

import es.tintomax.server.jpa.Detail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DetailRepository extends JpaRepository<Detail, Integer> {

}
