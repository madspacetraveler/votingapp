package pl.votingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.votingapp.entity.Voting;

@Repository
public interface VotingRepository extends JpaRepository<Voting, Long> {
}
