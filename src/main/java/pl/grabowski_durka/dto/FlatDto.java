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
public class FlatDto {

    private Long id;
    private float area;
    private Long buildingId;
    private int flatNumber;
    private String authorizedVoter;


}





