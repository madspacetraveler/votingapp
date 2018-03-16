package pl.grabowski_durka.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Marcin
 */

@Data
@Entity
@Table(name = "buildings", schema = "public")

public class Building {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "adres")
    private String adres;

    @Column(name = "area")
    private float area;

    @Column(name = "flat_count")
    private int flatCount;

}
