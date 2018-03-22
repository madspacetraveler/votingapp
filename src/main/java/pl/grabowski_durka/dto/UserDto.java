package pl.grabowski_durka.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

/**
 * @author Marcin
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String matchingPassword;
    private String rank;
    private boolean active;
}
