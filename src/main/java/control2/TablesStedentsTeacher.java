package control2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TablesStedents {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()){
         Session session = sessionFactory.openSession();

         Students students1 = Students.builder()
                 .name("Hris")
                 .surname("Luka")
                 .id_teacher(1)
                 .build();
         session.save(students1);

            Students students2 = Students.builder()
                    .name("Fedya")
                    .surname("Volk")
                    .id_teacher(1)
                    .build();
            session.save(students2);

            Teacher teacher1 = Teacher.builder()
                    .name("Opti")
                    .surname("Konnan")
                    .id_students(1)
                    .build();
            session.save(teacher1);

            Teacher teacher2 = Teacher.builder()
                    .name("Dima")
                    .surname("Feduk")
                    .id_students(2)
                    .build();
            session.save(teacher2);

            session.close();

//            Students students = session.get(Students.class,1);
//            System.out.println(students1);



        }
    }
}
