package control2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TablesStedentsTeacher {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()){
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Students students1 = Students.builder()
                 .name("Hris")
                 .surname("Luka")
                 .build();
            session.save(students1);

            Students students2 = Students.builder()
                    .name("Fedya")
                    .surname("Volk")
                    .build();
            session.save(students2);

            Teachers teacher1 = Teachers.builder()
                    .name("Opti")
                    .surname("Konnan")
                    .build();
            session.save(teacher1);

            Teachers teacher2 = Teachers.builder()
                    .name("Dima")
                    .surname("Feduk")
                    .build();
            session.save(teacher2);
            students1.getTeachers().add(teacher1);
            students2.getTeachers().add(teacher1);
            students2.getTeachers().add(teacher2);
            session.save(students1);
            session.save(students2);
            session.getTransaction().commit();
            session.close();

        }
    }
}
