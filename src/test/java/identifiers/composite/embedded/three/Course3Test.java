package identifiers.composite.embedded.three;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class Course3Test {
    @Test
    public void shouldPersistCourse() {
        SessionFactory sessionFactory = new Configuration().
                configure().
                addAnnotatedClass(Course3.class).
                buildSessionFactory();

        Course3 course = new Course3();
        course.setTitle("title");
        course.setTutor("tutor");
        course.setTotalStudents(60);
        try (Session session = sessionFactory.openSession()) {
            //save object
            Transaction transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();

            //get object
            Course3 persistedCourse = session.get(Course3.class, new CoursePK3("tutor", "title"));
            assertThat(persistedCourse.getTitle()).isEqualTo("title");
            assertThat(persistedCourse.getTutor()).isEqualTo("tutor");
            assertThat(persistedCourse.getTotalStudents()).isEqualTo(60);

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