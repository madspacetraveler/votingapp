package pl.votingapp.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "flats", schema = "public")

public class Flat implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "area")
    private float area;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "buildingid")
    private Building building;

    @Column(name = "flat_number")
    private int flatNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "authorized_voter")
    private Owner owner;
}
