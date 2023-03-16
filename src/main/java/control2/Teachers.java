package control2;

import jakarta.persistence.*;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="teacher")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

//    @Column
//    private long id_students;
    @Builder.Default
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name ="studetsTeacher",
            joinColumns =  @JoinColumn(name = "teacher_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "students_id", referencedColumnName = "id") )
    private Set<Students> tasks = new HashSet<Students>();

}

