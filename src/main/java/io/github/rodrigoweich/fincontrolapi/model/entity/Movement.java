package io.github.rodrigoweich.fincontrolapi.model.entity;

import io.github.rodrigoweich.fincontrolapi.model.enums.MovementEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "movements")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column
    @Enumerated(EnumType.STRING)
    private MovementEnum movement;

}
