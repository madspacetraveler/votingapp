package pl.votingapp.bo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.votingapp.dto.BuildingDto;
import pl.votingapp.entity.Building;
import pl.votingapp.repository.BuildingRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BuildingService {

    private final BuildingRepository buildingRepository;

    private BuildingDto mapBuilding(Building building) {
        return BuildingDto.builder()
                .id(building.getId())
                .adres(building.getAdres())
                .area(building.getArea())
                .flatCount(building.getFlatCount())
                .build();
    }

    public Long countBuildings(){
        return buildingRepository.findAll().stream().count();
    }

    public BuildingDto findBuildingById(Long id){
        return mapBuilding(buildingRepository.findOne(id));
    }

    public List<BuildingDto> findBuildings(){
        return buildingRepository.findAll()
                .stream()
                .map(this::mapBuilding)
                .collect(Collectors.toList());
    }
}