package identifiers.composite.embedded.two;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class Course2Test {
    @Test
    public void shouldPersistCourse() {
        SessionFactory sessionFactory = new Configuration().
                configure().
                addAnnotatedClass(Course2.class).
                buildSessionFactory();

        Course2 course = new Course2("tit", "tut");
        course.setTotalStudents(40);
        try (Session session = sessionFactory.openSession()) {
            //save object
            Transaction transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();

            //get object
            Course2 persistedCourse = session.get(Course2.class, new CoursePK2("tut", "tit"));
            assertThat(persistedCourse.getId().getTitle()).isEqualTo("tit");
            assertThat(persistedCourse.getId().getTutor()).isEqualTo("tut");
            assertThat(persistedCourse.getTotalStudents()).isEqualTo(40);

            //remove object
            transaction = session.beginTransaction();
            session.delete(persistedCourse);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            fail("Fail!");
        }
    }

}