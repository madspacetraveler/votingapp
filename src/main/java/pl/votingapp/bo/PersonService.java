package pl.votingapp.bo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.votingapp.dto.PersonDto;
import pl.votingapp.entity.Person;
import pl.votingapp.repository.PersonRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
    private final PersonRepository personRepository;

    public List<PersonDto> findPersons(){
        return personRepository.findAll()
                .stream()
                .map(this::mapPerson)
                .collect(Collectors.toList());
    }

    private PersonDto mapPerson(Person person) {
        return PersonDto.builder()
                .id(person.getId())
                .name(person.getName())
                .surname(person.getSurname())
                .build();
    }

    public List<String> findPersonsNameAndSurname(){
        return personRepository.findAll()
                .stream()
                .map(person -> person.getName()+" "+person.getSurname())
                .collect(Collectors.toList());
    }

    public Long countPersons() {
        return personRepository.count();
    }

    public PersonDto addPerson(PersonDto personDto) {
        Person person = mapToPerson(personDto);
        person = personRepository.save(person);
        return mapPerson(person);
    }

    private Person mapToPerson(PersonDto personDto) {
        return Person.builder()
                .id(personDto.getId())
                .name(personDto.getName())
                .surname(personDto.getSurname())
                .build();
    }

    public void deletePerson(Long id){
        personRepository.delete(id);
    }
}
