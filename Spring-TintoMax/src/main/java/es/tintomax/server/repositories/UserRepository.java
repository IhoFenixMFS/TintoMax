package es.tintomax.server.repositories;

import es.tintomax.server.jpa.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String dni);
}
