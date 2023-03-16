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
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @Builder.Default
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "students_teachers",
            joinColumns =  @JoinColumn(name = "students_id"),
            inverseJoinColumns= @JoinColumn(name = "teachers_id") )
    private Set<Teachers> teachers = new HashSet<Teachers>();
}
