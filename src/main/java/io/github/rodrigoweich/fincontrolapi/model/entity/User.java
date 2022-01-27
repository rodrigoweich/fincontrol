package io.github.rodrigoweich.fincontrolapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "users")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Boolean superUser;

//    @JsonIgnore
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY, optional = true)
//    private Movement movement;

    @PrePersist
    public void prePersist() {
        superUser = false;
    }
}
