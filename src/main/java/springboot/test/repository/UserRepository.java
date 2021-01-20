package springboot.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.test.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}
