package es.tintomax.server.repositories;

import es.tintomax.server.jpa.Test;
import es.tintomax.server.jpa.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

	User findByName(String name);

}
