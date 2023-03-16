package control2;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name" ,nullable = false)
    private String name;

    @Column(name = "surname" ,nullable = false)
    private String surname;

    @Column(name = "id_teacher" ,nullable = false)
    private String id_teacher;
}
