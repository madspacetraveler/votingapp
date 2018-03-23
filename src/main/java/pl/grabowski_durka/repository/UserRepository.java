package pl.grabowski_durka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grabowski_durka.entity.User;

import java.util.List;

/**
 * @author Marcin
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);

}
