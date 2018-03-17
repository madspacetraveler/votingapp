package pl.grabowski_durka.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Marcin
 */

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
    private int pesel;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private int phone;

}
