package pl.votingapp.bo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.votingapp.dto.UserDto;
import pl.votingapp.entity.User;
import pl.votingapp.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    public final UserRepository userRepository;

    public List<UserDto> findUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapUser)
                .collect(Collectors.toList());
    }

    public Optional<UserDto> findUser(String name){
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getName().contains(name))
                .map(this::mapUser)
                .findFirst();
    }

    public long countUsers(){
        return userRepository.findAll()
                .stream()
                .count();
    }

    private UserDto mapUser(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getName())
                .role(user.getRank())
                .email(user.getEmail())
                .active(user.isActive())
                .build();
    }
}

