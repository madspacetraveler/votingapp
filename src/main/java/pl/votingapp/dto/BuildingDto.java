package pl.votingapp.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuildingDto {

    private Long id;
    private String adres;
    private float area;
    private int flatCount;
}
