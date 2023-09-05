package de.ait.group7aitendproject.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@EqualsAndHashCode(of = {"id", "email"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "account")
public class User {

    public enum Role {
        ADMIN,
        FREELANCER,
        EMPLOYER
    }

    public enum State {
        CONFIRMED,
        DELETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private State state;


    @Column(nullable = false)
    private String hashPassword;

    @ManyToMany
    @JoinTable(name = "employers_adverts",
            joinColumns = @JoinColumn(name = "employer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "advert_id", referencedColumnName = "id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"employer_id", "advert_id"}))
    private Set<Advert> adverts;
}