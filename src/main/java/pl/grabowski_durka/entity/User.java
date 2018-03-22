package pl.grabowski_durka.entity;

import com.sun.istack.internal.NotNull;
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

    @NotNull
    @Column(name="username")
    private String username;

    @NotNull
    @Column(name="email")
    private String email;

    @NotNull
    @Column(name="password")
    private String password;

    @NotNull
    @Column(name="rank")
    private String rank;

    @Column(name="active")
    private boolean active;

}
