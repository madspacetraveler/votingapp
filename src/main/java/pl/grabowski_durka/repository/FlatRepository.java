package pl.grabowski_durka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grabowski_durka.entity.Flat;

import java.util.List;

@Repository
public interface FlatRepository extends JpaRepository<Flat, Long> {

    List<Flat> findByBuildingId(Long buildingId);
}
