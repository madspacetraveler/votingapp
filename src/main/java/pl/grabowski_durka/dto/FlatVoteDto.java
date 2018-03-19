package pl.grabowski_durka.dto;

import lombok.*;
import pl.grabowski_durka.entity.Building;
import pl.grabowski_durka.entity.Owner;

/**
 * @author Marcin
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlatVoteDto {

    private Long id;
    private float area;
    private Building building;
    private int flatNumber;
    private Owner authorizedVoter;
    private boolean votesFor;
    private boolean votesAgainst;
    private boolean votesAbstain;

}





