package pl.grabowski_durka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Marcin
 */
@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
}
