package pl.grabowski_durka.bo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grabowski_durka.dto.FlatDto;
import pl.grabowski_durka.dto.OwnerDto;
import pl.grabowski_durka.entity.Flat;
import pl.grabowski_durka.entity.Owner;
import pl.grabowski_durka.repository.OwnerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private List<OwnerDto> owners = new ArrayList<>();

    public List<OwnerDto> findOwners() {
        return ownerRepository.findAll()
                .stream()
                .map(this::mapOwners)
                .collect(Collectors.toList());
    }

    public Long countOwners(){
        return ownerRepository.findAll().stream().count();
    }

    public OwnerDto findOwnerById(Long id){
        return mapOwners(ownerRepository.findOne(id));
    }

    private OwnerDto mapOwners(Owner owner) {
        return OwnerDto.builder()
        .id(owner.getId())
        .name(owner.getName())
        .surname(owner.getSurname())
        .pesel(owner.getPesel())
        .email(owner.getEmail())
        .phone(owner.getPhone())
        .build();
    }


    public OwnerDto findOwnerOfFlat(Long id){
        return owners
                .stream()
                .filter(owner -> owner.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new NoSuchElementException());
    }



}
