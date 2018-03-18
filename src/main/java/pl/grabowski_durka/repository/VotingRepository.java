package pl.grabowski_durka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grabowski_durka.entity.Flat;
import pl.grabowski_durka.entity.Voting;

@Repository
public interface VotingRepository extends JpaRepository<Voting, Long> {
}
