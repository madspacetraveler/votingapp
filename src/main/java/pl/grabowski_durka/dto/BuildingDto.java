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
public class BuildingDto {

    private Long id;
    private String adres;
    private float area;
    private int flatCount;
}
