package springboot.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.test.model.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
}
