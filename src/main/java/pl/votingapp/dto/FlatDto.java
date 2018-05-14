package pl.votingapp.dto;

import lombok.*;
import pl.votingapp.entity.Building;
import pl.votingapp.entity.Owner;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlatDto {

    private Long id;
    private float area;
    private Building building;
    private int flatNumber;
    private Owner authorizedVoter;
    private boolean votesFor;
    private boolean votesAgainst;
    private boolean votesAbstain;
}





