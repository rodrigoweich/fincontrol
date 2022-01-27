package io.github.rodrigoweich.fincontrolapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private Integer id;

//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;

    @Column
    private Integer user_id;

    @Column
    private MovementEnum movement;

}
