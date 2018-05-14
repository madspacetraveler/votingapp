package pl.votingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.votingapp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByName(String username);
}
