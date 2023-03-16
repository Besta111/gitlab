package control2;

import javax.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

//    @Column
//    private long id_students;
    @Builder.Default
    @ManyToMany(mappedBy = "teachers")
    private Set<Students> students = new HashSet<Students>();
}

