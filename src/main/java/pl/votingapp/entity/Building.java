package pl.votingapp.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "buildings", schema = "public")

public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adres")
    private String adres;

    @Column(name = "area")
    private float area;

    @Column(name = "flat_count")
    private int flatCount;
}
