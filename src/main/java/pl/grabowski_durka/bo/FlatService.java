package pl.grabowski_durka.bo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grabowski_durka.dto.FlatDto;
import pl.grabowski_durka.entity.Flat;
import pl.grabowski_durka.repository.FlatRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlatService {

    private final FlatRepository flatRepository;

    public List<FlatDto> findFlats() {
        return flatRepository.findAll()
                .stream()
                .map(this::mapFlats)
                .collect(Collectors.toList());
    }

    private FlatDto mapFlats(Flat flat) {
        return FlatDto.builder()
                .id(flat.getId())
                .area(flat.getArea())
                .building(flat.getBuildingId())
                .flatNumber(flat.getFlatNumber())
                .authorizedVoter(flat.getOwner())
                .build();
    }

    public List<FlatDto> findFlatsWithBuildingId(Long id) {
        return flatRepository.findByBuildingId(id)
                .stream().map(this::mapFlats)
                .collect(Collectors.toList());
    }


}
