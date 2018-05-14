package pl.votingapp.entity;

import javax.persistence.*;

@lombok.Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username")
    private String name;

    @Column(name="email")
    private String email;


    @Column(name="password")
    private String password;

    @Column(name="rank")
    private String rank;

    @Column(name="active")
    private boolean active;
}
