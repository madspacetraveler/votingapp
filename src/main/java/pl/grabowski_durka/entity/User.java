package pl.grabowski_durka.entity;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.*;

/**
 * @author Marcin
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="rank")
    private String rank;
}
