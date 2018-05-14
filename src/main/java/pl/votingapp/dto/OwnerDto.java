package pl.votingapp.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OwnerDto {

    private Long id;
    private String name;
    private String surname;
    private Long pesel;
    private String email;
    private Long phone;
}
