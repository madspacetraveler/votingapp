package pl.grabowski_durka.bo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grabowski_durka.dto.BuildingDto;
import pl.grabowski_durka.entity.Building;
import pl.grabowski_durka.repository.BuildingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Marcin
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BuildingService {

    private final BuildingRepository buildingRepository;
    private List<BuildingDto> buildings = new ArrayList<>();


    public List<BuildingDto> findBuildings(){
        return buildingRepository.findAll()
                .stream()
                .map(this::mapBuilding)
                .collect(Collectors.toList());
    }

    private BuildingDto mapBuilding(Building building) {
        return BuildingDto.builder()
                .id(building.getId())
                .adres(building.getAdres())
                .area(building.getArea())
                .flatCount(building.getFlatCount())
                .build();
    }


}
