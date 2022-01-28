package io.github.rodrigoweich.fincontrolapi.entity;

import io.github.rodrigoweich.fincontrolapi.enums.MovementEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

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
    private Date createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = new Date();
    }

}
