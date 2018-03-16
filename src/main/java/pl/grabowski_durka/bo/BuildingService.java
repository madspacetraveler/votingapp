package pl.grabowski_durka.bo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grabowski_durka.dto.BuildingDto;
import pl.grabowski_durka.entity.Building;
import pl.grabowski_durka.repository.BuildingRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcin
 */
@Service
/*@RequiredArgsConstructor(onConstructor = @__(@Autowired))*/
public class BuildingService {

    private final BuildingRepository buildingRepository;
    private List<BuildingDto> buildings = new ArrayList<>();

    @Autowired
    public BuildingService(BuildingRepository buildingRepository){
        this.buildingRepository=buildingRepository;
    }

    public List<BuildingDto> getBuildings(){
        List<BuildingDto> buildings = new ArrayList<>();
        return buildings;
    }

    public List<BuildingDto> findBuildings(){
        return this.buildings;
    }


}
