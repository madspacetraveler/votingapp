package pl.votingapp.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class AccountDto {

    private Long id;
    private String username;
    private String email;
    private String password;
    private String role;
    private boolean active;
}
