package es.tintomax.server.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import es.tintomax.server.jpa.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	Page<User> findAll(Pageable pageable);
}
