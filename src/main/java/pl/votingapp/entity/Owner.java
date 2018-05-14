package pl.votingapp.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "owners", schema = "public")

public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "pesel")
    private Long pesel;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private Long phone;
}
