package identifiers.composite.embedded.one;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class CourseTest {
    @Test
    public void shouldPersistCourse() {
        SessionFactory sessionFactory = new Configuration().
                configure().
                addAnnotatedClass(Course.class).
                buildSessionFactory();

        Course course = new Course();
        CoursePK coursePK = new CoursePK("tut", "tit");
        course.setId(coursePK);
        course.setTotalStudents(20);
        try (Session session = sessionFactory.openSession()) {
            //save object
            Transaction transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();

            //get object
            Course persistedCourse = session.get(Course.class, coursePK);
            assertThat(persistedCourse.getId().getTitle()).isEqualTo("tit");
            assertThat(persistedCourse.getId().getTutor()).isEqualTo("tut");
            assertThat(persistedCourse.getTotalStudents()).isEqualTo(20);

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