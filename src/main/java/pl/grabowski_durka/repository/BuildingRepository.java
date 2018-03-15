package pl.grabowski_durka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grabowski_durka.entity.Building;

/**
 * @author Marcin
 */
@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
}
