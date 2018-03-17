package pl.grabowski_durka.dto;

import lombok.*;

/**
 * @author Marcin
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OwnerDto {

    private Long id;
    private String name;
    private String surname;
    private int pesel;
    private String email;
    private int phone;
}
