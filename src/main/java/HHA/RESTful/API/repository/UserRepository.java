package HHA.RESTful.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import HHA.RESTful.API.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByUsername(String username);
}
