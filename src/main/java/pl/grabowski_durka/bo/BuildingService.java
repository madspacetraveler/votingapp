package pl.grabowski_durka.bo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grabowski_durka.dto.BuildingDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcin
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BuildingService {

    private List<BuildingDto> buildings = new ArrayList<>();

    public List<BuildingDto> findBuildings(){
        return this.buildings;
    }



}
