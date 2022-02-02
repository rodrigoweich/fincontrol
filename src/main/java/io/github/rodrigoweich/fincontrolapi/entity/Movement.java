package io.github.rodrigoweich.fincontrolapi.entity;

import io.github.rodrigoweich.fincontrolapi.enums.MovementEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

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

    @CreatedDate
    @Column
    private LocalDate createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDate.now();
    }

}
