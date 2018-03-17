package pl.grabowski_durka.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Marcin
 */

@Data
@Entity
@Table(name = "buildings", schema = "public")

public class Flat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "area")
    private float area;

    @Column(name = "buildingId")
    private Long buildingId;

    @Column(name = "flat_number")
    private int flatNumber;

    @Column(name = "authorized_voter")
    private Long authorizedVoter;

}
