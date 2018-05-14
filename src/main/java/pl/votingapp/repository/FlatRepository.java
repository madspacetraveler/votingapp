package pl.votingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.votingapp.entity.Flat;
import java.util.List;

@Repository
public interface FlatRepository extends JpaRepository<Flat, Long> {

    List<Flat> findByBuildingId(Long buildingId);
}
