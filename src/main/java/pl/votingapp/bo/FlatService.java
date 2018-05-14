package pl.votingapp.bo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.votingapp.dto.FlatDto;
import pl.votingapp.entity.Flat;
import pl.votingapp.repository.FlatRepository;
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
                .building(flat.getBuilding())
                .flatNumber(flat.getFlatNumber())
                .authorizedVoter(flat.getOwner())
                .build();
    }

    public List<FlatDto> findFlatsWithBuildingId(Long id) {
        return flatRepository.findByBuildingId(id)
                .stream().map(this::mapFlats)
                .collect(Collectors.toList());
    }

    public FlatDto findFlatById(Long id) {
        return mapFlats(flatRepository.findOne(id));
    }

    public Long countFlatsInBuilding(Long id){
        return flatRepository.findAll()
                .stream()
                .filter(flat -> flat.getFlatNumber()==(id))
                .count();
    }

    public Long countFlats(){
        return flatRepository.findAll()
                .stream()
                .count();
    }

    public Double allFlatsArea(){
        return flatRepository.findAll()
                .stream()
                .filter(flat -> flat.getArea() > 0)
                .mapToDouble(flat -> flat.getArea())
                .sum();
    }

    public Double allFlatsInBuildingArea(Long id){
        return flatRepository.findByBuildingId(id)
                .stream()
                .filter(flat -> flat.getArea() > 0)
                .mapToDouble(flat -> flat.getArea())
                .sum();
    }
}
