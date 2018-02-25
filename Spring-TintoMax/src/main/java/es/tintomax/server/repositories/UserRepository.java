package es.tintomax.server.repositories;

import es.tintomax.server.jpa.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByDni(String dni);

}
