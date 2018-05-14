package pl.votingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.votingapp.entity.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
}
