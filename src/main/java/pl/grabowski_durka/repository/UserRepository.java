package pl.grabowski_durka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.grabowski_durka.entity.User;

/**
 * @author Marcin
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
