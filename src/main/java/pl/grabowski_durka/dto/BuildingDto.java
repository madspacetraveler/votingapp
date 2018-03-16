package pl.grabowski_durka.dto;

import lombok.*;

import javax.persistence.Id;

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
