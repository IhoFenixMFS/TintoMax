package es.tintomax.server.repositories;

<<<<<<< HEAD
import es.tintomax.server.jpa.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByDni(String dni);

=======
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import es.tintomax.server.jpa.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	Page<User> findAll(Pageable pageable);
>>>>>>> 8cf3283d700caee76bea17da5432d519e0a79be4
}
